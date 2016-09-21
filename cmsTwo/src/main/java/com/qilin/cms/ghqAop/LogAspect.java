package com.qilin.cms.ghqAop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by gaohaiqing on 16-9-21.
 *
 * 打印日志的切面，在目标方法执行完后执行
 */
@Aspect//告诉spring，我是一个切面,what
@Component
public class LogAspect {

    @Pointcut("execution(* com.qilin.cms.ghqAop.Boss.signIn(..))")//切点，where
    private void logPointCut(){
        /**
         * 解释：切面在哪里执行。这里是在com.qilin.cms.ghqAop包及其子包中调用bookFlight方法时
         */
    }
    public static final String EDP = "execution(* com.qilin.cms.ghqAop.Boss.sign*(..))";
    /**
     * 什么时候执行这个切面，where
     */
    @After(EDP)
    public void logCountMoney(){
        System.out.println("=====================================");
        System.out.println("我是后直通知，执行了");
    }


}
