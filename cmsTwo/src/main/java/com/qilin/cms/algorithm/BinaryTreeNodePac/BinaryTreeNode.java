package com.qilin.cms.algorithm.BinaryTreeNodePac;

/**
 * Created by gaohaiqing on 17-3-2.
 * 二叉树实体
 */
public class BinaryTreeNode {
    private int value;
    private BinaryTreeNode leftTree;
    private BinaryTreeNode rightTree;

    public BinaryTreeNode(int value, BinaryTreeNode leftTree, BinaryTreeNode rightTree) {
        this.value = value;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }

    public int getValue() {
        return value;
    }

    public BinaryTreeNode getLeftTree() {
        return leftTree;
    }

    public BinaryTreeNode getRightTree() {
        return rightTree;
    }
}
