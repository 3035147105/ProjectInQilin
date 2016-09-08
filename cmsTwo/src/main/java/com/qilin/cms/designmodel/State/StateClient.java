package com.qilin.cms.designmodel.State;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by gaohaiqing on 16-9-8.
 *
 * 状态模式
 * 适用于状态多而容易改变的情况下
 *
 * 模拟案例：投票系统实现
 * 分下面几种状态：正常投票，即一人一票；重复投票，一人多于一张少于5张；刷票：多于5张少于10张；黑名单：10张以上
 * 不同状态下的行为：
 * 正常投票：投票生效
 * 重复投票：警告你已经多次投票了
 * 刷票：禁止此人投票；并且把他的投票全部作废
 * 黑名单：禁止此人使用此系统
 */
public class StateClient {
    /**
     * 这种模拟的情况是：每个人只有一张票，且只能投一次
     * 不实用！ 存储投票记录的容易不应该只是个简单的Map,这里只是模拟
     * @param args
     */
    public static  void main(String[] args){
        Context context = new Context();
        context.vote("ghq", "java");
        context.vote("ghq", "java");
        context.vote("ghq", "java");
        context.vote("tk", "java");
        context.vote("xwl", "java");
        context.vote("hh", "c#");
        System.out.println("==========================投票结果===================");
        Map<String,String> mapVote = context.getMapVote();
        Iterator<String> iterator = mapVote.keySet().iterator();
        String key;
        while (iterator.hasNext()){
            key = iterator.next();
            System.out.println(key+"投给:"+mapVote.get(key));
        }
    }
}
