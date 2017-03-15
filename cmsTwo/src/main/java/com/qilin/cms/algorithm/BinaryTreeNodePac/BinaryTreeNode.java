package com.qilin.cms.algorithm.BinaryTreeNodePac;

/**
 * Created by gaohaiqing on 17-3-2.
 * 二叉树实体
 */
public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode leftTree;
    public BinaryTreeNode rightTree;

    public BinaryTreeNode(){
    }
    public BinaryTreeNode(int value){
        this.value = value;
    }

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

    public void setLeftTree(BinaryTreeNode leftTree) {
        this.leftTree = leftTree;
    }

    public void setRightTree(BinaryTreeNode rightTree) {
        this.rightTree = rightTree;
    }
}
