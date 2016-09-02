package com.qilin.cms.designmodel.Facade;

/**
 * Created by gaohaiqing on 16-9-2.
 *
 * 门面模式
 *
 * 功能：
 * 1.能够选择性的暴露方法
 * 2.隐藏了子系统Moudle的实现细节
 */
public class FacadeClient {

    public static void main(String []args){
        //客户端只与门面角色打交道
        Facade facade = new Facade();
        facade.facade();//门面角色只曝露该曝露的方法；也隐藏了Moudle的实现细节

    }

}
