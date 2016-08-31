package com.qilin.cms.designmodel.Prototype;

/**
 * Created by gaohaiqing on 16-8-30.
 *
 */
public interface Prototype {
    Prototype clone();
    void setName(String name);
    String getName();
}
