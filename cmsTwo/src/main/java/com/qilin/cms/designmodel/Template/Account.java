package com.qilin.cms.designmodel.Template;

/**
 * Created by gaohaiqing on 16-9-5.
 */
public abstract class Account {
    /**
     * 模板方法，逻辑不可变
     * @return
     */
    public final double caculateInterest(){
        String type = doCalculateAccountType();
        double rate = doCalculateInterestRate();
        double amount = calculateAmount();
        return amount * rate;
    }

    /**
     * 留给子类实现
     * @return
     */
    protected abstract String  doCalculateAccountType();

    /**
     * 留给子类实现
     * @return
     */
    protected abstract double doCalculateInterestRate();

    /**
     * 返回存款金额
     * @return
     */
    private double calculateAmount(){
        return 10000;
    }


}
