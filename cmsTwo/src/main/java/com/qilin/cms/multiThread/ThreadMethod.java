package com.qilin.cms.multiThread;

/**
 * Created by gaohaiqing on 16-10-10.
 *
 * 本类 主要 研究Thread类的 实例方法和静态方法 以及 线程的基础知识
 *
 * 虚拟机中的线程状态：6种
 * 新建 、运行 、阻塞、 等待：Object的wait, Thread的join, LockSupport的park、超时等待：Thread的sleep方法join方法，终止
 **/
public class ThreadMethod {
    //主线程
    //需求：主线程需要等待子线程ThreadA的结果
    public static void main(String[] args){
        Object lock = new Object();
        try {
            ThreadA threadA = new ThreadA(lock);
            threadA.start();
            /**
             * 调用join方法的线程：threadA
             * 调用join犯法的线程所在线程：main线程
             * join()方法会使调用join方法的线程的所在线程无限阻塞，直到调用join()方法的线程run方法执行完毕
             */
            threadA.join();
            System.out.println("主线程等待子线程执行完毕后再执行");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class ThreadA extends Thread{
    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        //同步代码块
        synchronized (lock){
            try {
                System.out.println("子线程执行完毕，结果是100");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


