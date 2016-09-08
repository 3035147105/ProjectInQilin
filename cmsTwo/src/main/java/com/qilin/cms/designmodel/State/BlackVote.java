package com.qilin.cms.designmodel.State;

/**
 * Created by gaohaiqing on 16-9-8.
 *
 * 加入黑名单
 */
public class BlackVote implements State{


    @Override
    public void handle(String username, String voteItem, Context context) {
        System.out.println(username+"用户不听劝告，已加入系统黑名单，禁止使用此投票系统");
    }
}
