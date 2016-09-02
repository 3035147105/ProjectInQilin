package com.qilin.cms.designmodel.Bridge;

/**
 * Created by gaohaiqing on 16-9-2.
 *
 * 具体实现化角色
 */
public class SmsMsg implements Implementor {

    @Override
    public void send() {
        System.out.println("使用系统内消息的方式，发送消息");
    }
}
