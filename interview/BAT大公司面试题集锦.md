# BAT大公司面试题集锦

> 1、阿里巴巴

* LRUCache原理
* 图片加载原理
* 模块化实现（好处，原因）
* JVM
* 视频加密传输
* 统计启动时长,标准
* 如何保持应用的稳定性
* ThreadLocal 原理
* 谈谈classloader
* 动态布局
* 热修复,插件化
* HashMap源码,SpareArray原理
* 性能优化,怎么保证应用启动不卡顿
* 怎么去除重复代码
* SP是进程同步的吗?有什么方法做到同步
* 介绍下SurfView
* HashMap实现原理，ConcurrentHashMap 的实现原理
* BroadcastReceiver，LocalBroadcastReceiver 区别
* Bundle 机制
* Handler 机制
* android 事件传递机制
* 线程间 操作 List
* App启动流程，从点击桌面开始
* 动态加载
* 类加载器
* OSGI
* Https请求慢的解决办法，DNS，携带数据，直接访问IP
* GC回收策略
* 画出 Android 的大体架构图
* 描述清点击 Android Studio 的 build 按钮后发生了什么
* 大体说清一个应用程序安装到手机上时发生了什么；
* 对 Dalvik、ART 虚拟机有基本的了解；
* Android 上的 Inter-Process-Communication 跨进程通信时如何工作的；
* App 是如何沙箱化，为什么要这么做；
* 权限管理系统（底层的权限是如何进行 grant 的）
* 进程和 Application 的生命周期；
* 系统启动流程 Zygote进程 –> SystemServer进程 –> 各种系统服务 –> 应用进程
* recycleview listview 的区别,性能
* 排序，快速排序的实现
* 树：B+树的介绍
* 图：有向无环图的解释
* TCP/UDP的区别
* synchronized与Lock的区别
* volatile
* Java线程池
* Java中对象的生命周期
* 类加载机制
* 双亲委派模型
* Android事件分发机制
* MVP模式
* RxJava
* 抽象类和接口的区别
* 集合 Set实现 Hash 怎么防止碰撞
* JVM 内存区域 开线程影响哪块内存
* 垃圾收集机制 对象创建，新生代与老年代
* 二叉树 深度遍历与广度遍历
* B树、B+树
* 消息机制
* 进程调度
* 进程与线程
* 死锁
* 进程状态
* JVM内存模型
* 并发集合了解哪些
* ConCurrentHashMap实现
* CAS介绍
* 开启线程的三种方式,run()和start()方法区别
* 线程池
* 常用数据结构简介
* 判断环（猜测应该是链表环）
* 排序，堆排序实现
* 链表反转

> 2、腾讯

* synchronized用法
* volatile用法
* 动态权限适配方案，权限组的概念
* 网络请求缓存处理，okhttp如何处理网络缓存的
* 图片加载库相关，bitmap如何处理大图，如一张30M的大图，如何预防OOM
* 进程保活
* listview图片加载错乱的原理和解决方案
* https相关，如何验证证书的合法性，https中哪里用了对称加密，哪里用了非对称加密，对加密算法（如RSA）等是否有了解

> 3、滴滴

* MVP
* 广播（动态注册和静态注册区别，有序广播和标准广播）
* service生命周期
* handler实现机制（很多细节需要关注：如线程如何建立和退出消息循环等等）
* 多线程（关于AsyncTask缺陷引发的思考）
* 数据库数据迁移问题
* 设计模式相关（例如Android中哪里使用了观察者模式，单例模式相关）
* x个苹果，一天只能吃一个、两个、或者三个，问多少天可以吃完
* TCP与UDP区别与应用（三次握手和四次挥手）涉及到部分细节（如client如何确定自己发送的消息被server收到） HTTP相关 提到过Websocket 问了WebSocket相关以及与socket的区别
* 是否熟悉Android jni开发，jni如何调用java层代码
* 进程间通信的方式
* java注解
* 计算一个view的嵌套层级
* 项目组件化的理解
* 多线程断点续传原理
* Android系统为什么会设计ContentProvider，进程共享和线程安全问题
* jvm相关
* Android相关优化（如内存优化、网络优化、布局优化、电量优化、业务优化）
* EventBus实现原理

> 4、美团

* static synchronized 方法的多线程访问和作用，同一个类里面两个synchronized方法，两个线程同时访问的问题
* 内部类和静态内部类和匿名内部类，以及项目中的应用
* handler发消息给子线程，looper怎么启动
* View事件传递
* activity栈
* 封装view的时候怎么知道view的大小
* arraylist和linkedlist的区别，以及应用场景
* 怎么启动service，service和activity怎么进行数据交互
* 下拉状态栏是不是影响activity的生命周期，如果在onStop的时候做了网络请求，onResume的时候怎么恢复
* view渲染

> 5、今日头条

* 数据结构中堆的概念，堆排序
* 死锁的概念，怎么避免死锁
* ReentrantLock 、synchronized和volatile（n面）
* HashMap
* singleTask启动模式
* 用到的一些开源框架，介绍一个看过源码的，内部实现过程。
* 消息机制实现
* ReentrantLock的内部实现
* App启动崩溃异常捕捉
* 事件传递机制的介绍
* ListView的优化
* 二叉树，给出根节点和目标节点，找出从根节点到目标节点的路径
* 模式MVP，MVC介绍
* 断点续传的实现
* 集合的接口和具体实现类，介绍
* TreeMap具体实现
* synchronized与ReentrantLock
* 手写生产者/消费者模式
* 逻辑地址与物理地址，为什么使用逻辑地址
* 一个无序，不重复数组，输出N个元素，使得N个元素的和相加为M，给出时间复杂度、空间复杂度。手写算法
* .Android进程分类
* 前台切换到后台，然后再回到前台，Activity生命周期回调方法。弹出Dialog，生命值周期回调方法。
* Activity的启动模式

> 6、爱奇艺

* RxJava的功能与原理实现
* RecycleView的使用，原理，RecycleView优化
* ANR的原因
* 四大组件
* Service的开启方式
* Activity与Service通信的方式
* Activity之间的通信方式
* HashMap的实现，与HashSet的区别
* JVM内存模型，内存区域
* Java中同步使用的关键字，死锁
* MVP模式
* Java设计模式，观察者模式
* Activity与Fragment之间生命周期比较
* 广播的使用场景
 
> 7、百度

* Bitmap 使用时候注意什么？
* Oom 是否可以try catch ？
* 内存泄露如何产生？
* 适配器模式，装饰者模式，外观模式的异同？
* ANR 如何产生？
* String buffer 与string builder 的区别？
* 如何保证线程安全？
* java四中引用
* Jni 用过么？
* 多进程场景遇见过么？
* 关于handler，在任何地方new handler 都是什么线程下
* sqlite升级，增加字段的语句
* bitmap recycler 相关
* 强引用置为null，会不会被回收？
* glide 使用什么缓存？
* Glide 内存缓存如何控制大小？
* 如何保证多线程读写文件的安全？

> 8、携程

* Activity启动模式
* 广播的使用方式，场景
* App中唤醒其他进程的实现方式
* AndroidManifest的作用与理解
* List,Set,Map的区别
* HashSet与HashMap怎么判断集合元素重复
* Java中内存区域与垃圾回收机制
* EventBus作用，实现方式，代替EventBus的方式
* Android中开启摄像头的主要步骤

> 9、网易

* 集合
* concurrenthashmap
* volatile
* synchronized与Lock
* Java线程池
* wait/notify
* NIO
* 垃圾收集器
* Activity生命周期
* AlertDialog,popupWindow,Activity区别

> 10、小米

* String 为什么要设计成不可变的？
* fragment 各种情况下的生命周期
* Activity 上有 Dialog 的时候按 home 键时的生命周期
* 横竖屏切换的时候，Activity 各种情况下的生命周期
* Application 和 Activity 的 context 对象的区别
* 序列化的作用，以及 Android 两种序列化的区别。
* List 和 Map 的实现方式以及存储方式。
* 静态内部类的设计意图。
* 线程如何关闭，以及如何防止线程的内存泄漏

> 11、360

* 软引用、弱引用区别
* 垃圾回收
* 多线程：怎么用、有什么问题要注意；Android线程有没有上限，然后提到线程池的上限
* JVM
* 锁
* OOM，内存泄漏
* ANR怎么分析解决
* LinearLayout、RelativeLayout、FrameLayout的特性、使用场景
* 如何实现Fragment的滑动
* ViewPager使用细节，如何设置成每次只初始化当前的Fragment，其他的不初始化
* ListView重用的是什么
* 进程间通信的机制
* AIDL机制
* AsyncTask机制
* 如何取消AsyncTask
* 序列化
* Android为什么引入Parcelable
* 有没有尝试简化Parcelable的使用
* AIDL机制
* 项目：拉活怎么做的
* 应用安装过程

> 12、某海外直播公司

* 线程和进程的区别？
* 为什么要有线程，而不是仅仅用进程？
* 算法判断单链表成环与否？
* 如何实现线程同步？
* hashmap数据结构？
* arraylist 与 linkedlist 异同？
* object类的equal 和hashcode 方法重写，为什么？
* hashmap如何put数据（从hashmap源码角度讲解）？
* 简述IPC？
* fragment之间传递数据的方式？
* 简述tcp四次挥手?
* threadlocal原理
* 内存泄漏的可能原因？
* 用IDE如何分析内存泄漏？
* OOM的可能原因？
* 线程死锁的4个条件？
* 差值器&估值器
* 简述消息机制相关
* 进程间通信方式？
* Binder相关？
* 触摸事件的分发？
* 简述Activity启动全部过程？
* okhttp源码？
* RxJava简介及其源码解读？
* 性能优化如何分析systrace？
* 广播的分类？
* 点击事件被拦截，但是相传到下面的view，如何操作？
* Glide源码？
* ActicityThread相关？
* volatile的原理
* synchronize的原理
* lock原理
* 翻转一个单项链表
* string to integer
* 合并多个单有序链表（假设都是递增的）

> 13、其他公司

* 四大组件
* Android中数据存储方式
* 微信主页面的实现方式
* 微信上消息小红点的原理
* 两个不重复的数组集合中，求共同的元素。
* 上一问扩展，海量数据，内存中放不下，怎么求出。
* Java中String的了解。
* ArrayList与LinkedList区别
* 堆排序过程，时间复杂度，空间复杂度
* 快速排序的时间复杂度，空间复杂度
* RxJava的作用，与平时使用的异步操作来比，优势
* Android消息机制原理
* Binder机制介绍
* 为什么不能在子线程更新UI
* JVM内存模型
* Android中进程内存的分配，能不能自己分配定额内存
* 垃圾回收机制与调用System.gc()区别
* Android事件分发机制
* 断点续传的实现
* RxJava的作用，优缺点




