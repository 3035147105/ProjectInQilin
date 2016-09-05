package com.qilin.cms.designmodel.FlyWeight;

/**
 * Created by gaohaiqing on 16-9-5.
 *
 * 不可以共享的外部属性：位置
 */
public class Location {
    private float x;
    private float y;

    public Location(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
