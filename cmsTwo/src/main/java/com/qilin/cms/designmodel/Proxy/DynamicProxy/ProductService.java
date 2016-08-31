package com.qilin.cms.designmodel.Proxy.DynamicProxy;

/**
 * Created by gaohaiqing on 16-8-31.
 *
 * 保存商品的Service
 */
public class ProductService implements IService {
    @Override
    public void saveObj() {
        System.out.println("模拟保存【商品】的方法逻辑！！");
    }
}
