package com.qilin.cms.designmodel.State;

/**
 * Created by gaohaiqing on 16-9-8.
 *
 * 重复投票
 */
public class RepeVote implements State{

    @Override
    public void handle(String username, String voteItem, Context context) {
        System.out.println(username+"请不要重复投票，否则将面临惩罚");
    }
}
