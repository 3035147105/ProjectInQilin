package com.qilin.cms.designmodel.Factory.Method;

/**
 * Created by gaohaiqing on 16-8-29.
 */
public class ExportStandPdFile implements ExportFile{
    @Override
    public void export() {
        System.out.println("导出标准Pd逻辑");
    }
}
