package com.qilin.cms.ghqAop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gaohaiqing on 16-9-21.
 *
 * 对aop的简单实现
 * 场景：有一个老板类，里面有一个数钱的方法，现在要求统计老板数钱所耗费的时间，并把数钱的结果记录日志中
 * 实现：考虑到 这两种操作都是非常基本的操作，以后很可能在别的方法中也会有类似的要求，所以采用aop的思想来处理，
 * 把这两种方法定义成两个切面
 *
 * 写完这段话，我觉的跟某个设计模式很像，跟继承对应的组合很像，就是这种方式更解耦
 *
 * 还有声明式AOP，内容也比较多
 */
@Controller
@RequestMapping("ghqAop")
public class ghqAop {
    @Autowired
    Boss boss;

    @RequestMapping(value = "")
    public void bossCountMoney(){
        boss.countMoney(2000);
    }


}
