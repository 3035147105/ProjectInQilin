package com.qilin.cms.designmodel.State;

/**
 * Created by gaohaiqing on 16-9-8.
 *
 * 刷票
 */
public class BadVote implements State {

    @Override
    public void handle(String username, String voteItem, Context context) {
        String str = context.getMapVote().get(username);
        if(str != null){
            context.getMapVote().remove(username);
        }
        System.out.println(username+"存在恶意刷票行为，已被废除投票记录");
    }
}
