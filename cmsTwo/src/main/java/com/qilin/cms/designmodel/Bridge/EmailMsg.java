package com.qilin.cms.designmodel.Bridge;

/**
 * Created by gaohaiqing on 16-9-2.
 */
public class EmailMsg implements Implementor {
    @Override
    public void send() {
        System.out.println("使用邮件的方式发送消息。。。");
    }
}
