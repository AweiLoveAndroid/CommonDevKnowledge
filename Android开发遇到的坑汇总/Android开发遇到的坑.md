# Android开发遇到的坑汇总

----

#### 1、Toolbar去除标题与返回键间的间距

给toolbar加上以下属性：

    app:navigationIcon="@drawable/icon_back" //这是设置返回键图标，这是必不可少的。 
    app:contentInsetStartWithNavigation="0dp"


为了保险起见，建议加上这两个属性：

    app:contentInsetLeft="0dp"
    app:contentInsetStart="0dp"

完整的示范如下：

	<android.support.v7.widget.Toolbar xmlns:app="http://schemas.android.com/apk/res-auto" 
		android:id="@+id/title_tool_bar" 
		android:layout_width="match_parent" 
		android:layout_height="?attr/actionBarSize" 
		android:background="@color/colorTheme" 
		app:contentInsetLeft="0dp" 
		app:contentInsetStart="0dp" 
		app:contentInsetStartWithNavigation="0dp" 
		app:layout_scrollFlags="enterAlways|scroll" 
		app:navigationIcon="@drawable/icon_back" 
		app:popupTheme="@style/ThemeOverlay.AppCompat.Light" 
		app:theme="@style/ToolbarStyle" 
		app:title="标题" 
		app:titleTextColor="@color/colorWhite">
		
#### 2、RecyclerView常见的一些坑

> 问题1、ScrollView(或RecyclerView1)嵌套RecyclerView2,结果内部的RecyclerView2会自动的滑动至顶部.（一般情况下不推荐嵌套使用具有滑动功能的View）
两种解决办法：

**方法一** 让内部Recyclerview去除焦点，父布局里获得焦点。具体如下：

给内部的Recyclerview设置以下代码：

    recyclerview.setFocusableInTouchMode(false);
    recyclerview.requestFocus();

比如父布局的一个textview。

    textview.setFocusableInTouchMode(true);  
    textview.requestFocus(); 

**方法二** 在布局里面加相关属性：

内部的Recyclerview加这个属性：

    android:overScrollMode="never"
父布局覆盖子View获取焦点，加这个属性：

    android:descendantFocusability="blocksDescendants"

> 问题2、RecyclerView 高度设置wrap_content 不显示的解决：

给RecyclerView的高度设置为`wrap_content`，结果整个模块什么也不显示，这是RecyclerView兼容包的bug，`23.2.0后`官方已经修复了。

【解决方式】在gradle里设置用23.2.0及以上的RecyclerView版本：

    compile 'com.android.support:recyclerview-v7:23.2.0'

如果修改后重新build时报了其他奇怪的错，可以试试把以下相关兼容包也升级一下：

    compile 'com.android.support:cardview-v7:23.2.0'
    compile 'com.android.support:appcompat-v7:23.2.0'
    compile 'com.android.support:design:23.2.0'

> 问题3、RecyclerView 中的item布局宽度设置match_parent属性失效的问题解决：

 //这里为了解决RecyclerView不能撑满全屏的问题，这里layoutManager不管你布局里是否设置，都不能解决问题，所以需要在代码里`重新设置MATCH_PARENT`
 
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity()) {
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        };
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
关于为什么`RecyclerView 中的item布局宽度设置match_parent属性失效`的原因详解可以参考这篇博客，有详细介绍：[https://blog.csdn.net/overseasandroid/article/details/51840819](https://blog.csdn.net/overseasandroid/article/details/51840819)

#### 3、NumberFormatException

起因是Bugly上报了一个错误：

    #main(1)
    java.lang.NumberFormatException
    Invalid float "0,00"

说是我格式化“0,00”这样的一个字符串。出错的地方的代码大致如下：

    String.format("%.2f", number);

经排查排除了格式字符串的问题后，最后发现是格式化的问题：`在不指定Locale时，是跟随系统语言`。在法语、德语、意大利语的语言中，格式化小数是逗号的。所以解决方法，指定一下语言：

    String.format(Locale.CHINA, "%.2f", number);    
    
#### 4、SecurityException

在之前项目中做了6.0的动态权限后，Bugly报错如下，而且报错的全部都是6.0的手机：
报错的意思翻译一下是：没有动态授权`CHANGE_NETWORK_STATE`和`WRITE_SETTINGS`权限。

查了一下，找到了问题。发现是6.0的一个bug，在部分6.0上CHANGE_NETWORK_STATE权限获取不到，那么只能去获取WRITE_SETTINGS这个权限了。这个问题已经在6.0.1修复了。关于这个bug详细讲解可以查看博客 [Android M WRITE_SETTINGS权限的一个BUG](https://www.jianshu.com/p/bab716584316)

> 解决方式1
> 
> 既然是6.0的问题，我们可以对6.0进行单独处理。抛出异常处或者在使用`CHANGE_NETWORK_STATE`权限前跳转到系统设置页去设置。

	if(Build.VERSION.SDK_INT == Build.VERSION_CODES.M) {
	     if (!Settings.System.canWrite(context)) {
	         Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS);
	         intent.setData(Uri.parse("package:" + context.getPackageName()));
	         intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	         context.startActivity(intent);
	      } 
	} 
	
> 解决方式2
> 
> 以上方式每次都要手动去设置，很麻烦，可以看看这篇博文，写的很仔细 [Android 6 完美解决 WRITE_SETTINGS 权限设置问题](https://www.jianshu.com/p/0b880871b887)

#### 5、在做6.0动态权限时，如果有申请相机权限时，应该保证`Manifest.permission.CAMERA`和`Manifest.permission.WRITE_EXTERNAL_STORAGE`权限同时申请，不要漏掉后者。

#### 6、使用Glide时，注意对传入的Acticity与Fragment进行判断，避免传入已经销毁Acticity，造成`IllegalArgumentException`异常。可以参考这篇[Glide类似You cannot start a load for a destroyed activity异常简单分析](https://blog.csdn.net/loners_/article/details/73521968)

#### 7、不要在Android的Application对象中缓存数据，具体的可以参考[这篇文章](https://www.jianshu.com/p/83f0046bc310)

#### 8、关于资源目录引用问题（经常会遇到的）
	
    //这个是正确使用方式
    textView.setTextColor(getResources().getColor(R.color.colorAccent));
    //下面这个报错
    textView.setTextColor(R.color.colorAccent);

> 分析：setTextColor方法的参数是 @ColorInt类型的，使用`getResources().getColor(R.color.colorAccent)`返回的是` @ColorInt`类型的int值，直接使用`R.color.colorAccent`的方式属于`@ColorRes`类型的int值。


#### 9、fragment的坑（这是一个大坑，很多人都遇到过的）

> 问题1、getActivity()空指针
> 
> 问题2、异常：Can not perform this action after onSaveInstanceState
> 
> 问题3、Fragment重叠异常—–如何正确使用hide、show？

> 问题4、Fragment嵌套的那些坑？

> 问题5、不靠谱的出栈方法remove()

> 问题6、多个Fragment同时出栈的那些深坑BUG

> 问题7、超级深坑 Fragment转场动画

关于这些坑的具体介绍可以看博客[Fragment全解析系列（一）：那些年踩过的坑](https://www.jianshu.com/p/d9143a92ad94)

解决方案，可以看这个库 [Fragmentation](https://github.com/YoKeyword/Fragmentation)

----

> 参考博文：

* https://blog.csdn.net/qq_17766199/article/details/52661363
* https://blog.csdn.net/qq_17766199/article/details/79941199
* https://blog.csdn.net/geolo/article/details/7058515

----

> **【说明】我这个总结主要是针对平时开发遇到的问题的一个汇总，由于实际开发项目不同，用到的技术和接触的一些东西也不一样，所以可能这里找不到你遇到的坑，不过没关系，我发现了一个github总结的很全面，有基础的使用，有NDK遇到的坑，有framework层的坑，有linux有关的坑等。。。如果对你有帮助的话，有兴趣的也可以过去看一下：[android-issues](https://github.com/ayyb1988/android-issues)**

----

#### 有什么问题，欢迎大家提出，如果你也遇到了其他的坑，也欢迎提交给我，我会把它收集在这里，让大家都来学习一下，避免少走弯路。