package com.qilin.cms.multiThread;

/**
 * Created by gaohaiqing on 16-10-14.
 *
 * synchronized(非this对象x)，如果x是实例变量的话，会怎样呢
 */
public class ThreadFour {
    private String num = new String();//实例变量

    public void setNum(String num) {
        this.num = num;
    }

    public Object getNum() {
        return num;
    }

    public void A(String name){
        synchronized (num){
            try {
                System.out.println(name +" begin time="+ System.currentTimeMillis()+",num="+ num);
                Thread.sleep(2000);
                System.out.println(name +" end time="+ System.currentTimeMillis()+",num="+ num);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

//    public void B(String name){
//        synchronized (name){
//            System.out.println("B begin time="+ System.currentTimeMillis());
//            System.out.println("B end time="+System.currentTimeMillis());
//        }
//    }

    public static void main(String[] args){
        ThreadFour threadFour = new ThreadFour();
        myThreadFour1 three1 = new myThreadFour1(threadFour);
        myThreadFour2 three2 = new myThreadFour2(threadFour);
        three1.start();
        three2.start();
    }
}
class myThreadFour1 extends Thread{//线程1执行A方法的同步代码块
    private ThreadFour threadFour;

    public myThreadFour1(ThreadFour threadFour){
        this.threadFour = threadFour;
    }

    @Override
    public void run() {
        threadFour.setNum("1");
        threadFour.A("ghq");
    }
}

class myThreadFour2 extends Thread{//线程2执行B方法的同步代码块
    private ThreadFour threadFour;

    public myThreadFour2(ThreadFour threadFour){
        this.threadFour = threadFour;
    }

    @Override
    public void run() {
        threadFour.setNum("2");
        threadFour.A("tk");
    }
    /**
     * ghq begin time=1476440107586,num=1
     * tk begin time=1476440107587,num=2
     * ghq end time=1476440109587,num=2
     * tk end time=1476440109587,num=2
     *
     * 有疑问？为什么会打印这样的结果
     * 拿一个实例变量做锁，得到的运行顺序是异步的。按说 实例变量的引用不变的话，属性改变了锁也是起作用的
     */
}