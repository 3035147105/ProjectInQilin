package com.qilin.cms.designmodel.Prototype;

/**
 * Created by gaohaiqing on 16-8-30.
 */
public class ConcretePrototypeTwo implements Prototype {
    String name;

    @Override
    public Prototype clone() {
        Prototype prototype = new ConcretePrototypeTwo();
        prototype.setName(name);
        return prototype;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
