package com.qilin.cms.designmodel.Memento;

/**
 * Created by gaohaiqing on 16-9-8.
 *
 * 备忘录模式之自述历史模式，比较简单，使用较广泛
 * 他有两个角色，备忘录角色 和 发起人角色
 */
public class MementoClient {
    public static void main(String [] args){
        Originator originator = new Originator();
        originator.changeState("从前从前");
        IMemento memento = originator.createMemento();//这里就把发起人的状态信息存储到备忘录里了
        originator.changeState("以后以后");//修改发起人的状态
        originator.restoreMemento(memento);//恢复到发起人以前的状态
    }
}
