package com.qilin.cms.controller;

/**
 * Created by gaohaiqing on 16-7-15.
 * java8之后，可以在接口中实现静态方法
 */
public interface JavaEigntInterface {
    default String myMethod(){
        return "接口的默认方法";
    }

    //静态方法
    static double jisuan(double a, double b){
        return a + b;
    }
}
