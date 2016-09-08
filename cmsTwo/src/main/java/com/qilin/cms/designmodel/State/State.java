package com.qilin.cms.designmodel.State;

/**
 * Created by gaohaiqing on 16-9-8.
 */
public interface State {
    void handle(String username, String voteItem, Context context);
}
