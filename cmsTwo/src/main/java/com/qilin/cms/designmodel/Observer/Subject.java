package com.qilin.cms.designmodel.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaohaiqing on 16-9-7.
 *
 * 抽象主题对象，持有观察者的集合、对集合的操作
 */
public abstract class Subject {
    private List<Observer> list = new ArrayList<>();

    /**
     * 订阅此主题
     * @param observer
     */
    public void regist(Observer observer){
        list.add(observer);
    }

    /**
     * 取消订阅此主题
     * @param observer
     */
    public void remove(Observer observer){
        list.remove(observer);
    }

    /**
     * 发送新消息给搜有的观察者
     */
    public void notifyAllObs(){
        if(list.size() > 0){
            for(Observer observer:list){
                observer.update(this);//将主题类本身传给观察者，观察者根据自己的需要拿数据
            }
        }else {
            System.out.println("没有订阅此主题的观察者");
        }
    }

    abstract void change(String content);
}
