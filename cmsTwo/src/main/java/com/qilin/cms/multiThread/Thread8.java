package com.qilin.cms.multiThread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gaohaiqing on 16-10-20.
 *
 * 这个是干嘛用的，不是很清楚
 */
public class Thread8 {
    private static final AtomicInteger nextId = new AtomicInteger(0);

    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }
    };

    public static void main(String []args){
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set(1);
    }

    public int get(){
        return threadId.get();
    }
}
