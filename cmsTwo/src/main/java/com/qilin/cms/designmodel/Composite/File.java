package com.qilin.cms.designmodel.Composite;

/**
 * Created by gaohaiqing on 16-8-30.
 *
 * 模拟杀毒软件的杀毒过程
 *
 * 其中文件夹的杀毒方法是天然递归
 */
public class File extends AbstractComposite{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File(String name) {
        this.name = name;
    }

    @Override
    public void kill() {
        System.out.println("已经查杀 "+name);
    }
}
