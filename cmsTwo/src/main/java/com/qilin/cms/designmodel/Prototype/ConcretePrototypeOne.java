package com.qilin.cms.designmodel.Prototype;

/**
 * Created by gaohaiqing on 16-8-30.
 */
public class ConcretePrototypeOne implements Prototype {
    String name;
    @Override
    public Prototype clone() {
        Prototype prototype = new ConcretePrototypeOne();
        prototype.setName(this.name);
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
