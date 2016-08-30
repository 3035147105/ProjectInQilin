package com.qilin.cms.designmodel.Factory.Method;

/**
 * Created by gaohaiqing on 16-8-29.
 */
public class ExportFinancePdFile implements ExportFile {
    @Override
    public void export() {
        System.out.println("导出财务Pd逻辑");
    }
}
