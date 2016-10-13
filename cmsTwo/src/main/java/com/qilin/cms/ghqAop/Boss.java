package com.qilin.cms.ghqAop;

import org.springframework.stereotype.Component;

/**
 * Created by gaohaiqing on 16-9-21.
 */
@Component
public class Boss {
    /**
     * 模拟老板数钱的方法
     */
    public int countMoney(int money){
        System.out.println("数钱方法执行了！！");

        return money;
    }
}
