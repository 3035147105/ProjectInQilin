package com.qilin.cms;

import com.qilin.cms.interview.index;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by gaohaiqing on 17-2-22.
 */
public class main {
    public static void main(String[] args){
//        index ind = new index();
//        ind.reverse("一二三四五");

//        List list = new ArrayList();
//        list.add("你");
//        list.add("好");
//        list.add("，");
//        list.add("世");
//        list.add("界");
//        list.remove(3);
//        for (int i=0; i<list.size(); i++){
//            System.out.print(list.get(i));
//        }
//        List listL = new LinkedList();
//        listL.add("一");
//        listL.add("二");
//        listL.add("三");
//        listL.add("四");
//        System.out.println(listL.get(3));
//        System.out.println(listL.get(2));
//        System.out.println(listL.get(1));
//        System.out.println(listL.get(0));
        Random random = new Random();
        for(int i=0; i<10; i++){
            System.out.println(random.nextInt(2));
        }
    }

}
