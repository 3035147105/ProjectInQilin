package com.qilin.cms.multiThread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gaohaiqing on 16-10-19.
 *
 * 写一个关于可见性的例子
 */
public class Thread5 {

    public static void main(String []args){
        try {
            myThread5 mt = new myThread5();
            mt.start();
            Thread.sleep(1000);
            mt.setRunning(false);
            System.out.println("已经赋值false了");
        }catch (Exception e){
            e.printStackTrace();
        }
        AtomicInteger ai = new AtomicInteger();
        ai.addAndGet(1);//加指定值，返回更新后的值
        ai.getAndAdd(1);//加指定值，返回更新前的值
        ai.get();//返回当前值
    }

}

class myThread5 extends Thread{
    private volatile boolean isRunning = true;//volatile可以保证可见性，但不能保证原子性

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        System.out.println("进入到run方法了");
        while (isRunning){}
        System.out.println("myThread5线程停止了");
    }
}