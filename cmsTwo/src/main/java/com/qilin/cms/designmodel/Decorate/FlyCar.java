package com.qilin.cms.designmodel.Decorate;

/**
 * Created by gaohaiqing on 16-8-31.
 *
 * 具体装饰角色
 */
public class FlyCar extends Decorator {
    public FlyCar(ICar car) {
        super(car);
    }
    @Override
    public void move(){
        super.move();
        System.out.println("天上飞!");
    }
}
