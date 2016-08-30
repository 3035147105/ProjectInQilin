package com.qilin.cms.designmodel.Factory.Method;

/**
 * Created by gaohaiqing on 16-8-29.
 */
public class Client {

    public static void main(String []args){
        ExportFactory exportFactory = new ExportHTMLFactory();
        ExportFile file = exportFactory.createFactory("finance");
        file.export();
    }
}
