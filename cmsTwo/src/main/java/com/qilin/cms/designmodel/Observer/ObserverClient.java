package com.qilin.cms.designmodel.Observer;

/**
 * Created by gaohaiqing on 16-9-7.
 *
 * 观察者模式 -- 行为模式的一种
 *
 * 分两类：一类是推模型（主题类将新状态推给观察者）；另一类是拉模型（观察者从主题类拉取新消息）
 * 两种类型的比较：拉模型比推模型更容易更灵活些，原因是他把自己给了观察者，观察者可以根据自己的需要去拿数据
 *
 * 主题对象的状态发生改变，观察这个主题的所有观察者的对象也都跟着改变
 */
public class ObserverClient {
    public static void main(String[] args){
        Subject subject = new ConcreteSubject();

        Observer observer = new ConcreteObserver();
        Observer observerB = new ConcreteObserverB();

        subject.regist(observer);
        subject.regist(observerB);

        subject.change("three");
        subject.change("four");
    }
}
