package com.qilin.cms.multiThread;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by gaohaiqing on 17-2-24.
 * 线程池应用--无返回值  execute()  Thread
 */
@Component
public class ThreadPool {

    public static void main(String[] args){
//        ThreadPool threadPool = new ThreadPool();
//        threadPool.aaaa();
        ThreadPool1 pool1 = new ThreadPool1();
        pool1.bbbb();
    }
    //模拟向全体用户推送消息
    public void aaaa(){
        List<String> openidList = getOpenidList();
        ExecutorService pool = Executors.newCachedThreadPool();
        System.out.println("开始时间：" +System.currentTimeMillis());
        for (int i=0; i<openidList.size(); i++){
            pool.execute(new MyThread(openidList.get(i)));
        }
        System.out.println("结束时间："+ System.currentTimeMillis());
        if(!pool.isShutdown())
            pool.shutdown();
    }
    class MyThread extends Thread{

        private String openId;

        public MyThread(String openId){
            this.openId = openId;
        }

        @Override
        public void run() {
            sendMsg(openId, Thread.currentThread().getName());
        }
    }
    Random random = new Random();
    //模拟发单条微信消息的方法
    public int sendMsg(String openid, String threadName){
        try {
            Thread.sleep(3000); //延时3秒，更好的模拟发消息时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println((threadName+"向openid为"+openid +"推送了微信消息"));
        return random.nextInt(2);
    }
    //模拟获取全部的openId
    public List<String> getOpenidList(){
        List<String> openlist = new ArrayList<>();
        for (int i=0; i<1000; i++)
            openlist.add(i +" ");
        return openlist;
    }
    public void getResult(List<Future> results, ExecutorService executorService){
        for (Future f:results){
            try {
                System.out.println("推送结果："+ f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                executorService.shutdownNow();//强制释放资源
                e.printStackTrace();
            }
        }
    }
}
