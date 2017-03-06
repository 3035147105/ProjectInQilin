package com.qilin.cms.algorithm.MoneyTreeNodePac;

/**
 * Created by gaohaiqing on 17-3-6.
 * 三叉树
 */
public class MoneyTreeNode {
    public int value;
    public MoneyTreeNode leftMoneyTree;
    public MoneyTreeNode middleMoneyTree;
    public MoneyTreeNode rightMoneyTree;

    public MoneyTreeNode(){
    }

    public MoneyTreeNode(int value, MoneyTreeNode leftMoneyTree, MoneyTreeNode middleMoneyTree, MoneyTreeNode rightMoneyTree) {
        this.value = value;
        this.leftMoneyTree = leftMoneyTree;
        this.middleMoneyTree = middleMoneyTree;
        this.rightMoneyTree = rightMoneyTree;
    }


}
