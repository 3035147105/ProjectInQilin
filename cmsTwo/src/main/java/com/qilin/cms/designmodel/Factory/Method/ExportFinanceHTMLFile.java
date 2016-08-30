package com.qilin.cms.designmodel.Factory.Method;

/**
 * Created by gaohaiqing on 16-8-29.
 */
public class ExportFinanceHTMLFile implements ExportFile{

    @Override
    public void export() {
        System.out.println("导出财务HTML逻辑");
    }
}
