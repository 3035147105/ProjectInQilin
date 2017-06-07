package com.qilin.cms.algorithm.Sort;

/**
 * Created by lenovo on 2017/5/10.
 *
 * 冒泡排序算法——java实现
 */
public class BubbleSort {

    public static void bubbleSort(Comparable[] data){
        boolean flag = true;
        Comparable tmp;
        for(int i=0, len= data.length; i<len-1 && flag; i++){
            flag = false;
            for(int j=0; j<len-1-i; j++){
                if(data[j].compareTo(data[j+1]) < 0){
                    tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                    flag = true;
                }
                System.out.println("第"+j+"遍：{");
                for (int position=0; position<data.length; position++){
                    System.out.print(data[position]+ ",");
                }
                System.out.println("}");
            }
            System.out.println("---------------"+i+"---------------");
        }


    }
}
