package com.qilin.cms.designmodel.Build;

/**
 * Created by gaohaiqing on 16-8-30.
 *
 * 建造者模式
 * 场景：业务中使用到小米推送，推送的消息分为一般消息和IOS消息，消息构建完成后使用统一的推送接口。
 * 上述功能的实现使用建造者模式
 *
 * 建造者模式的重要部分：
 * 一个部分是部件构造和产品装配，另一个部分是整体构建的算法。
 */
public class BuildClient {
    public static void main(String[] args){
        Message message = new Message.Builder()
                .title("一般消息的标题")
                .description("一般消息的描述")
                .build();
        Message iosMsg = new Message.IOSBuilder()
                .description("ios消息的描述")
                .build();
        System.out.println(message.toString());
        System.out.println(iosMsg.toString());
    }
}
