本文转载自：https://zhuanlan.zhihu.com/p/30879859

# 四大组件相关：

1.启动一个Activity，在应用进程至少需要两个Binder线程。

2.启动一个launchMode为singleTask的Activity，它并不一定会运行在新的Activity栈中。

3.两个不同应用的Activity，可以运行在同一个Activity栈中。

4.同一个应用进程中的所有Activity，共享一个WindowSession。

5.弹出一个AlertDialog，不一定需要Activity级别的Context，而且任何地方都有办法弹出一个AlertDialog，只要是在Application的attachBaseContext之后。

下面是一个简单的demo演示：

首先看DemoApplication，然后看Alert类：

> 在Application中初始化：

    import android.app.Application;

    public class DemoApplication extends Application {
        @Override
        public void onCreate() {
            Alert.alertAnyWhere();
            super.onCreate();
        }
    }


> 下面这个类是对AlertDialog的封装类：


    import android.app.AlertDialog;
    import android.content.Context;
    import android.content.DialogInterface;
    import android.os.Build;
    import android.os.Handler;
    import android.os.Looper;
    import android.view.WindowManager;
    import java.lang.reflect.Method;

	public class Alert {

	    public static void alertDialog() {
	        Context mAppContext = null;
	        try {
	            Class<?> clazz = Class.forName("android.app.ActivityThread");
	            Method method = clazz.getDeclaredMethod("currentApplication", new Class[0]);
	            mAppContext = (Context) method.invoke(null, new Object[0]);
	        } catch (Throwable e) {
	            e.printStackTrace();
	            return;
	        }

	        AlertDialog.Builder builder = new AlertDialog.Builder(mAppContext);
	        builder.setTitle("Hi")
	               .setMessage("Hello World");
	               .setPositiveButton("确定", new DialogInterface.OnClickListener() {
	                    @Override
	                    public void onClick(DialogInterface dialog, int which) {
	                        dialog.dismiss();
						}
	        		})
	        		.setNegativeButton("取消", new DialogInterface.OnClickListener() {
	            		@Override
	            		public void onClick(DialogInterface dialog, int which) {
	            		}
	        		});
	        AlertDialog dialog = builder.create();
	        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
	            dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
	        } else {
	            dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_PHONE);
	        }
	        dialog.show();
	    }


	    private static Handler handler;

	    public static void alertAnyWhere() {
	        if (Looper.myLooper() == Looper.getMainLooper()) {
	            alertDialog();
	        } else {
	            if (handler == null) {
	                handler = new Handler(Looper.getMainLooper());
	            }
	            handler.post(new Runnable() {
	                @Override
	                public void run() {
	                    alertDialog();
	                }
	            });
	        }
	    }

	}





6.可以通过设置Activity主题android.R.style.Theme_NoDisplay，来启动一个不显示的Activity，在某些需要过渡的地方很实用。

7.Activity、Service、Receiver在没有配置intent-filter的action属性时，exported默认为false，配置了intent-filter的action属性时，exported默认为true。稍有不慎，很可能埋下越权、Intent攻击等安全隐患。

8.当从最近使用应用列表中移除某个App时，四大组件只有Service拥有神奇的onTaskRemoved回调，但是并不一定回调，还与stopWithTask属性等有关。

9.四大组件都运行在主线程，是因为它们在ActityThread中（或Instrumentation）实例化；它们的生命周期也运行在主线程，是因为通过ActivityThread.H将消息从Binder线程发送到主线程，然后执行回调。

10.TaskStackBuilder的出现基本上解决了所有构造Activity回退栈的问题。

11.ContentProvider的onCreate()方法先于Application的onCreate()方法执行，晚于Application的attachBaseContext()方法，所以在ContentProvider的onCreate()时候也是有办法弹出一个AlertDialog的（参考5）。

12.BroadCastReceiver回调onReceive(Context context,Intent intent)中的context类型各种场景相差很大，静态注册的receiver回调的Context都是ReceiverRestrictedContext，动态注册的receiver有可能是Activity或Application。

13.ServiceRecord和BroadcastRecord自身就是Binder。

14.同一个provider组件名，可能对应多个provider。



# Handler、Message相关：

1.MessageQueue.addIdleHandler可以用来在线程空闲的时候，完成某些操作，比较适合那种需要在将来执行操作，却又不知道需要指定多少延迟时间的操作。

2.Message.what尽量不要设置成0，因为postRunnable的方式会生成Message.what为0的消息，如果删除了what为0的Message，也会将runnable方式创建的Message删掉。

3.Handler可以设置同步异步（默认是同步的），他们的区别在于异步不会被Barrier阻塞，而同步会被阻塞。

4.Handler的消息分发流程是如果Message的callback不为空，通过callback处理，如果Handler的mCallback不为空，通过mCallback来处理，如果前两个都为空，才调用handleMessage来处理。在DroidPlugin中，便是利用ActivityThread.H的这一特性，拦截了部分消息，实现Activity的插件化。

5.Java层和Native层Looper、MessageQueue的创建时序，Java层Looper—>Java层MessageQueue—>Native层NativeMessageQueue—>Native层Looper。

6.Java层通过Handler去发送消息，而Native层是通过Looper发消息。



# Window、View相关：

1.硬件加速在Window级只能开不能关，View级只能关不能开。

2.自android2.3删除MidWindow后，PhoneWindow成了Window的唯一实现类。

3.WMS管理Window的过程中涉及4个Binder，应用进程只有ViewRootImpl.W一个Binder服务端。

4.MotionEvent、KeyEvent、DragEvent等具有相似的链式缓存，类似Message。

5.在View的状态保存、恢复过程中，ActionBar中所有View共享一个SparseArray容器，ContentView中所有View共享一个SparseArray容器。当前获取焦点的View会额外存储。

6.设置ViewTreeObserver的系列监听方法需要确保View在attachToWindow之后，否则可能因为add监听和remove监听不是作用于同一个对象而引起内存泄漏等。



# Binder、IPC、进程等相关

1.可以通过文件锁来实现进程间互斥（参考：RePlugin），在处理某些只需要单进程执行的任务时很实用。

2.Binder设计架构中，只有Binder主线程是由本进程主动创建，Binder普通线程都是由Binder驱动根据IPC通信需求被动创建。

3.oneway与非oneway，都需要等待Binder Driver的回应消息（BR_TRANSACTION_COMPLETE），区别在于oneway不用等待BR_REPLY消息。

4.mediaserver和servicemanager的主线程都是binder线程，但system_server的主线程不是Binder线程，system_server主线程的玩法跟应用进程一样。

5.同一个BpBinder可以注册多个死亡回调，但Kernel只允许注册一次死亡通知。

6.应用进程由Zygote进程孵化而来，在它真正成为应用进程之前，系统通过抛异常的方式来清理栈帧，并反射调用ActivityThread的main方法。

7.在Binder通信的过程中，数据是从发起通信进程的用户空间直接写到目标进程内核空间，内核空间的数据释放是由用户空间控制的。

