package com.qilin.cms.interview;

import com.google.common.base.Strings;

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
    /**反转字符串**/
    public void  reverse(String s){
        if(!Strings.isNullOrEmpty(s)){
            String ss = s.replace(" ","");
            char[] chars = ss.toCharArray();
            for(int i=chars.length-1; i>=0; i--){
                System.out.print(chars[i]);
            }
            System.out.println("");
        }
    }
    /**清除空格**/
    public void clearBlank(){
        String s = " 你 好，世   界";
        String ss = s.replace(" ","");
        //String的replace会返回一个新的字符串
        System.out.println(s);
        System.out.println(ss);
    }

}











//================================================解答区==========================

// 题目1解答：  s2 += 1 => s2 = (short)(s2 + 1);  隐藏的强制类型转换