# java面试题汇总

熟练掌握java是很关键的，大公司不仅仅要求你会使用几个api，更多的是要你熟悉源码实现原理，甚至要你知道有哪些不足，怎么改进，还有一些java有关的一些算法，设计模式等等。

### 一、java基础面试知识点

* java中==和equals和hashCode的区别
* int、char、long各占多少字节数
* int与integer的区别
* 探探对java多态的理解
* String、StringBuffer、StringBuilder区别
* 什么是内部类？内部类的作用
* 抽象类和接口区别
* 抽象类的意义
* 抽象类与接口的应用场景
* 抽象类是否可以没有方法和属性？
* 接口的意义
* 泛型中extends和super的区别
* 父类的静态方法能否被子类重写
* 进程和线程的区别
* final，finally，finalize的区别
* 序列化的方式
* Serializable 和Parcelable 的区别
* 静态属性和静态方法是否可以被继承？是否可以被重写？以及原因？
* 静态内部类的设计意图
* 成员内部类、静态内部类、局部内部类和匿名内部类的理解，以及项目中的应用
* 谈谈对kotlin的理解
* 闭包和局部内部类的区别
* string 转换成 integer的方式及原理


### 二、java深入源码级的面试题（有难度）

* 哪些情况下的对象会被垃圾回收机制处理掉？
* 讲一下常见编码方式？
* utf-8编码中的中文占几个字节；int型几个字节？
* 静态代理和动态代理的区别，什么场景使用？
* Java的异常体系
* 谈谈你对解析与分派的认识。
* 修改对象A的equals方法的签名，那么使用HashMap存放这个对象实例的时候，会调用哪个equals方法？
* Java中实现多态的机制是什么？
* 如何将一个Java对象序列化到文件里？
* 说说你对Java反射的理解
* 说说你对Java注解的理解
* 说说你对依赖注入的理解
* 说一下泛型原理，并举例说明
* Java中String的了解
* String为什么要设计成不可变的？
* Object类的equal和hashCode方法重写，为什么？


### 三、数据结构

* 常用数据结构简介
* 并发集合了解哪些？
* 列举java的集合以及集合之间的继承关系
* 集合类以及集合框架
* 容器类介绍以及之间的区别（容器类估计很多人没听这个词，Java容器主要可以划分为4个部分：List列表、Set集合、Map映射、工具类（Iterator迭代器、Enumeration枚举类、Arrays和Collections），具体的可以看看这篇博文 [Java容器类](http://alexyyek.github.io/2015/04/06/Collection/)）
* List,Set,Map的区别
* List和Map的实现方式以及存储方式
* HashMap的实现原理
* HashMap数据结构？
* HashMap源码理解
* HashMap如何put数据（从HashMap源码角度讲解）？
* HashMap怎么手写实现？
* ConcurrentHashMap的实现原理
* ArrayMap和HashMap的对比
* HashTable实现原理
* TreeMap具体实现
* HashMap和HashTable的区别
* HashMap与HashSet的区别
* HashSet与HashMap怎么判断集合元素重复？
* 集合Set实现Hash怎么防止碰撞
* ArrayList和LinkedList的区别，以及应用场景
* 数组和链表的区别
* 二叉树的深度优先遍历和广度优先遍历的具体实现
* 堆的结构
* 堆和树的区别
* 堆和栈在内存中的区别是什么(解答提示：可以从数据结构方面以及实际实现方面两个方面去回答)？
* 什么是深拷贝和浅拷贝
* 手写链表逆序代码
* 讲一下对树，B+树的理解
* 讲一下对图的理解
* 判断单链表成环与否？
* 链表翻转（即：翻转一个单项链表）
* 合并多个单有序链表（假设都是递增的）


### 四、线程、多线程和线程池

* 开启线程的三种方式？
* 线程和进程的区别？
* 为什么要有线程，而不是仅仅用进程？
* run()和start()方法区别
* 如何控制某个方法允许并发访问线程的个数？
* 在Java中wait和seelp方法的不同；
* 谈谈wait/notify关键字的理解
* 什么导致线程阻塞？
* 线程如何关闭？
* 讲一下java中的同步的方法
* 数据一致性如何保证？
* 如何保证线程安全？
* 如何实现线程同步？
* 两个进程同时要求写或者读，能不能实现？如何防止进程的同步？
* 线程间操作List
* Java中对象的生命周期
* Synchronized用法
* synchronize的原理
* 谈谈对Synchronized关键字，类锁，方法锁，重入锁的理解
* static synchronized 方法的多线程访问和作用
* 同一个类里面两个synchronized方法，两个线程同时访问的问题
* volatile的原理
* 谈谈volatile关键字的用法
* 谈谈volatile关键字的作用
* 谈谈NIO的理解
* synchronized 和volatile 关键字的区别
* synchronized与Lock的区别
* ReentrantLock 、synchronized和volatile比较
* ReentrantLock的内部实现
* lock原理
* 死锁的四个必要条件？
* 怎么避免死锁？
* 对象锁和类锁是否会互相影响？
* 什么是线程池，如何使用?
* Java的并发、多线程、线程模型
* 谈谈对多线程的理解
* 多线程有什么要注意的问题？
* 谈谈你对并发编程的理解并举例说明
* 谈谈你对多线程同步机制的理解？
* 如何保证多线程读写文件的安全？
* 多线程断点续传原理
* 断点续传的实现



----

### 并发编程有关知识点（这个是一般Android开发用的少的，所以建议多去看看）：

平时Android开发中对并发编程可以做得比较少，Thread这个类经常会用到，但是我们想提升自己的话，一定不能停留在表面，,我们也应该去了解一下java的关于线程相关的源码级别的东西。


**学习的参考资料如下：**

> Java 内存模型

* [java线程安全总结](http://www.iteye.com/topic/806990)
* [深入理解java内存模型系列文章](http://ifeve.com/java-memory-model-0/)

> 线程状态：

* [一张图让你看懂JAVA线程间的状态转换](https://my.oschina.net/mingdongcheng/blog/139263)

> 锁：

* [锁机制：synchronized、Lock、Condition](http://blog.csdn.net/vking_wang/article/details/9952063)
* [Java 中的锁](http://wiki.jikexueyuan.com/project/java-concurrent/locks-in-java.html)

> 并发编程：

* [Java并发编程：Thread类的使用](http://www.cnblogs.com/dolphin0520/p/3920357.html)
* [Java多线程编程总结](http://blog.51cto.com/lavasoft/27069)
* [Java并发编程的总结与思考](https://www.jianshu.com/p/053943a425c3#)
* [Java并发编程实战-----synchronized](http://www.cnblogs.com/chenssy/p/4701027.html)
* [深入分析ConcurrentHashMap](http://www.infoq.com/cn/articles/ConcurrentHashMap#)