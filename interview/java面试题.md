# java面试题汇总

熟练掌握java是很关键的，大公司不仅仅要求你会使用几个api，更多的是要你熟悉源码实现原理，甚至要你知道有哪些不足，怎么改进，还有一些java有关的一些算法，设计模式等等。

### 一、java基础面试知识点

> java中==和equals和hashCode的区别
> int-char-long各占多少字节数
> int与integer的区别
> 探探对java多态的理解
> string-stringbuffer-stringbuilder区别
> 什么导致线程阻塞
> 什么是内部类？内部类的作用
> 抽象类和接口区别
> 抽象类的意义
> 接口的意义
> 泛型中extends和super的区别
> 父类的静态方法能否被子类重写
> 进程和线程的区别
> final，finally，finalize的区别

### 二、java深入源码级的面试题（有难度）

> 谈谈你对双亲委派模型理解
> 哪些情况下的对象会被垃圾回收机制处理掉？
> 谈谈你对并发编程的理解并举例说明
> java虚拟机的特性
> 谈谈对多线程的理解
> 谈谈你对多线程同步机制的理解？
> 什么导致线程阻塞？
> 两个进程同时要求写或者读，能不能实现？如何防止进程的同步？
> volatile 的意义？

### 三、数据结构

> HashMap的实现原理
> ArrayMap和HashMap的对比
> hashmap和hashtable的区别
> 列举java的集合以及集合之间的继承关系
> 容器类之间的区别（容器类估计很多人没听这个词，Java容器主要可以划分为4个部分：List列表、Set集合、Map映射、工具类（Iterator迭代器、Enumeration枚举类、Arrays和Collections），具体的可以看看这篇博文http://alexyyek.github.io/2015/04/06/Collection/）
> 数组和链表的区别
> 二叉树的深度优先遍历和广度优先遍历的具体实现
> 堆的结构
> 什么是深拷贝和浅拷贝
> 对象锁和类锁是否会互相影响





----

## 并发编程有关知识点（这个是一般Android开发用的少的，所以建议多去看看）：

平时Android开发中对并发编程可以做得比较少，Thread这个类经常会用到，但是我们想提升自己的话，一定不能停留在表面，,我们也应该去了解一下java的关于线程相关的源码级别的东西。


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