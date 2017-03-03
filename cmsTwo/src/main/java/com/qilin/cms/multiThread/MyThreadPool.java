package com.qilin.cms.multiThread;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gaohaiqing on 17-2-24.
 */
@Component
public class MyThreadPool {
    private ExecutorService executorService = Executors.newFixedThreadPool(20);

    public ExecutorService getExecutorService() {
        return executorService;
    }
}
