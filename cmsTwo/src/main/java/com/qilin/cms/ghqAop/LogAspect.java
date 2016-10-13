package com.qilin.cms.ghqAop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
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

    /**
     * 解释：切面在哪里执行。即切点，where
     */
    @Pointcut("execution(* com.qilin.cms.ghqAop.Boss.countMoney(..))")//这里可以多练习
    private void logPointCut(){
    }

    /**
     * 什么时候执行这个切面，when
     */
    @After("logPointCut()")//最终通知
    public void afterlog(){
        System.out.println("我是最终通知");
    }

    @AfterReturning(pointcut = "logPointCut()", returning = "money")//
    public void afterReturnlog(int money){
        System.out.println("一共数了"+ money +"元钱");
    }


    @Before("logPointCut()")
    public void beforlog(){
        System.out.println("我是前置通知，应该在目标方法 前 执行");
    }

    @Around("logPointCut()")
    public Object aroundlog(ProceedingJoinPoint joinPoint){
        System.out.println("环绕通知执行了！");
        long startTime = System.currentTimeMillis();
        Object[] args = joinPoint.getArgs();
        int money = (int)args[0];

        System.out.println("参数的长度："+args.length +",第一个参数是："+money);
        Object o = null;
        try {
            /**
             * ProceedingJoinPoint可以调用代理的方法，获取参数和返回值
             */
            o = joinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("执行这个方法所耗费的时间："+(endTime - startTime)+"毫秒");
        return o;
    }

    /**
     * 执行顺序：
     * 环绕通知，前置通知，目标方法，环绕通知，后置通知
     */

}
