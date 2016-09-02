package com.qilin.cms.designmodel.Bridge;

/**
 * Created by gaohaiqing on 16-9-2.
 *
 * 抽象化角色
 */
public abstract class Abstraction {

    protected Implementor implementor;

    public Abstraction(Implementor implementor){
        this.implementor = implementor;
    }

    public void sendMessage(){
        implementor.send();
    }

}
