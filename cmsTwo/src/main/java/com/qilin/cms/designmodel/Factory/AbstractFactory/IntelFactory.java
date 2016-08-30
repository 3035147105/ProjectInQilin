package com.qilin.cms.designmodel.Factory.AbstractFactory;

/**
 * Created by gaohaiqing on 16-8-29.
 *
 * 专门生产intel的工厂
 */
public class IntelFactory implements AbstractFactory{
    @Override
    public ICPU createCpu() {
        return new IntelCPU();
    }

    @Override
    public IMainBord createMainBord() {
        return new IntelMainBord();
    }
}
