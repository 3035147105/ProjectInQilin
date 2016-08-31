package com.qilin.cms.designmodel.Composite;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaohaiqing on 16-8-30.
 *
 * 模拟文件夹
 */
public class Folder extends AbstractComposite {
    private List<AbstractComposite> composites = new ArrayList<>();

    private String name;

    public void addFile(AbstractComposite composite){
        composites.add(composite);
    }

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void kill() {
        System.out.println("已经查杀 "+name);//先查杀自己

        if(composites.size() > 0){
            for(AbstractComposite composite:composites){
                /**
                 * 如果被循环的对象也是文件夹的话，则重新执行方法自己，即此设计模式是天然的递归调用
                 */
                composite.kill();
            }
        }
    }
}
