package com.qilin.cms.designmodel.Decorate;

/**
 * Created by gaohaiqing on 16-8-31.
 *
 * 装饰角色
 */
public class Decorator implements ICar {
    private ICar car;

    public Decorator(ICar car){
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}
