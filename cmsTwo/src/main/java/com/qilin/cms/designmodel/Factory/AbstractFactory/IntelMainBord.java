package com.qilin.cms.designmodel.Factory.AbstractFactory;

/**
 * Created by gaohaiqing on 16-8-29.
 */
public class IntelMainBord implements IMainBord {
    @Override
    public void installCPU() {
        System.out.println("intel的主板，只能插intel的cpu");
    }
}
