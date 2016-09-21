package com.qilin.cms.ghqAop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * Created by gaohaiqing on 16-9-21.
 */
@Component
public class Boss {
    /**
     * 模拟老板数钱的方法
     */
    public void signIn(){
        System.out.println("签到方法执行了！！");
    }
}
