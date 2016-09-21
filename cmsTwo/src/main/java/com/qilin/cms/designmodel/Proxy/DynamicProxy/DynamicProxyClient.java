package com.qilin.cms.designmodel.Proxy.DynamicProxy;

import java.lang.reflect.Proxy;

/**
 * Created by gaohaiqing on 16-8-31.
 */
public class DynamicProxyClient {

    public static void main(String []args){
        /**客户端调用起来非常方便，只需要替换=右边的代码就可以了**/
        IService service = new UserService();
//        IService service = new ProductService();
        /**
         * proxy是动态代理对象
         * 代理对象 与 真实对象使用相同的类加载器，
         * 相同的接口
         */
        ClassLoader classLoader = service.getClass().getClassLoader();//类加载器
        Class[] classes = new Class[]{IService.class};//类
        TransactionInvationHandler invationHandler = new TransactionInvationHandler(service);//动态代理对象

        IService proxy = (IService) Proxy.newProxyInstance(classLoader, classes, invationHandler);
        proxy.saveObj();
    }

}
