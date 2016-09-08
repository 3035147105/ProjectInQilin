package com.qilin.cms.designmodel.Memento;

/**
 * Created by gaohaiqing on 16-9-8.
 *
 * 备忘录角色 作为 发起人角色的内部类出现
 */
public class Originator {
    String state;

    /**
     * 修改状态
     */
    void changeState(String state){
        this.state = state;
        System.out.println("发起人存储的状态是："+this.state);
    }

    /**
     * 创建备忘录
     */
    IMemento createMemento(){
        return new Memento(this);
    }

    /**
     * 恢复到以前的备忘录状态
     */
    void restoreMemento(IMemento memento){
        changeState(((Memento)memento).state);
    }

    private class Memento implements IMemento{
        private String state;

        private Memento(Originator o){
            this.state = o.state;
        }
    }
}
