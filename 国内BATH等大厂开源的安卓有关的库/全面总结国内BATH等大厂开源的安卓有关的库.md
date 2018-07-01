安卓开发一直在用大公司的开源库，下面来整理一下与安卓开发有关的库。

## 一、阿里巴巴

#### （一）UI有关

>**1. 多页面切换场景统一解决方案 UltraViewPager**

UltraViewPager 是阿里开源的一个封装多种特性的 ViewPager ，主要是为多页面切换场景提供统一解决方案。


 　**主要功能:**

      1. 支持横向滑动／纵向滑动
      2. 支持一屏内显示多页
      3. 支持循环滚动
      4. 支持定时滚动，计时器使用 Handler 实现
      5. 支持设置 ViewPager 的最大宽高
      6. setRatio 按比例显示 UltraviewPager
      7. 内置 indicator ，只需简单设置几个属性就可以完成展示，支持圆点和 Icon；
      8. 内置两种页面切换动效

![](http://upload-images.jianshu.io/upload_images/6098829-c1cb507561b27194.gif?imageMogr2/auto-orient/strip)
![](http://upload-images.jianshu.io/upload_images/6098829-6b7d230b704c54d5.gif?imageMogr2/auto-orient/strip) ![](http://upload-images.jianshu.io/upload_images/6098829-d91deba23f66db91.gif?imageMogr2/auto-orient/strip)

>**2.vlayout**
 　　vlayout是一个针对`RecyclerView`的LayoutManager扩展, 主要提供一整套布局方案和布局间的组件复用的问题。

默认通用布局实现，解耦所有的View和布局之间的关系: Linear, Grid, 吸顶, 浮动, 固定位置等。

    LinearLayoutHelper: 线性布局
    GridLayoutHelper: Grid布局， 支持横向的colspan
    FixLayoutHelper: 固定布局，始终在屏幕固定位置显示
    ScrollFixLayoutHelper: 固定布局，但之后当页面滑动到该图片区域才显示, 可以用来做返回顶部或其他书签等
    FloatLayoutHelper: 浮动布局，可以固定显示在屏幕上，但用户可以拖拽其位置
    ColumnLayoutHelper: 栏格布局，都布局在一排，可以配置不同列之间的宽度比值
    SingleLayoutHelper: 通栏布局，只会显示一个组件View
    OnePlusNLayoutHelper: 一拖N布局，可以配置1-5个子元素
    StickyLayoutHelper: stikcy布局， 可以配置吸顶或者吸底
    StaggeredGridLayoutHelper: 瀑布流布局，可配置间隔高度/宽度

[github地址：vlayout](https://github.com/alibaba/vlayout)


#### （二）框架有关

>**1. Android 应用热修复工具 AndFix**

　　AndFix 是阿里巴巴开源的 Android 应用热修复工具，帮助 Anroid 开发者修复应用的线上问题。Andfix 是 "**And**roid hot-**fix**" 的缩写。
　　AndFix 支持 Android 2.3 - 6.0，ARM 和 x86 架构，dalvik 运行时和 art 运行时。AndFix 的分支是 .apatch 文件。

　**（一）AndFix 方法体取代实现规则：**
 
![](http://upload-images.jianshu.io/upload_images/6098829-74264ec1266edc8c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

　**（二）Bug 修复过程：**
 
![](http://upload-images.jianshu.io/upload_images/6098829-3f3de970008eba66.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

　**（三）使用**
    
　　1. 生成 .apatch 文件：

    usage: apkpatch -f <new> -t <old> -o <output> -k <keystore> -p <***> -a <alias> -e <***>
	 -a,--alias <alias>     alias.
	 -e,--epassword <***>   entry password.
	 -f,--from <loc>        new Apk file path.
	 -k,--keystore <loc>    keystore path.
	 -n,--name <name>       patch name.
	 -o,--out <dir>         output dir.
	 -p,--kpassword <***>   keystore password.
	 -t,--to <loc>          old Apk file path.

　　2.合并 .apatch 文件：

	usage: apkpatch -m <apatch_path...> -k <keystore> -p <***> -a <alias> -e <***>
	  -a,--alias <alias>     alias.
	 -e,--epassword <***>   entry password.
	 -k,--keystore <loc>    keystore path.
	 -m,--merge <loc...>    path of .apatch files.
	 -n,--name <name>       patch name.
	 -o,--out <dir>         output dir.
	 -p,--kpassword <***>   keystore password.

>**2. 非侵入式运行期 AOP 框架 Dexposed**

　　Dexposed 是阿里巴巴无线事业部第一个重量级 Andorid 开源软件，基于 ROOT 社区著名开源项目 Xposed 改造剥离了 ROOT 部分，演化为服务于所在应用自身的 AOP 框架。它支撑了阿里大部分 App 的在线分钟级客户端 bugfix 和线上调试能力。
　　Dexposed 的 AOP 是实现了纯非侵入式，没有任何注释处理器，weaver 或者字节码重写程序。Dexposed 的集成非常简单，就像加载一个 JNI 库一样，只需要在初始化的时候插入一行代码。

**经典用例**

        1.典型的 AOP 编程
        2.仪表化 (测试，性能监控等等)
        3.在线热修复（重要，关键，安全漏洞等等）
        4.SDK hooking，更好的开发体验

**大致用法：**

1.Gradle 依赖：

	native_dependencies {
	    artifact 'com.taobao.dexposed:dexposed_l:0.2+:armeabi'
	    artifact 'com.taobao.dexposed:dexposed:0.2+:armeabi'
	}
	dependencies {
	    compile files('libs/dexposedbridge.jar')
	}

2.初始化：

    public class MyApplication extends Application {
        @Override public void onCreate() {        
        // Check whether current device is supported (also initialize Dexposed framework if not yet)
        if (DexposedBridge.canDexposed(this)) {
            // Use Dexposed to kick off AOP stuffs.
            ...
        }
    }
    ...
}

**基础使用示例代码1：**

    // Target class, method with parameter types, followed by the hook callback (XC_MethodHook).
    DexposedBridge.findAndHookMethod(Activity.class, "onCreate", Bundle.class, new XC_MethodHook() {

        // To be invoked before Activity.onCreate().
        @Override protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            // "thisObject" keeps the reference to the instance of target class.
            Activity instance = (Activity) param.thisObject;

            // The array args include all the parameters.
            Bundle bundle = (Bundle) param.args[0];
            Intent intent = new Intent();
            // XposedHelpers provide useful utility methods.
            XposedHelpers.setObjectField(param.thisObject, "mIntent", intent);

            // Calling setResult() will bypass the original method body use the result as method return value directly.
            if (bundle.containsKey("return"))
                param.setResult(null);
        }

        // To be invoked after Activity.onCreate()
        @Override protected void afterHookedMethod(MethodHookParam param) throws Throwable {
            XposedHelpers.callMethod(param.thisObject, "sampleMethod", 2);
        }
    });

**基础使用示例代码2：**

    DexposedBridge.findAndHookMethod(Activity.class, "onCreate", Bundle.class, new XC_MethodReplacement() {

        @Override protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
            // Re-writing the method logic outside the original method context is a bit tricky but still viable.
            ...
        }

    });


>**3. Android 容器化框架 Atlas**

 　　Atlas 是由阿里巴巴移动团队自研的手机淘宝安卓客户端容器化框架，以容器化思路解决大规模团队协作问题，实现并行开发、快速迭代和动态部署，适用于 Android 4.x 以上系统版本的大小型 App 开发。

 　　Atlas 适用于大规模团队的协同开发。通过提供组件化、动态性、解耦化的支持，能够实现每个业务在开发阶段独立编译、独立调试、独立运行，最后再以一个组件的形式集成到客户端中，每个业务之间并行开发互不影响。此外，还具备客户端动态发版和快速修复的能力。

**特性：** 

        1. 在工程期，实现工程独立开发，调试的功能，工程模块可以独立。
        2. 在运行期，实现完整的组件生命周期的映射，类隔离等机制。
        3. 在运维期，提供快速增量的更新修复能力，快速升级。

>**4. ARouter**
 　　一个安卓路由器中间件，帮助应用程序导航到活动和自定义服务。`组件化开发`可以用到它。

[github地址：ARouter](https://github.com/alibaba/ARouter)

#### （三）跨平台框架有关

>**1.weex**
 　　跨平台的UI框架

[github地址: weex](https://github.com/apache/incubator-weex)
[weex的文档](https://github.com/alibaba/weex/wiki/Weex-Community)
[weex官网](https://weex.apache.org/)

>**2.Tangram-Android**
 　　Tangram是一套动态化构建 Native 页面的框架，它包含 Tangram Android、Tangram iOS，管理后台等一些列基础设施。本工程是 Tangram Android 的sdk 项目地址，底层依赖于 [vlayout](https://github.com/alibaba/vlayout)  和  [UltraViewPager](https://github.com/alibaba/UltraViewPager)。

特点：

    1.Android iOS 双平台支持，iOS 版本参考开源库 [Tangram-iOS](https://github.com/alibaba/Tangram-iOS)。
    2.通过 json 创建页面视图，并提供了默认的解析器。
    3.可轻松实现页面视图的回收与复用。
    4.框架提供多种默认的布局方式。
    5.通过 json 数据或代码支持自定义布局样式。
    6.高性能，基于 [vlayout](https://github.com/alibaba/vlayout)
    7.支持扩展功能模块

> **3.LuaViewSDK**

**(1) LuaViewSDK简介**
    
    　　LuaViewSDK是一个跨平台的框架，旨在构建本地，动态和快速的用户界面。 它基于Lua VM，并选择lua作为脚本语言。
    　　LuaView 是一种运行在一个 ViewController/Activity 中，可以灵活加载Lua 脚本，并能够按照 Native 的方式
    运行的一种面向业务的开发技术方案。可以快速开发电商应用中既要求体验又要求灵活性的页面功能。例如首页，类目首页，
    垂直频道，大促活动会场等。

**(2) 背景**
    　　LuaViewSDK 主要解决客户端开发中的两个常见问题：

    1.相同的业务逻辑需要在 iOS 和 Android 平台各实现一次，除了开发成本高，也会引入体验的细微差别。
      是否有一种技术方案可以做到一份代码，两个平台运行，行为相同 ？
    2.移动 APP 开发领域，要极致体验发布就不灵活（Native），要灵活发布就没有极致体验（H5）。
      有没有一种技术方案可以兼顾极致的体验和灵活的发布？LuaView 可以完美解决上述两个问题。

**(3) 为何使用Lua？**

市面上有许多类似的方案，比如React Native和Weex，他们使用了JS框架，配合DSL来进行界面布局，使用JS引擎进行脚本动态解析，实现了动态化的Native界面渲染能力。LuaViewSDK使用lua虚拟机进行脚本解析，通过构建lua与native之间的一系列基础bridge功能，从另一个角度实现了动态化的native能力。

相比于基于JS虚拟机的解决方案，LuaViewSDK选择的lua有如下优势：

    1.lua虚拟机极为轻量高效。单个lua虚拟机只消耗大约200到300k的内存空间，同屏渲染几十个LuaView没有任何负担
    2.lua天生就是作为一个极其轻量、可嵌入的设计实现，它更适合做API的封装或是数据传输的中间层。
      在App的开发上，更适合作为胶水语言，来直接操作native对象
    3.lua语法精炼，直观，native开发人员上手基本没有难度
    4.使用native开发人员更为熟悉的Native编程模式，直接创建和操作各种界面对象


[github地址：LuaViewSDK](http://git.oschina.net/mirrors/luaviewsdk)

[LuaViewSDK  文档地址](https://alibaba.github.io/LuaViewSDK/guide.html)

`另外：`
https://github.com/alibaba/LuaViewPlayground  这个库是对LuaViewSDK的一个补充，用来向开发者展示如何使用LuaViewSDK的基础控件、基本功能，以及如何扩展组件。

> **4.Thera**
    　　Thera是由Alibaba.com提供支持的集成开发环境（IDE），旨在改进移动混合解决方案的开发体验，例如weex，luaview，react native。

 [github地址： Thera](https://github.com/alibaba/Thera)
[Thera中文文档](https://github.com/alibaba/Thera/wiki/readme-cn)


#### （四）编译、解析、埋点工具有关

>**1. freeline(我本人目前用这个用得最多，比自带的编译速度快多了)**

 　　它是一个Android Studio的插件，可以在Android Studio的插件库查找到，下载安装直接使用。这里列举的是阿里巴巴在github的官网源码。
 　　Freeline 是 Android 平台上的秒级编译方案，Instant Run 的替代品，也可以从 [Freeline 官方主页](https://www.freelinebuild.com/) 来获取更多的信息。
 　　Freeline 由 [蚂蚁聚宝](https://www.antfortune.com/) Android 团队开发，它可以充分利用缓存文件，在几秒钟内迅速地对代码的改动进行编译并部署到设备上，有效地减少了日常开发中的大量重新编译与安装的耗时。
 　　Freeline能够为Android开发者节省很多喝杯咖啡的时间。

功能：

    1.支持标准的多模块 Gradle 工程的增量构建
    2.并发执行增量编译任务
    3.进程级别异常隔离机制
    4.支持 so 动态更新
    5.支持 resource.arsc 缓存
    6.支持 retrolambda
    7.支持 DataBinding
    8.支持各类主流注解库
    9.支持 Windows，Linux，Mac 平台

[github地址：freeline](https://github.com/alibaba/freeline)

>**2. fastjson**

 　　Fastjson是一个Java语言编写的高性能功能完善的JSON库。它采用一种“假定有序快速匹配”的算法，把JSON Parse的性能提升到极致，是目前Java语言中最快的JSON库。Fastjson接口简单易用，已经被广泛使用在缓存序列化、协议交互、Web输出、Android客户端等多种应用场景。

[github地址： fastjson](https://github.com/alibaba/fastjson)


>**3.android_viewtracker**

 　　ViewTracker是用于自动化的采集用户UI交互过程中的点击和曝光事件，基于view事件代理及过滤的数据采集库。

功能：

    1.支持`Android`&`iOS`平台。
    2.支持采集点击事件、曝光事件。
    3.支持采集页面公共信息。
    4.支持多个场景：列表滑动，列表自动滚动，页面内`Window`切换，`Tab`页切换，进入下一个页面，应用前后台切换。
    5.支持扩展：数据提交、曝光规则自定义(时间阈值和宽高阈值)、采样率定义等。

[github地址：android_viewtracker](https://github.com/alibaba/android_viewtracker)


#### （五）测试、文档工具有关

> **1. 移动自动化测试平台 Athrun**

　　Athrun以Mobile自动化为基础，以PC2Mobile为切入点，是淘宝Mobile测试日常工作必备的平台。
　　**目前Athrun支持：**
　　1. Android上的自动化测试，包括自动化测试框架，持续集成体系。覆盖率工具和自动录制回放工具，也在试用完善中。
　　2. iOS上的自动化测试，包括注入式自动化框架AppFramework，和基于录制的非注入式自动化框架Athrun_IOS，还有持续集成体系。目前两个框架在淘宝测试内都有用户群，都还在不断使用和演进过程中。AppFramework将会支持socket通信方式。
 　　AthrunStudio是基于PC2Mobile的移动工作平台，目前正在开发中。Demo代码开源，可以实现PC对手机的远程控制。

>**2.接口文档管理工具 RAP**

 　　RAP通过GUI工具帮助WEB工程师更高效的管理接口文档，同时通过分析接口结构自动生成Mock数据、校验真实接口的正确性，使接口文档成为开发流程中的强依赖。有了结构化的API数据，RAP可以做的更多，而我们可以避免更多重复劳动。

[github地址：RAP](https://github.com/thx/RAP)

>**3.Macaca**
 　　一套完整的自动化测试解决方案

特点：

    1.支持移动端和PC端
    2.支持 Native, Hybrid, H5 等多种应用类型
    3.提供客户端工具和持续集成服务

[github地址：Macaca](https://github.com/alibaba/macaca)

>**4.GCanvas**
github地址 https://github.com/alibaba/GCanvas
码云地址    https://gitee.com/mirrors/GCanvas

GCanvas 是由淘宝开发的针对移动设备的跨平台渲染引擎。 它使用 C ++ 编写，基于 OpenGL ES，可为 Javascript 运行时提供高性能的 2D / WebGL 渲染。它也具有类似浏览器的画布 API ，因此使用起来非常方便和灵活，尤其适用于 Web 开发人员。

GCanvas 支持 Android 4.0+（API 14）和 iOS 8.0+ 。支持 Weex 和 ReactNative 等混合框架。 它还可以利用大多数设备上的硬件加速，使得开发者可以使用 Javascript 以非常高的帧率绘制场景。


## 二、腾讯

>**1. 随身调测平台 GT**

 　　GT（随身调）是APP的随身调测平台，它是直接运行在手机上的“集成调测环境”(IDTE, Integrated Debug Environment)。利用GT，仅凭一部手机，无需连接电脑，您即可对APP进行快速的性能测试(CPU、内存、流量、电量、帧率/流畅度等等)、 开发日志的查看、Crash日志查看、网络数据包的抓取、APP内部参数的调试、真机代码耗时统计等。如果您觉得GT提供的功能还不够满足您的需要，您还 可以利用GT提供的基础API自行开发有特殊功能的GT插件，帮助您解决更加复杂的APP调试问题。

[github地址：GT](https://github.com/TencentOpen/GT)

>**2. Frozen UI 移动端UI框架**

 　　Frozen UI是一个开源的简单易用，轻量快捷的移动端UI框架。基于手Q样式规范，选取最常用的组件，做成手Q公用离线包减少请求，升级方式友好，文档完善，目前全面应用在腾讯手Q增值业务中。

[github地址：Frozen UI](https://github.com/frozenui/frozenui)

>**3. AlloyTouch**

 　　丝般顺滑的触摸运动方案。这是一个给Web app使用的一个库。这里面包含有一个 **[级联选择器](https://github.com/AlloyTeam/AlloyTouch/tree/master/select) 。**

[github地址：AlloyTouch](https://github.com/AlloyTeam/AlloyTouch)
查看文档请点击： https://github.com/AlloyTeam/AlloyTouch/wiki

>**4. AlloyFinger**

 　　轻量级的多点触摸网络手势库，用于web app的一个库。

[github地址：AlloyFinger](https://github.com/AlloyTeam/AlloyFinger)

>**5. AlloyCrop**

 　　最好且最小的移动裁剪组件，用于web app的一个库。

[github地址：AlloyFinger](https://github.com/AlloyTeam/AlloyCrop)

>**6. 组件化框架 Omi 和 Omix**

  　　Omi（读音 / [ˈomɪ] /, 汉字类似于 欧米） 是一款用于创建Web用户界面的组件化框架，开放并且现代，故得名：Omi。Omi框架提供了渐进增强式的Web开发解决方案，内置完善的支持无限声明式嵌套的组件系统。

概括起来包含下面优点和特性:

    1.良好的兼容性 - 兼容IE8及IE8以上版本(要兼容IE8请使用omi.art.js),完美兼容各种手机平版移动Web程序
    2.超小的尺寸 - 7 kb (gzip)
    3.面向未来的Web架构体系 - 未来DOM很快，而且越来来快! 其实现在DOM已经足够快了:)
    4.不使用虚拟DOM的问题是跨平台渲染更麻烦，Omi未来将提供`omi-canvas`进行跨平台渲染
    5.ES6+ 和 ES5都可以 - Omi提供了ES6+和ES5的两种开发方案。你可以自有选择你喜爱的方式
    6.局部CSS - HTML+ Scoped CSS + JS组成可复用的组件。不用担心组件的CSS会污染组件外的,Omi会帮你处理好一切
    7.模板或指令系统可替换 - 默认使用soda指令系统，开发者可以重写Omi.template方法来使用任意模板引擎或者指令引擎
    8.完全面向对象 - 函数式和面向对象各有优劣，Omi使用完全的面向对象的方式来构建Web程序。而且支持使用TypeScript来编写Omi程序
    9.更自由的更新 - 每个组件都有update和updateSelf方法，自由选择你认为最佳的更新时机和最佳的更新方式。updateSelf不会更新子组件
    10.完善丰富的插件和灵活的插件体系
       omi-router   ====》 Omi专属的官方Router插件.
       omi-finger   ====》 Omi的[AlloyFinger](https://github.com/AlloyTeam/AlloyFinger)插件，支持各种触摸事件和手势
       omi-transform   ====》 Omi的[transformjs](https://alloyteam.github.io/AlloyTouch/transformjs/)插件，快速方便地设置DOM的CSS3 Transform属性
       omi-touch   ====》 Omi的[AlloyTouch](https://github.com/AlloyTeam/AlloyTouch)插件，Omi项目的触摸运动解决方案（支持触摸滚动、旋转、翻页、选择等等）
       omi-jquery-date-picker   ====》 Omi的时间选择插件，支持各种时间或者时间区域选择
 
[github地址：Omi](https://github.com/AlloyTeam/omi) 

>**7. 组件化框架Omix**

  　　Omix（读音 / [ˈomɪkɜ:s] /, 汉字类似于 欧米可思） 是一款使用 JSX 创建Web用户界面的组件化框架，故得名：Omix。它并不是用来替代 [Omi框架](https://github.com/AlloyTeam/omi)，而是另外一种选择。

概括起来包含下面优点和特性:

    1.超迅捷的性能，经过测试, 居然是所有框架第一名, 不信可以看看[dbmon with omix](https://alloyteam.github.io/omix/example/perfs)。虽然排第一，但是发现还有许多优化空间！！
    2.良好的兼容性 - 兼容 IE8,兼容各种手机平版移动 Web 程序
    3.超小的尺寸 - 7 kb (gzip)
    4.内置支持 JSX 和 hyperscript , 喜欢哪种方式随意切换。需要注意 omix 里写 JSX 组件标签要小写
    5.局部CSS - HTML+ Scoped CSS + JS组成可复用的组件。不用担心组件的CSS会污染组件外的
    6.更自由的更新 - 每个组件都有 update 方法，自由选择你认为最佳的更新时机和最佳的更新方式
    7.灵活的插件体系和丰富的插件生态
      omi-router   ====》 Omi专属的官方Router插件.
      omi-finger   ====》 Omi的[AlloyFinger](https://github.com/AlloyTeam/AlloyFinger)插件，支持各种触摸事件和手势
      omi-transform   ====》 Omi的[transformjs](https://alloyteam.github.io/AlloyTouch/transformjs/)插件，快速方便地设置DOM的CSS3 Transform属性
      omi-touch   ====》 Omi的[AlloyTouch](https://github.com/AlloyTeam/AlloyTouch)插件，Omi项目的触摸运动解决方案（支持触摸滚动、旋转、翻页、选择等等）

 [github地址：Omix](https://github.com/AlloyTeam/omix)

>**8.JX**

  　　JX 是 Javascript eXtension tools 的缩写，即 Javascript 扩展工具套件的意思。一个类似 Google Closure Library 的 Web 前端开发框架。JX 框架同时适用于 Web Page 和 Web App 项目的开发，特别适合构建和组织大规模、工业级的Web App，腾讯 WebQQ -、腾讯 Q+等产品都是采用JX框架开发，兼容目前所有主流浏览器。

**特性：** 

    1.微内核设计：内核可完全分离出来，用于构建其他的框架
    2.原生对象零污染：你懂的，随着js的App越来约复杂，对原生对象的零污染也体现的越来越重要了
    3.模块封包：采用命名空间、闭包等方式建立了模块封包的体系，帮助更好的组织海量js代码
    4.模块自由拼装：自身模块做了良好的架构分离，尽可能让各个模块之间可以自由的拼装组合
    5.无缝集成各种js框架：与jQuery, YUI, Mootools, Prototype.js 等框架无缝集成；与多种局部框架无缝集成，如：Mini, Sizzle, cssQuery, xpath, JSON 等等
    6.多版本共存：如采用的Jx版本过旧，旧有的Javascript代码不能与新版本Jx兼容，则可以采用多版本共存的方式保持程序的可延续性
    7.分层设计：Javascript核心层，与Javascript解释引擎无关的封装和扩展；浏览器端Javascript层，对浏览器中的Javascript引擎部分的封装和扩展

[github地址： JX](https://github.com/AlloyTeam/JX)

>**9. [WeTest-Assistant](https://github.com/Tencent/WeTest-Assistant)**

  　　这是基于手机端的辅助测试工具，目前包括性能测试和远程调试两大功能，能够为手游等项目发现CPU、内存、FPS等性能问题，并提供云端真机用于问题在线调试，共计为公司内外部项目服务5.4万次；手游客户端性能测试常用性能维度，CPU，内存，FPS，流量一次性全部收集，图表化展示，数据可按场景化分类，并且支持离线和在线两种模式， 地铁上都可以做测试，Web上看报告。远程调试配合自研的云真机技术，支持多点触控、类手柄遥控，真实还原手游测试场景，极速流畅、极低延迟， 本地只需要一台手机即可操控云端任何一台手机。支持ROOT和非ROOT安卓手机，支持越狱iOS系统。

>**10.Tinker**

  　　Tinker是是微信官方的Android热补丁解决方案，它支持动态下发代码、So库以及资源，让应用能够在不需要重新安装的情况下实现更新。当然，你也可以使用Tinker来更新你的插件。

[github地址：Tinker](https://github.com/Tencent/tinker)
[官方文档](https://github.com/Tencent/tinker/wiki)

>**11.ncnn**

  　　ncnn 是一个为手机端极致优化的高性能神经网络前向计算框架。ncnn 从设计之初深刻考虑手机端的部署和使用。无第三方依赖，跨平台，手机端 cpu 的速度快于目前所有已知的开源框架。基于 ncnn，开发者能够将深度学习算法轻松移植到手机端高效执行，开发出人工智能 APP，将 AI 带到你的指尖。ncnn 目前已在腾讯多款应用中使用，如 QQ，Qzone，微信，天天P图等。

**功能：**

    1.支持卷积神经网络，支持多输入和多分支结构，可计算部分分支
    2.无任何第三方库依赖，不依赖 BLAS/NNPACK 等计算框架
    3.纯 C++ 实现，跨平台，支持 android ios 等
    4.ARM NEON 汇编级良心优化，计算速度极快
    5.精细的内存管理和数据结构设计，内存占用极低
    6.支持多核并行计算加速，ARM big.LITTLE cpu 调度优化
    7.整体库体积小于 500K，并可轻松精简到小于 300K
    8.可扩展的模型设计，支持 8bit 量化和半精度浮点存储，可导入 caffe 模型
    9.支持直接内存零拷贝引用加载网络模型
    10.可注册自定义层实现并扩展

[github地址：ncnn](https://github.com/Tencent/ncnn)

>**12.RapidView**

  　　RapidView是一套用于开发Android客户端界面、逻辑以及功能的开发组件。布局文件(XML)及逻辑文件(Lua)可以运行时执行，主要用以解决Android客户端界面、逻辑快速更新以及快速开发的诉求。RapidView的XML语法规则与Android原生XML类似，而写逻辑的Lua部分除语言语法规则外，可以直接使用我们提供的Java API以及Android原生API，因此熟悉Android客户端开发的开发者上手成本会非常小。

[github地址：RapidView](https://github.com/Tencent/RapidView)
[官方文档](https://github.com/Tencent/RapidView/blob/master/document.md)

>**13. QMUI Android（QMUI是腾讯的一个团队，web，ios，android三平台都有对应的工具，这里列举的是Android）**

  　　QMUI Android 的设计目的是用于辅助快速搭建一个具备基本设计还原效果的 Android 项目，同时利用自身提供的丰富控件及兼容处理，让开发者能专注于业务需求而无需耗费精力在基础代码的设计上。不管是新项目的创建，或是已有项目的维护，均可使开发效率和项目质量得到大幅度提升。

QMUI Android 官网：http://qmuiteam.com/android/page/index.html
QMUI Android  Github源码查看：https://github.com/QMUI/QMUI_Android

## 三、百度

百度关于web的开源库很多，关于移动端的库很少。

> **1. [Android自动化测试框架 Cafe](https://github.com/BaiduQA/Cafe)**
 　　Cafe 测试框架是一款来自百度QA部门的具有开创性意义的Android平台的自动化测试框架，框架覆盖了Android自动化测试的各种需求。框架致力于实现跨进程测试、快速测试、深度测试，解决了Android自动化测试中的诸多难题，比如业界一直没有解决的跨进程测试问题。

> **2. [GMU](https://github.com/gmuteam/GMU)** 
 　　GMU（Global Mobile UI）是百度前端通用组开发的移动端组件库，具有代码体积小、简单、易用等特点，组件内部处理了很多移动端的bug，覆盖机型广，能大大减少开发交互型组件的工作量，非常适合移动端网站项目。 该组件基于zepto的mobile UI组件库，提供webapp、pad端简单易用的UI组件!

>**3. [移动WebApp开发框架 Cloudajs](https://github.com/Clouda-team/Cloudajs)**
 　　Clouda是基于node.js的Webapp开发框架，在使用Clouda时需要安装node.js和MongoDB。
【注】原云端一体框架Cloudajs(Sumeru)更名为 **[RapidJS](https://github.com/Clouda-team/rapid-core)**，全面升级后，变得更加灵巧优雅。




## 四、网易

>**1. Android性能测试工具 [Emmagee](https://github.com/NetEase/Emmagee)**

 　　Emmagee是监控指定被测应用在使用过程中占用机器的CPU、内存、流量资源的性能测试小工具。
 　　支持SDK：Android2.2以及以上版本

 　　Emmagee功能介绍

        1、检测当前时间被测应用占用的CPU使用率以及总体CPU使用量
        2、检测当前时间被测应用占用的内存量，以及占用的总体内存百分比，剩余内存量
        3、检测应用从启动开始到当前时间消耗的流量数
        4、测试数据写入到CSV文件中，同时存储在手机中
        5、可以选择开启浮窗功能，浮窗中实时显示被测应用占用性能数据信息
        6、在浮窗中可以快速启动或者关闭手机的wifi网络



>**2. Android测试自动化框架 [Robotium](https://github.com/RobotiumTech/robotium)**

 　　Robotium是一个Android测试自动化框架，全面支持本机和混合应用。 Robotium可以轻松地为Android应用程序编写强大而强大的自动黑盒UI测试。 在Robotium的支持下，测试用例开发人员可以编写功能，系统和用户验收测试场景，跨越多个Android Activities。

>**3. [pomelo-androidclient ](https://github.com/NetEase/pomelo-androidclient)**

pomelo-androidclient这是一个用于java和android的pomelo socket.io客户端。该项目基于[socket.io-java-client](https://github.com/Gottox/socket.io-java-client)。pomelo-androidclient是Android的易于使用的pomelo客户端，它也与JRE兼容。

## 五、新浪（待发掘。。）

## 六、华为（待发掘。。）

##七、小米（待发掘。。）

##八、360（待发掘。。）
