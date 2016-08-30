package com.qilin.cms.designmodel.Factory.Method;

/**
 * Created by gaohaiqing on 16-8-29.
 *
 * 这个跟exportPdFactory、ExportFactory接口构成了工厂方法模式的核心
 */
public class ExportHTMLFactory implements ExportFactory {
    @Override
    public ExportFile createFactory(String type) {
        if("standerd".equals(type)){
            return new ExportStandHTMLFile();
        }else if("finance".equals(type)){
            return new ExportFinanceHTMLFile();
        }else {
            throw new RuntimeException("没有对应的类型");
        }
    }
}
