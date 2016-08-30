package com.qilin.cms.designmodel.Single;

/**
 * Created by gaohaiqing on 16-8-29.
 *
 * 枚举 是天然的单例模式
 *
 * 还有一种比较好的实现单例模式的方法：类级内部类
 *
 * 饿汉式 跟 懒汉式 实现单例的不好的地方：
 * 饿汉式：用空间换时间。不管有没有用到，先整出来
 * 懒汉式：用时间换空间。每次获取的时候都要判断
 */
public enum Singleton {

    uniqueInstance;

    public void singletonOperation(){

    }
}
