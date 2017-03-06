package com.qilin.cms.algorithm.MoneyTreeNodePac;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by gaohaiqing on 17-3-6.
 */
public class MoneyTreeTest {
    /**
     * 生产一个三叉树实例
     * @return
     */
    public MoneyTreeNode produceMoneyTreeData(){
        MoneyTreeNode left1 = new MoneyTreeNode(5, null, null, null);
        MoneyTreeNode middle1 = new MoneyTreeNode(6, null, null, null);
        MoneyTreeNode left2 = new MoneyTreeNode(7, null, null, null);
        MoneyTreeNode left = new MoneyTreeNode(2, null, null, null);
        MoneyTreeNode middle = new MoneyTreeNode(3, left2 , null, null);
        MoneyTreeNode right = new MoneyTreeNode(4, left1, middle1, null);
        MoneyTreeNode origin = new MoneyTreeNode(1, left, middle, right);
        return origin;
    }

    /**
     * 分层遍历三叉树实例（从左到右，从上到下）
     */
    public void levelMoneyTreeNode(MoneyTreeNode moneyTreeNode){
        if (moneyTreeNode == null)
            return;
        Queue<MoneyTreeNode> queue = new ArrayBlockingQueue(100);
        queue.offer(moneyTreeNode);

        MoneyTreeNode moneyTree;
        while (!queue.isEmpty()){//对队列的操作
            moneyTree = queue.poll();
            System.out.print(moneyTree.value+" ");

            if (moneyTree.leftMoneyTree != null)
                queue.offer(moneyTree.leftMoneyTree);
            if (moneyTree.middleMoneyTree != null)
                queue.offer(moneyTree.middleMoneyTree);
            if (moneyTree.rightMoneyTree != null)
                queue.offer(moneyTree.rightMoneyTree);
        }
    }

    /**
     * 三叉树的镜像
     * @param moneyTreeNode
     */
    public MoneyTreeNode mirror(MoneyTreeNode moneyTreeNode){
        if (moneyTreeNode == null)
            return moneyTreeNode;
        MoneyTreeNode leftTreeNode = mirror(moneyTreeNode.leftMoneyTree);
        MoneyTreeNode rightTreeNode = mirror(moneyTreeNode.rightMoneyTree);

        moneyTreeNode.leftMoneyTree = rightTreeNode;
        moneyTreeNode.rightMoneyTree = leftTreeNode;
        return moneyTreeNode;
    }

}
