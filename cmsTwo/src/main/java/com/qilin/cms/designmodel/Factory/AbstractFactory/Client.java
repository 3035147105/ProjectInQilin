package com.qilin.cms.designmodel.Factory.AbstractFactory;

/**
 * Created by gaohaiqing on 16-8-29.
 */
public class Client {
    public static void main(String[] args){
        ComputeEngin ce = new ComputeEngin();
        AbstractFactory af = new IntelFactory();
        ce.prepareHardwares(af);

    }
}
