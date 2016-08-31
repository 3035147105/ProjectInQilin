package com.qilin.cms.designmodel.Decorate;

/**
 * Created by gaohaiqing on 16-8-31.
 */
public class WaterCar extends Decorator {


    public WaterCar(ICar car) {
        super(car);
    }

    @Override
    public void move() {
        super.move();
        System.out.println("水里游！");
    }
}
