package com.qilin.cms.designmodel.Decorate;

/**
 * Created by gaohaiqing on 16-8-31.
 */
public class Car implements ICar {
    @Override
    public void move() {
        System.out.println("地上跑！");
    }
}
