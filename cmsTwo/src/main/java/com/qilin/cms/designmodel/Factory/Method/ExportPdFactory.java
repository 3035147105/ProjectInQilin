package com.qilin.cms.designmodel.Factory.Method;

/**
 * Created by gaohaiqing on 16-8-29.
 */
public class ExportPdFactory implements ExportFactory {
    @Override
    public ExportFile createFactory(String type) {
        if("standerd".equals(type)){
            return new ExportStandPdFile();
        }else if("finance".equals(type)){
            return new ExportFinancePdFile();
        }else {
            throw new RuntimeException("没有对应的类型");
        }
    }
}
