package com.qilin.cms.designmodel.Factory.AbstractFactory;

/**
 * Created by gaohaiqing on 16-8-29.
 */
public class AmdMainBord implements IMainBord {
    @Override
    public void installCPU() {
        System.out.println("amd的主板，只能插amd的cpu");
    }
}
