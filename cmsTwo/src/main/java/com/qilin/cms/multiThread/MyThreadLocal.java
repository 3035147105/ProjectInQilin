package com.qilin.cms.multiThread;

import java.util.Scanner;

/**
 * Created by lenovo on 2016/10/24.
 *
 * 重大网教程序设计题
 */
public class MyThreadLocal {
    public static void main(String args[])
    {
        MyThreadLocal mtl = new MyThreadLocal();
        mtl.F();
    }
    public void F(){
        int x=0,y=0,a=0,b=0;
        switch (x){
            
        }
    }
    public void E(int a,int b,int c){
        int d = Math.min(a,b);
        int min = Math.min(d,c);
        System.out.println("最小值："+min);
    }

    public void D(){
        int i[][]  = {{1,2,3},{4,5},{6},{0}};
        System.out.println(i[0][0]);
        System.out.println(i[1][0]);
        System.out.println(i[2][0]);
    }

    public void A(){
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
    public void B(){
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
    public void C(){
        System.out.println("请输入一个整数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        for(int i=1;i<=n;i++){
            sum += i;
        }
        System.out.println("从1到"+n+"的累加和是："+sum);
    }
}
