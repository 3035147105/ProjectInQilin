package com.qilin.cms.designmodel.Bridge;

/**
 * Created by gaohaiqing on 16-9-2.
 *
 * 桥梁模式
 */
public class bridgeClient {
    public static void main(String[] args){
        Implementor smsImple = new SmsMsg();//选择系统消息的方式
        Abstraction abstraction = new CommonAbstraction(smsImple);
        abstraction.sendMessage();
    }
}
