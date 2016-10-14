package com.qilin.cms.multiThread;

/**
 * Created by gaohaiqing on 16-10-14.
 *
 * 当一个线程遇到异常时，会怎样
 */
public class ThreadError {

    public synchronized void testMethod(){
        try {
            System.out.println("Enter currentThread ="+ Thread.currentThread().getName());
            int l = 5000;
            while (true){
                long lo = 2 / l;
                Thread.sleep(1);
                l--;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        ThreadError error = new ThreadError();
        MyThreadError myThread1 = new MyThreadError(error);
        myThread1.setName("ghq");
        MyThreadError myThread2 = new MyThreadError(error);
        myThread2.setName("tk");
        myThread1.start();
        myThread2.start();
    }
}

class MyThreadError extends Thread{
    private ThreadError error;

    public MyThreadError(ThreadError error){
        this.error = error;
    }

    @Override
    public void run() {
        error.testMethod();
    }
    /**
     * 结论：
     * 线程遇到异常时，会释放掉所持有的锁，让其它线程继续运行
     */
}
