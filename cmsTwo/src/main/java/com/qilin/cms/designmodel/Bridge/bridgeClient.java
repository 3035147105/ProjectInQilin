package com.qilin.cms.designmodel.Bridge;

/**
 * Created by gaohaiqing on 16-9-2.
 *
 * 桥梁模式
 * 组成：分为 抽象角色 和 实现角色
 * 特点：将 抽象角色的行为 委派给 实现角色
 *
 * 应用场景：JDBC驱动器
 * 两个独立的变化项是：一边是JDBC API， 一边是 JDBC驱动器，
 * 应用程序建立在JDBC API的基础上，JDBC 驱动器与数据库引擎打交道
 *
 */
public class bridgeClient {
    public static void main(String[] args){
        Implementor smsImple = new EmailMsg();//选择系统消息的方式
        Abstraction abstraction = new SpecialAbstraction(smsImple);
        abstraction.sendMessage();
    }
}
