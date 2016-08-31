package com.qilin.cms.controller.Proxy;

/**
 * Created by gaohaiqing on 16-7-19.
 *
 * 测试spring的代理接口
 */
public class DyproxyTest {

    private LockHandler handler = null;
    private DomainObjDaoImpl daoImpl = null;
    public static void main(String []args){
        DyproxyTest dy = new DyproxyTest();
        dy.testSave();
    }

    protected void setUp(){
        handler = new LockHandler();
        daoImpl = new DomainObjDaoImpl();
    }

    public void testSave(){
        setUp();
        //问题：这里只能是接口，不能是实现类；否则会报类型转换错误
        ((DomaininObjDao)handler.bind(daoImpl)).save();
    }
}
