package com.qilin.cms.controller;

import com.qilin.cms.multiThread.MyThreadPool;
import com.qilin.cms.multiThread.ThreadPool;
import com.qilin.cms.multiThread.ThreadPool1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by gaohaiqing on 17-2-24.
 * 将线程池单独配成bean，容器启动的时候完成初始化，
 */
@Controller
@RequestMapping("threadPool")
public class ThreadPool2 {
    @Autowired
    MyThreadPool pool;
    @Autowired
    ThreadPool threadPool;

    @RequestMapping("test.do")
    public void test(){
    }

//    @Scheduled(initialDelay = 6000L, fixedDelay = 3600000L)
    public void a(){
        test1();
    }
//    @Scheduled(initialDelay = 6000L, fixedDelay = 3600000L)
    public void b(){
        test1();
    }

    public void test1(){
        //存放每个线程的执行结果
        List<Future> results = new ArrayList<>();
        //获取所有用户的openId
        List<String> openIdList = threadPool.getOpenidList();
        //获取线程池，多次调用都会获取同一个线程池，原因是 MyThreadPool作为Spring Bean，这样线程池就交给了Spring管理
        ExecutorService executorService = pool.getExecutorService();
        //每一条消息推送都单独用一个线程完成
        for(int i=0; i<openIdList.size(); i++){
            Future<Integer> future = executorService.submit(new MyThread(openIdList.get(i)));
            results.add(future);
        }
        System.out.println("线程池状态："+executorService);
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        threadPool.getResult(results, executorService);
        System.out.println("线程池状态2："+executorService);
    }

    class MyThread implements Callable<Integer> {
        private String openId;
        //构造方法传参数
        public MyThread(String openId){
            this.openId = openId;
        }

        @Override
        public Integer call() throws Exception {
            return threadPool.sendMsg(openId, Thread.currentThread().getName());
        }
    }

}
