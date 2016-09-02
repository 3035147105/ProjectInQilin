package com.qilin.cms.designmodel.Proxy.StaticProxy;

/**
 * Created by gaohaiqing on 16-8-31.
 *
 * 代理模式 之 静态代理
 *
 * 功能介绍：代理对象将客户端调用委派给目标对象，在调用目标对象的方法之前跟之后都执行一些操作
 *
 * 这种模式看着挺简单的，实际开发中用到的地方肯定不少
 *
 * 生活中，用来翻墙的vpn就是一个代理
 *
 * 代理的作用：
 * 1：实现延迟加载，比如在hibernate框架中，数据库连接是一个耗时操作。
 * 初始化框架时，就只会初始化一个代理类，在真正查询的时候才会加载数据库连接这个耗时操作（这里的真正用到指的是方法被调用时）
 * 2:在目标方法执行前后作一些动作
 *
 */
public class ProxyClient {
    public static void main(String[] args){
        AbstractObj obj = new ProxyObj();
        obj.operation();
    }
}
