package com.qilin.cms.designmodel.Observer.JavaRealize;

import java.util.Observable;

/**
 * Created by gaohaiqing on 16-9-7.
 */
public class JavaObserver implements java.util.Observer {
    public JavaObserver(Observable o){//观察者在被构建时就加到了主题列表中
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        String content = ((JavaSubject)o).getContent();//内容
        System.out.println("被观察者说："+content);
    }
}
