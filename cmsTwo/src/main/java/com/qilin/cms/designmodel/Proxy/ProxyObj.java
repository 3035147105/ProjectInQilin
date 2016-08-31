package com.qilin.cms.designmodel.Proxy;

/**
 * Created by gaohaiqing on 16-8-31.
 */
public class ProxyObj extends AbstractObj {
    RealObj realObj = new RealObj();
    @Override
    void operation() {
        System.out.println("调用真实对象前的一些操作");
        realObj.operation();
        System.out.println("调用真实对象后的一些操作");
    }
}
