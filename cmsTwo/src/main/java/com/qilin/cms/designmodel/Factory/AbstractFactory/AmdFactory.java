package com.qilin.cms.designmodel.Factory.AbstractFactory;

/**
 * Created by gaohaiqing on 16-8-29.
 */
public class AmdFactory implements AbstractFactory {
    @Override
    public ICPU createCpu() {
        return new AmdCPU();
    }

    @Override
    public IMainBord createMainBord() {
        return new AmdMainBord();
    }
}
