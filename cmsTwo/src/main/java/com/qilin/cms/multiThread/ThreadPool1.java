package com.qilin.cms.multiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by gaohaiqing on 17-2-24.
 * 线程池应用--有返回值  submit()  Callable
 */
public class ThreadPool1 {
    ThreadPool pool = new ThreadPool();

    public void bbbb(){
        List<Future> results = new ArrayList<>();
        List<String> openIdList = pool.getOpenidList();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0; i<openIdList.size(); i++){
            Future<Integer> future = executorService.submit(new MyThread(openIdList.get(i)));
            results.add(future);
        }
        executorService.shutdown();

        pool.getResult(results, executorService);
    }

    class MyThread implements Callable<Integer>{

        private String openId;

        public MyThread(String openId){
            this.openId = openId;
        }


        @Override
        public Integer call() throws Exception {
            return pool.sendMsg(openId, Thread.currentThread().getName());
        }
    }
}
