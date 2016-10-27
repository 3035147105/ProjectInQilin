package com.qilin.cms.interview;

/**
 * Created by gaohaiqing on 16-10-27.
 *
 * 面试题 相关
 */
public class index {


    public void 类型转换(){//1
        short s1 = 1;
        //s1 = s1 + 1;

        short s2 = 1;
        s2 += 1;

        //这一行通过编译，被注释掉的那行不能通过编译，为什么？
    }

}











//================================================解答区==========================

// 题目1解答：  s2 += 1 => s2 = (short)(s2 + 1);  隐藏的强制类型转换