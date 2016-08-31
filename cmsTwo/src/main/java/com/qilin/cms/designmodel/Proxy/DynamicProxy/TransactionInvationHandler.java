package com.qilin.cms.designmodel.Proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by gaohaiqing on 16-8-31.
 *
 * 动态代理对象，模拟在 业务逻辑前后 增加事物操作
 *
 * 使用的是 java自带的代理对象，听说这个自带对象的功能有些简单！
 *
 * 事物这一块很多框架都搞的很好了，不需要自己写了！
 */
public class TransactionInvationHandler implements InvocationHandler{
    private Object target;//目标对象

    public TransactionInvationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object retValue = null;
        try {
            System.out.println("模拟打开事物动作");

            retValue = method.invoke(target, args);//执行目标对象的方法

            System.out.println("模拟提交事物操作");
        }catch (Exception e){
            System.out.println("模拟事物回滚动作");
        }finally {
            System.out.println("模拟关闭事物动作");
        }
        return retValue;
    }
}
