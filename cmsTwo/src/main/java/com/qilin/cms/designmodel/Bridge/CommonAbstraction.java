package com.qilin.cms.designmodel.Bridge;

/**
 * Created by gaohaiqing on 16-9-2.
 */
public class CommonAbstraction extends Abstraction {

    public CommonAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void sendMessage(){
        super.sendMessage();
    }
}
