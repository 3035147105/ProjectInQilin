package com.qilin.cms.designmodel.Observer;

/**
 * Created by gaohaiqing on 16-9-7.
 *
 * 具体观察者角色
 */
public class ConcreteObserver implements Observer{

    @Override
    public void update(Subject subject) {
        ConcreteSubject concreteSubject = (ConcreteSubject)subject;//给你主题类对象，想要什么自己去取吧
        String content = concreteSubject.getMyContent();//观察者的对象
        System.out.println("观察者"+this.getClass().getSimpleName()+"接收到的内容："+content);
    }
}
