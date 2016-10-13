package com.qilin.cms.multiThread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by gaohaiqing on 16-9-28.
 *
 * 本包下的内容都是关于多线程及并发的
 *
 * java多线程通信 是 共享内存 的方式，每个线程都有自己的工作内存，共享一个主内存
 * 多线程问题的3个关注点：
 * 原子性、有序性、可见性
 *
 * 原子性：命令在执行的时候不能被其它命令打断
 * 有序性：源于 编译器、cpu对指令的重排序
 *       Happen-Before原则
 * 可见性：一个线程修改了共享变量的值，其它线程能够立即知道这个修改
 *
 *
 * 无锁类的原理：
 * CAS(V,E,N)算法：V要更新的变量，E预期值，N新值。全称：Compare And Set
 * CAS操作：先判断V跟E是否是一致的，只有他俩一致时才会将N赋值给V；否则表示已经有其它线程修改过它了
 * 另外注意：CAS操作是一个原子操作
 *
 * 无锁类都有哪些：
 * AtomicInteger
 */
public class multiThreadClient {
    /**
     * 类                                 方法
     * LockSupport                    park、unpark
     *
     *
     *
     *
     *
     *
     *
     */


    /**
     * 并发容器：
     * concurrentHashMap：
     * 将大的HashMap切分成若干个小HashaMap,这样多个线程在不同段上的操作一定是线程安全的。实现思想：锁分离
     *
     * blockingQueue
     * 不是一个高性能的容器，但他是一个非常好的共享数据的容器。典型的生产者消费者的实现
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */
//    AtomicInteger
//    AtomicReference
//    AtomicStampedReference   //stamp：标记
    public static AtomicReference<String> atomicReference = new AtomicReference<>("ghq");

    public static void main(String[] args){
        for(int i=0;i<10;i++){
            new Thread(){
                @Override
                public void run() {
                    if(atomicReference.compareAndSet("ghq", "zhy")){
                        System.out.println(Thread.currentThread().getId()+"change success");
                    }else {
                        System.out.println(Thread.currentThread().getId()+"change failed");
                    }
                }
            }.start();
        }
        String newVal = atomicReference.get();
//        String updVal = atomicReference.getAndSet("zyf");
        System.out.println("新值："+newVal);
//        System.out.println("修改后的值："+updVal);
    }
}
