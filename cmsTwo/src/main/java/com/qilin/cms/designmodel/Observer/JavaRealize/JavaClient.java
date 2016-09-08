package com.qilin.cms.designmodel.Observer.JavaRealize;

/**
 * Created by gaohaiqing on 16-9-7.
 *
 * java给出的实现
 */
public class JavaClient {
    public static void main(String[] args){
        JavaSubject subject = new JavaSubject();
        JavaObserver javaObserver = new JavaObserver(subject);//这一步是把观察者与被观察者联系起来

        subject.setContent("你这个大傻X");
    }
}
