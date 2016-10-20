package com.qilin.cms.multiThread;

/**
 * Created by gaohaiqing on 16-10-19.
 *
 * wait、notify方法的用法。 这两个都是 Object的方法
 */
public class Thread7 {
    static int i = 0;
    private static Object lock = new Object();
    private static Object lock2 = new Object();

    //这个例子能得出什么结论来吗？
    public static void main(String []args){
        //开启一个新线程,对i进行累加操作
        new Thread(){
            @Override
            public void run() {
                try {
                    synchronized (lock){
                        System.out.println(Thread.currentThread().getName() +"开始运行"+ System.currentTimeMillis());
                        while (true){
                            if(2000 == i){
//                                notify();
                                break;
                            }else {
                                i++;
                                Thread.sleep(1);
                            }
                        }
                        System.out.println(Thread.currentThread().getName() +"运行结束"+ System.currentTimeMillis());
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }.start();
        //确保线程1执行完
        try {
            Thread.sleep(3000);
            System.out.println("睡觉的线程："+ Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //开启另一线程
        new Thread(){
            @Override
            public void run() {
                try {
                    synchronized (lock2){
                        System.out.println(Thread.currentThread().getName() +"开始运行"+ System.currentTimeMillis());
//                        if (2000 != i){
//                            wait();
//                        }
                        System.out.println("i："+i);
                        System.out.println(Thread.currentThread().getName() +"运行结束"+ System.currentTimeMillis());
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }.start();
    }
}

class MyThread7_1 extends Thread{
    private int i;

    public MyThread7_1(int i){
        this.i = i;
    }
    @Override
    public void run() {
        for(i=0; i<=1000; i++){
            i = i +1;
        }
    }
}
class MyThread7_2 extends Thread{
    private  int i;

    public MyThread7_2(int i){
        this.i = i;
    }

    @Override
    public void run() {
        if(1000 == i){
            System.out.println("i的值："+ i);
        }
    }
}