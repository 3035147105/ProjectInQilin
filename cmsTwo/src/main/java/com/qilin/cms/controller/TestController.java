package com.qilin.cms.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by gaohaiqing on 16-7-15.
 */
public class TestController {
    private static Log log = LogFactory.getLog(TestController.class);

    public static void main(String[] args){
        TestController test = new TestController();
        test.reduce();
    }

    void lambda(){
        List<String> names = getStringList();
        log.info("排序前：");
        log.info(names.toString());//list有序集合，先进先出

        Collections.sort(names,(o1, o2)-> o1.compareTo(o2));//根据首字母排序，a在前z在后

        log.info("排序后：");
        log.info(names.toString());
    }

    void innerClass(){
        List<String> names = getStringList();
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

    }

    public void stream(){
        List<Integer> list = Arrays.asList(123,123,456,789);
        List<Integer> newList = list.stream().filter(num -> num!=123).collect(Collectors.toList());
        System.out.println("过滤后的新list:"+ newList.toString());
    }

    public void reduce(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        int total = list.stream().reduce(0, (sum,item)->sum+item);
        System.out.println("和为："+ total);
    }

    List<String> getStringList(){
        List strs = Arrays.asList("abc","bbb","ccc");
        return strs;
    }

}
