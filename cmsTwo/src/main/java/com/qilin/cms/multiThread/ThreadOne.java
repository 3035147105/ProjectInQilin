package com.qilin.cms.multiThread;

/**
 * Created by lenovo on 2016/10/13.
 *
 * 测试 synchronized，加深对 synchronized 的理解
 */
public class ThreadOne {
    private int num = 0;

    public synchronized void addNum(String name){//改变num的值
        try {
            if("a".equals(name)){
                num = 100;
                System.out.println("a set over");
                Thread.sleep(2000);
            }else if("b".equals(name)){
                num = 200;
                System.out.println("b set over");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(name +" num = "+ num);
    }


    public static void main(String[] args){
        ThreadOne threadOne = new ThreadOne();
        MyThread1 thread1 = new MyThread1(threadOne);
        MyThread2 thread2 = new MyThread2(threadOne);
        thread1.start();
        thread2.start();
        /**
         * addNum方法不加锁时，打印的是
         * a set over
         * b set over
         * b num = 200
         * a num = 200
         * 第3行 跟 第4行大约隔了2秒
         * a num得到的结果，并不是我们希望的结果；
         */

        /**
         * addNum方法加锁后，打印的是
         * a set over
         * a num = 100
         * b set over
         * b num = 200
         * 第1行 跟 第2行 大约隔了2秒
         * a num得到的结果，是我们希望的结果
         *
         * 可以看出，thread1线程执行完addNum方法后 thread2才能执行；换句话说 thread1获得addNum的锁后，别的线程不能再进入该方法
         * 上一段话的后半句其实说的不对，synchronized不是方法锁而是对象锁，即synchronized是锁的是对象
         */

        //通过new 两个对象，验证最后synchronized是对象锁
//        ThreadOne threadTwo = new ThreadOne();
//        MyThread2 thread2 = new MyThread2(threadTwo);
//        thread1.start();
//        thread2.start();
        /**
         * 上面这段代码的运行结果
         * a set over
         * b set over
         * b num = 200
         * a num = 100
         *
         * 第3行 跟 第4行 大约隔了2秒
         * 谁也不影响谁，两个子线程各自执行各自的；原因是 JVM创建了 两个ThreadOne对象，即产生了 两个锁
         */
    }
    /**
     * synchronized还有一个特性：重入锁
     */

}

class MyThread1 extends Thread{//自定义线程1
    private ThreadOne threadOne;

    public MyThread1(ThreadOne threadOne){
        this.threadOne = threadOne;
    }

    @Override
    public void run() {
        threadOne.addNum("a");
    }
}

class MyThread2 extends Thread{//自定义线程2
    private ThreadOne threadOne;

    public MyThread2(ThreadOne threadOne){
        this.threadOne = threadOne;
    }

    @Override
    public void run() {
        threadOne.addNum("b");
    }
}