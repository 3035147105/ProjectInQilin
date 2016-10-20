package com.qilin.cms.multiThread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gaohaiqing on 16-10-19.
 *
 * 本方法研究一下原子类 AtomicInteger
 */
public class Thread6 {
    public static AtomicInteger ai = new AtomicInteger();

    public void addNum(){
        System.out.println(Thread.currentThread().getName() +"加了100之后的结果："+ ai.addAndGet(100));
        ai.getAndAdd(1);
    }

    public static void main(String[] args){
        try {
            Thread6 thread6 = new Thread6();
            for(int i=0; i<5; i++){
                MyThread6 mt = new MyThread6(thread6);
                mt.start();
            }
            Thread.sleep(1000);
            System.out.println(ai.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 不加 synchronized 运行的结果；每次的运行结果都不一样
     * Thread-1加了100之后的结果：100
     * Thread-0加了100之后的结果：200
     * Thread-2加了100之后的结果：302
     * Thread-3加了100之后的结果：402
     * Thread-4加了100之后的结果：504
     * 505
     */

    /**
     * 加上 synchronized 之后的运行结果；每次的运行结果都是一样的
     * Thread-0加了100之后的结果：100
     * Thread-1加了100之后的结果：201
     * Thread-2加了100之后的结果：302
     * Thread-3加了100之后的结果：403
     * Thread-4加了100之后的结果：504
     * 505
     * 从运行结果来看，加上 synchronized 之后，两条代码变得更像一个整体，即 保证了原子性
     */
}

class MyThread6 extends Thread{//创建一个线程
    private Thread6 t6;

    public MyThread6(Thread6 t6){
        this.t6 = t6;
    }

    @Override
    public void run() {
        t6.addNum();
    }
}
