package com.qilin.cms.designmodel.Facade;

/**
 * Created by gaohaiqing on 16-9-2.
 *
 * 模拟内部方法1
 */
public class Moudle {

    public void outmethod(){
        System.out.println("类Moudle曝露给系统外部的方法");
    }

    public void inmethod(){
        System.out.println("类Moudle提供的方法，供系统内部调用");
    }
}
