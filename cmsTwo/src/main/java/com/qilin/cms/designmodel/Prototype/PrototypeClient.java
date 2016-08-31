package com.qilin.cms.designmodel.Prototype;

/**
 * Created by gaohaiqing on 16-8-30.
 *
 * 原型模式
 * 深层克隆是对地址的复制，两个对象中的包含对象也是两个地址，使用序列化和反序列化实现
 * 浅层克隆是对值的复制，两个对象中的包含对象是一个地址，使用Object的clone方法实现
 */
public class PrototypeClient {
    public static void main(String []args){
        Prototype p1 = new ConcretePrototypeOne();
        PrototypeManager.setPrototype("p1", p1);
        //获取原型来创建对象
        Prototype p3 = PrototypeManager.getPrototype("p1").clone();
        p3.setName("张三");
        System.out.println("第一个实例：" + p3);
        //有人动态的切换了实现
        Prototype p2 = new ConcretePrototypeTwo();
        PrototypeManager.setPrototype("p1", p2);
        //重新获取原型来创建对象
        Prototype p4 = PrototypeManager.getPrototype("p1").clone();
        p4.setName("李四");
        System.out.println("第二个实例：" + p4);
        //有人注销了这个原型
        PrototypeManager.removePrototype("p1");
        //再次获取原型来创建对象
        Prototype p5 = PrototypeManager.getPrototype("p1").clone();
        p5.setName("王五");
        System.out.println("第三个实例：" + p5);
    }
}
