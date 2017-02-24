package com.qilin.cms.algorithm;

/**
 * Created by gaohaiqing on 17-1-12.
 *
 * 与算法相关的一些记录
 */
public class AlgorithmClient {

    public static void main(String[] args){
        AlgorithmClient alg = new AlgorithmClient();
        alg.hundred(3294385);
    }

    /**
     * 简单的取一个数字的个、十、百位
     * @param number  正整数(三位)
     *                输出 百位数、十位数、个位数
     */
    public void hundred(int number){
        if(number>999 || number<100){
            System.out.println("请输入一个三位数");
            return;
        }
        int baiwei = number/100;
        int shiwei = number%100/10;
        int gewei = number%100%10;
        System.out.println("个位："+gewei+"十位："+shiwei+"百位："+baiwei);
    }

    public void suanfa1(){
        int result = 0;
        int i = 10000;
        while (i<100000){
            if((i%3==0) && (i%10==6)) {
                result += 1;
            }
            i+=1;
        }
        System.out.println("个位数为6,且能被3整除的5位整数共有" + result + "个");
    }

    /**
     * 1~100之间的所有质数
     */
    public void suanfa2(){
        for(int i=1; i<=100; i++){
            boolean a  = true;
            if(i != 1){
                for(int n=2;n<i;n++){
                    if(i%n == 0){
                        a = false;
                        break;
                    }
                }
            }
            if (a){
                System.out.println(i+"是质数");
            }
        }
    }

}
