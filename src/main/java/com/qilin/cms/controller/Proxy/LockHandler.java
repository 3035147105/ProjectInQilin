package com.qilin.cms.controller.Proxy;

import org.apache.log4j.Logger;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * Created by gaohaiqing on 16-7-19.
 * 动态代理
 */
public class LockHandler implements InvocationHandler{

    private Logger logger = Logger.getLogger(this.getClass().getName());
    private Object originalObject;

    public Object bind(Object obj) {
        logger.info("coming here...");
        this.originalObject = obj;
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
        Object result=null;
        if(arg1.getName().startsWith("save")){
            lock();
            result=arg1.invoke(this.originalObject,arg2);//执行的是DomainObjDaoImpl的save方法
            unlock();
        }
        return result;
    }

    private void lock(){
        logger.info("lock object...");
    }

    private void unlock(){
        logger.info("unlock object...");
    }
}
