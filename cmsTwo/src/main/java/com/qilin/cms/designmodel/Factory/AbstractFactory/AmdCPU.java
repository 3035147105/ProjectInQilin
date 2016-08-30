package com.qilin.cms.designmodel.Factory.AbstractFactory;

/**
 * Created by gaohaiqing on 16-8-29.
 */
public class AmdCPU implements ICPU{
    @Override
    public void caculate() {
        System.out.println("amd的cpu");
    }
}
