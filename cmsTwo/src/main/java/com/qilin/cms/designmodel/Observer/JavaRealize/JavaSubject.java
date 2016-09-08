package com.qilin.cms.designmodel.Observer.JavaRealize;

import java.util.Observable;

/**
 * Created by gaohaiqing on 16-9-7.
 */
public class JavaSubject extends Observable {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if(!content.equals(this.content)){
            this.content = content;
            setChanged();//设置状态为已经改变
        }
        notifyObservers();//通知观察者，内部就是调用观察者的update方法
    }
}


