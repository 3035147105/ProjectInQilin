package com.qilin.cms.designmodel.State;

/**
 * Created by gaohaiqing on 16-9-8.
 */
public class NormalVote implements State{

    @Override
    public void handle(String username, String voteItem, Context context) {
        context.getMapVote().put(username, voteItem);
        System.out.println(username+"投票给"+voteItem+"成功");
    }
}
