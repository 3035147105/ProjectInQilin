package com.qilin.cms.designmodel.FlyWeight;

/**
 * Created by gaohaiqing on 16-9-5.
 *
 * 棋子类
 */
public class FlyWeight implements IFlyWeight {
    private String color;//内部属性，可以共享

    public FlyWeight(String color) {
        this.color = color;
    }

    @Override
    public void operation(Location location) {
        System.out.println(color +"棋，放到x="+ location.getX() +",y="+location.getY()+"的位置");
    }
}
