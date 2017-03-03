package com.qilin.cms.algorithm.BinaryTreeNodePac;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by gaohaiqing on 17-3-2.
 *
 * http://blog.csdn.net/luckyxiaoqiang/article/details/7518888/  参考这篇博客
 */
public class BinaryTreeTest {

    public BinaryTreeNode produceData(){
        BinaryTreeNode left2 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode right1 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode left1 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode right = new BinaryTreeNode(3, left2, null);
        BinaryTreeNode left = new BinaryTreeNode(2, left1, right1);
        BinaryTreeNode orign = new BinaryTreeNode(1, left,  right);

        return orign;
    }

    /**
     * 求二叉树的节点个数
     * @param node
     * @return
     */
    public int getNodeNum(BinaryTreeNode node){
        if(node == null)
            return 0;
        return getNodeNum(node.getLeftTree()) + getNodeNum(node.getRightTree()) + 1;
    }

    /**
     * 求二叉树深度
     * @param node
     * @return
     */
    public int getDepth(BinaryTreeNode node){
        if(node == null)
            return 0;
        int leftDepth = getDepth(node.getLeftTree());
        int rightDepth = getDepth(node.getRightTree());
        return  (leftDepth > rightDepth ? leftDepth : rightDepth)+1;
    }

    /**
     * 二叉树前序遍历
     * @param node
     */
    public void preVisit(BinaryTreeNode node){
        if (node == null)
            return;
        System.out.print(node.getValue()+" ");
        preVisit(node.getLeftTree());
        preVisit(node.getRightTree());
    }

    /**
     * 二叉树中序遍历
     * @param node
     */
    public void middleVisit(BinaryTreeNode node){
        if (node == null)
            return;
        middleVisit(node.getLeftTree());
        System.out.print(node.getValue()+" ");
        middleVisit(node.getRightTree());
    }

    /**
     * 二叉树后序遍历
     * @param node
     */
    public void postVisit(BinaryTreeNode node){
        if (node == null)
            return;
        postVisit(node.getLeftTree());
        postVisit(node.getRightTree());
        System.out.print(node.getValue()+" ");
    }

    /**
     * 分层遍历，按照从上往下，从左往右的方式遍历二叉树
     * @param node
     */
    public void levelVisit(BinaryTreeNode node){
        if (node == null)
            return;
        Queue<BinaryTreeNode> queue = new ArrayBlockingQueue(100);
        queue.offer(node);
        BinaryTreeNode treeNode;
        while (!queue.isEmpty()){
            treeNode = queue.poll();
            System.out.print(treeNode.getValue()+" ");

            if (treeNode.getLeftTree() != null)
                queue.offer(treeNode.getLeftTree());
            if (treeNode.getRightTree() != null)
                queue.offer(treeNode.getRightTree());
        }
    }

    public void Convert(BinaryTreeNode  pRoot, BinaryTreeNode pFirstNode, BinaryTreeNode pLastNode){

    }
}
