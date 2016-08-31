package com.qilin.cms.designmodel.Decorate;

/**
 * Created by gaohaiqing on 16-8-31.
 *
 * 装饰器模式
 *
 * 在不添加子类的情况下，为对象添加功能扩展
 *
 * 例子：为一辆普通的车添加水里游，天上飞，既可以在水里游也可以在天上飞的功能扩展
 */
public class DecorateClient {

    public static void main(String []args){

        //造一辆天上，地上，水里都能跑的汽车
        ICar superCar = new WaterCar(new FlyCar(new Car()));
        superCar.move();
    }
}
