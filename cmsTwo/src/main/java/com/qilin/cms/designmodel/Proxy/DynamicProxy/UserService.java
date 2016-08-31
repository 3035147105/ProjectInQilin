package com.qilin.cms.designmodel.Proxy.DynamicProxy;

/**
 * Created by gaohaiqing on 16-8-31.
 *
 * 保存用户的Service
 */
public class UserService implements IService {
    @Override
    public void saveObj() {
        System.out.println("模拟保存【用户】的方法逻辑！！");
    }
}
