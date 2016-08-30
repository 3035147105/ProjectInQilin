package com.qilin.cms.designmodel.Factory.AbstractFactory;

/**
 * Created by gaohaiqing on 16-8-29.
 *
 * 装配计算机,模拟现实世界中的 装机师傅
 */
public class ComputeEngin {

    private ICPU cpu;

    private IMainBord mainBord;

    public void prepareHardwares(AbstractFactory af){
        this.cpu = af.createCpu();
        this.mainBord = af.createMainBord();

        this.cpu.caculate();
        this.mainBord.installCPU();
    }

}
