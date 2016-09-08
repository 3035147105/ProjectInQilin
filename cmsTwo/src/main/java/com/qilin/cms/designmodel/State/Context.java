package com.qilin.cms.designmodel.State;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaohaiqing on 16-9-8.
 *
 * 模拟投票环境
 */
public class Context {
    private Map<String, String> mapVote = new HashMap<>();//投票结果记录
    private Map<String, Integer> mapVoteCount = new HashMap<>();//记录每个人投了多少票，从而进行不同的状态处理
    private State state;

    public void vote(String username,String item){//模拟投票动作。item：投票选项，username:投票人
        Integer count = mapVoteCount.get(username);
        if(count == null){
            count = 0;
        }
        count += 1;
        mapVoteCount.put(username, count);
        /**
         * 正常投票，即一人一票；
         * 重复投票，一人多于1张少于等于5张；
         * 刷票：多于5张少于等于10张；
         * 黑名单：10张以上
         */
        if(1 == count){
            state = new NormalVote();
        }else if((1<count) && (5>=count)){
            state = new RepeVote();
        }else if((5<count) && (10>=count)){
            state = new BadVote();
        }else if(10<count){
            state = new BlackVote();
        }
        state.handle(username, item, this);
    }

    public Map<String, String> getMapVote() {
        return mapVote;
    }

}
