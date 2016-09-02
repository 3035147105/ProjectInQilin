package com.qilin.cms.designmodel.Facade;

/**
 * Created by gaohaiqing on 16-9-2.
 *
 * 门面角色
 */
public class Facade {
    /**
     * 不提供get、set方法的话，反射应该也执行不了Moudle类中不想曝露的方法inmethod
     *
     * 这样是很安全的了吧
     */
    private Moudle moudle = new Moudle();//可见性定为private,只有在此类内部可以被调用

    /**
     * 系统曝露这个方法给系统外部
     */
    public void facade(){
        moudle.outmethod();
    }
}
