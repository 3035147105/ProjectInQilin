package com.qilin.cms.designmodel.Factory.AbstractFactory;

/**
 * Created by gaohaiqing on 16-8-29.
 *
 * 抽象工厂方法
 *
 * 产品族的概念
 */
public interface AbstractFactory {

    ICPU createCpu();

    IMainBord createMainBord();
}
