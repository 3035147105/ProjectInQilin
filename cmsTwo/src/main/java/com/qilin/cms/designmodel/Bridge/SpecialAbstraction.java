package com.qilin.cms.designmodel.Bridge;

/**
 * Created by gaohaiqing on 16-9-2.
 *
 * 特级消息
 */
public class SpecialAbstraction extends Abstraction{

    public SpecialAbstraction(Implementor implementor) {
        super(implementor);
    }

    public void a(){
        System.out.println("特急消息的特有操作！");
    }

    @Override
    public void sendMessage(){
        a();
        super.sendMessage();
    }

}
