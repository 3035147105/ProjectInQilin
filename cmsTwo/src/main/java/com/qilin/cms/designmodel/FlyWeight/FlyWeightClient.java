package com.qilin.cms.designmodel.FlyWeight;

/**
 * Created by gaohaiqing on 16-9-5.
 *
 * 享元模式；
 * 注意：不要与原型模式混淆，他俩是完全不同的两种模式：原型模式是创建型模式；享元模式是结构型模式
 *
 * 真实场景：String类
 *
 * 模拟场景：围棋游戏，围棋里面分黑白棋子，各个棋子可以共享的属性是 颜色，不可以共享的属性是  位置
 */
public class FlyWeightClient {

    public static void main(String []args){
        FlyWeightFactory factory = new FlyWeightFactory();
        FlyWeight flyWeight = factory.get("白");//取第一颗白棋
        flyWeight.operation(new Location(10,10));

        FlyWeight flyWeight1 = factory.get("白");//取第二颗白棋
        flyWeight1.operation(new Location(20,20));
        /**
         * 说明：虽然看着是看着是两颗棋子，实际上在内存中是同一个对象。不创建相同的对象，从而达到节省内存的目的
         */
        System.out.println(flyWeight);
        System.out.println(flyWeight1);
        System.out.println(flyWeight == flyWeight1);
    }
}
