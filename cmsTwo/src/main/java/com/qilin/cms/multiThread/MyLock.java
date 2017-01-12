package com.qilin.cms.multiThread;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

/**
 * Created by gaohaiqing on 16-10-27.
 */
public class MyLock {

    public static void main(String[] args){
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        lock.lock();
        lock.unlock();
        lock.tryLock();
        try {
            lock.tryLock(1000L, TimeUnit.SECONDS);

            condition.await();
            condition.await(1000L, TimeUnit.SECONDS);
            condition.awaitNanos(2000L);
            condition.awaitUninterruptibly();
            condition.awaitUntil(new Date());
            condition.signal();
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String amao = "阿猫";//wait 跟 notify是 Object类的方法
        try {
            amao.wait();
            amao.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        Lock readLock = readWriteLock.readLock();//读锁
        Lock writeLock = readWriteLock.writeLock();//写锁
    }
}
