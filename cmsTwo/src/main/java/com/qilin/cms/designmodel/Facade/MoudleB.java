package com.qilin.cms.designmodel.Facade;

/**
 * Created by gaohaiqing on 16-9-2.
 *
 * 模拟系统内部方法2
 */
public class MoudleB {

    public void inbmethod(){
        Facade facade = new Facade();
        facade.facade();
        System.out.println("类MoudleB提供的方法，供系统内部调用");

    }


}
