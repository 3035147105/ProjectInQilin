package com.qilin.cms.designmodel.Observer;

/**
 * Created by gaohaiqing on 16-9-7.
 *
 * 具体的主题
 */
public class ConcreteSubject extends Subject{
    private String myContent;

    public String getMyContent() {
        return myContent;
    }

    /**
     * 主题的状态发生改变时，通知观察者
     */
    @Override
    public void change(String content) {
        this.myContent = content;
        System.out.println("主题类说："+this.myContent);
        this.notifyAllObs();
    }
}
