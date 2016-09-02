package com.qilin.cms.designmodel.Bridge;

/**
 * Created by gaohaiqing on 16-9-2.
 *
 * 修正抽象化角色
 */
public class UrgencyAbstraction extends Abstraction {

    public UrgencyAbstraction(Implementor implementor) {
        super(implementor);
    }

    public void watch(){
        System.out.println("加急消息的特有操作！");
    }

    @Override
    public void sendMessage(){
        super.sendMessage();
    }
}
