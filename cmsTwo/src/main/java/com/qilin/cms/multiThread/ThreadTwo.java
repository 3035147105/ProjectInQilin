package com.qilin.cms.multiThread;

/**
 * Created by lenovo on 2016/10/13.
 *
 * synchronized是 重入锁的验证， 以及怎么个重入法
 */
public class ThreadTwo {

    public synchronized void a(){
        System.out.println(Thread.currentThread().getName() +"执行a方法");
        this.b();
    }
    public synchronized void b(){
        System.out.println(Thread.currentThread().getName() +"执行b方法");
        this.c();
    }
    public synchronized void c(){
        System.out.println(Thread.currentThread().getName() +"执行c方法");
//        this.a();   加上这一行就会
    }

    public static void main(String [] args){
        ThreadTwo threadTwo = new ThreadTwo();
        threadTwo.a();
        myThreadOne myThreadOne = new myThreadOne(threadTwo);
        myThreadTwo myThreadTwo = new myThreadTwo(threadTwo);
        myThreadOne.start();
        myThreadTwo.start();
    }
}

class myThreadOne extends Thread{
    private ThreadTwo threadTwo;
    public myThreadOne(ThreadTwo threadTwo){
        this.threadTwo = threadTwo;
    }

    @Override
    public void run() {
        threadTwo.a();
    }
}
class myThreadTwo extends Thread{
    private ThreadTwo threadTwo;
    public myThreadTwo(ThreadTwo threadTwo){
        this.threadTwo = threadTwo;
    }

    @Override
    public void run() {
        threadTwo.a();
    }
}
