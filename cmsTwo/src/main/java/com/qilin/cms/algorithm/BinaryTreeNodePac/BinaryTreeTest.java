package com.qilin.cms.algorithm.BinaryTreeNodePac;

import com.qilin.cms.algorithm.MoneyTreeNodePac.MoneyTreeNode;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by gaohaiqing on 17-3-2.
 *
 * http://blog.csdn.net/luckyxiaoqiang/article/details/7518888/  参考这篇博客
 */
public class BinaryTreeTest {
    /**
     * 生产一个二叉树实例
     * @return
     */
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
     * 使用FIFO集合辅助实现
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
    /**
     * 将二叉查找树变为有序的双向链表
     */
//    public void Convert(BinaryTreeNode  pRoot, BinaryTreeNode pFirstNode, BinaryTreeNode pLastNode){
//        BinaryTreeNode pFirstLeft;
//        BinaryTreeNode pLastLeft;
//        BinaryTreeNode pFirstRight;
//        BinaryTreeNode pLastRight;
//        if (pRoot == null){
//            pFirstNode = null;
//            pLastNode = null;
//            return;
//        }
//        if (pRoot.getLeftTree() == null){
//            pFirstNode = pRoot;
//        }else {
//            Convert(pRoot.getLeftTree(), pFirstLeft, pLastLeft);
//            pFirstNode = pFirstLeft;
//            pRoot.leftTree = pLastLeft;
//            pLastLeft.rightTree = pRoot;
//        }
//
//        if (pRoot.getRightTree() == null){
//            pLastNode = pRoot;
//        }else {
//            Convert(pRoot.getRightTree(), pFirstRight, pLastRight);
//            pLastNode = pLastRight;
//            pRoot.rightTree = pFirstRight;
//            pFirstRight.leftTree = pRoot;
//        }
//    }

    /**
     * 求二叉树的镜像
     * @param node
     * @return
     */
    public BinaryTreeNode mirror(BinaryTreeNode node){
        if (node == null)
            return null;
        BinaryTreeNode left = mirror(node.getLeftTree());
        BinaryTreeNode right = mirror(node.getRightTree());
        node.leftTree = right;
        node.rightTree = left;
        return node;
    }

    /**
     * 求二叉树中两个节点的最低公共祖先节点
     * @param pRoot   二叉树源
     * @param pRoot1  第一个节点
     * @param pRoot2  第二个节点
     * @return  最低公共祖先节点
     */
    public BinaryTreeNode getLastCommonParent(BinaryTreeNode pRoot, BinaryTreeNode pRoot1, BinaryTreeNode pRoot2){
        if (pRoot == null)
            return null;
        if (pRoot1 == null || pRoot2 == null)
            return null;
        //假设一定有公共的祖先节点
        BinaryTreeNode tmp1Root;
        while (true){
            tmp1Root = a(pRoot, pRoot1);
            if (tmp1Root != null){
                return pRoot1;
            }
            pRoot = pRoot.leftTree;
        }
    }

    public BinaryTreeNode a(BinaryTreeNode pRoot, BinaryTreeNode pRoot1){
        if(pRoot.leftTree.value == pRoot1.value || pRoot.rightTree.value == pRoot1.value){
            return pRoot;
        }
        return null;
    }
}
