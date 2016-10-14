package com.qilin.cms.multiThread;

/**
 * Created by gaohaiqing on 16-10-14.
 *
 * 求证：两个synchronized块之间具有互斥性
 */
public class ThreadThree {

    public void A(){
        synchronized (this){
            try {
                System.out.println("A begin time="+ System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("A end time="+ System.currentTimeMillis());
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public void B(){
        synchronized (this){
            System.out.println("B begin time="+ System.currentTimeMillis());
            System.out.println("B end time="+System.currentTimeMillis());
        }
    }

    public static void main(String[] args){
        ThreadThree threadThree = new ThreadThree();
        myThreadThree1 three1 = new myThreadThree1(threadThree);
        myThreadThree2 three2 = new myThreadThree2(threadThree);
        three1.start();
        three2.start();
    }
}
class myThreadThree1 extends Thread{//线程1执行A方法的同步代码块
    private ThreadThree threadThree;

    public myThreadThree1(ThreadThree threadThree){
        this.threadThree = threadThree;
    }

    @Override
    public void run() {
        threadThree.A();
    }
}

class myThreadThree2 extends Thread{//线程2执行B方法的同步代码块
    private ThreadThree threadThree;

    public myThreadThree2(ThreadThree threadThree){
        this.threadThree = threadThree;
    }

    @Override
    public void run() {
        threadThree.B();
    }
}
