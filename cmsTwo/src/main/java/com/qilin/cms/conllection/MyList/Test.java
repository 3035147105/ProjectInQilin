package com.qilin.cms.conllection.MyList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by gaohaiqing on 16-8-17.
 *
 * 集合部分的测试类
 * ArrayList, LinkedList,  HashMap, HashTable, HashSet, ConcurrentHashMap
 */
public class Test {
    private static final Log log = LogFactory.getLog("MyList测试类");

    public static void main(String[] args){
        Test test = new Test();
        MyList myList = test.add();
        test.forEach(myList);
    }

    private MyList add(){
        MyList<Integer> myList = new MyArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        return myList;
    }

    private void forEach(MyList myList){
        for(int i = 0; i<myList.size(); i++){
            log.info(myList.get(i)+" ");
        }
    }
}
