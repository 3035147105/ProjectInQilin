package com.qilin.cms.algorithm.BinaryTreeNodePac;

import com.qilin.cms.algorithm.MoneyTreeNodePac.MoneyTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by gaohaiqing on 17-3-2.
 *
 * http://blog.csdn.net/luckyxiaoqiang/article/details/7518888/  参考这篇博客
 */
public class BinaryTreeTest {
    public boolean isSame(BinaryTreeNode node1, BinaryTreeNode node2){
        return false;
    }


    public BinaryTreeNode produceData1(){
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode orign = new BinaryTreeNode(0);
        orign.setLeftTree(node1);
        orign.setRightTree(node2);
        node1.setLeftTree(node3);
        node1.setRightTree(node4);
        node4.setLeftTree(node6);
        node2.setLeftTree(node5);
        node5.setLeftTree(node7);
        return orign;
    }
    public BinaryTreeNode produceData2(){
        BinaryTreeNode orign = new BinaryTreeNode(0);
        BinaryTreeNode orign1 = new BinaryTreeNode(1);
        BinaryTreeNode orign2 = new BinaryTreeNode(2);
        BinaryTreeNode orign3 = new BinaryTreeNode(3);
        BinaryTreeNode orign4 = new BinaryTreeNode(4);
        BinaryTreeNode orign5 = new BinaryTreeNode(5);
        BinaryTreeNode orign6 = new BinaryTreeNode(6);
        BinaryTreeNode orign7 = new BinaryTreeNode(7);
        orign.setLeftTree(orign2);
        orign.setRightTree(orign1);
        orign2.setLeftTree(orign5);
        orign5.setRightTree(orign7);
        orign1.setLeftTree(orign4);
        orign1.setRightTree(orign3);
        orign4.setLeftTree(orign6);
        return orign;
    }
    /**
     * 生产一个二叉树实例
     * @return
     */
    public BinaryTreeNode produceData(){
        BinaryTreeNode right2 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode left2 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode right1 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode left1 = new BinaryTreeNode(4, null, right2);
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
     * @param pNode1  第一个节点
     * @param pNode2  第二个节点
     * @return  最低公共祖先节点
     * 思路：先找出根节点到两个节点的路径，然后（倒正）依次比较两条路径上的元素，找到相同的那个，即是最低公共祖先节点
     *
     * 想法是好的，但现实操作没那么简单，找的时候总是从左往右找，不是预期的那种找法
     */
    public BinaryTreeNode getLastCommonParent(BinaryTreeNode pRoot, BinaryTreeNode pNode1, BinaryTreeNode pNode2){
        if (pRoot == null || pNode1 == null || pNode2 == null){
            return null;
        }
        List<BinaryTreeNode> list1 = new ArrayList<>();
        boolean isFound1 = find(pRoot, pNode1, list1);
        List<BinaryTreeNode> list2 = new ArrayList<>();
        boolean isFound2 = find(pRoot, pNode2, list2);
        //isFound1和isFound2有一个为false，说明传进来的两个节点至少有一个不在此二叉树中
        if (isFound1 && isFound2){
            return null;
        }
        System.out.println("-----------------第一个元素经过的路径：");
        seeList(list1);
        System.out.println("-----------------第二个元素经过的路径：");
        seeList(list2);
        BinaryTreeNode lastCommonParent = new BinaryTreeNode();
//        boolean flag = false;
//        for (int i = list1.size()-1; i >= 0; i--){
//           for (int j = list2.size()-1; j >= 0; j--){
//               if (list1.get(i).value == list2.get(i).value){
//                   lastCommonParent = list1.get(i);
//                   flag = true;
//                   break;
//               }
//           }
//           if (flag)
//               break;
//        }
        return lastCommonParent;
    }
    public void seeList(List<BinaryTreeNode> list){
        for (int j = list.size()-1; j >= 0; j--){
            System.out.print(list.get(j).value);
        }
        System.out.println();
    }
    /**
     * 将根节点到指定节点之间的元素都保存到list中
     * @param pRoot  根节点
     * @param pNode  指定节点
     * @param list   栈-LIFO
     * @return
     */
    public boolean find(BinaryTreeNode pRoot, BinaryTreeNode pNode, List<BinaryTreeNode> list){
        if (pRoot == null)
            return false;
        if (pRoot.value == pNode.value){
            return true;
        }
        list.add(pRoot);
        boolean isFound;
        isFound = find(pRoot.leftTree, pNode, list);
        if (!isFound){
            find(pRoot.rightTree, pNode, list);
        }
//        if (!isFound)
//            queue.poll();
        return isFound;
    }

}
