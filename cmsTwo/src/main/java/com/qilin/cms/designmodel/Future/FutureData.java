package com.qilin.cms.designmodel.Future;

/**
 * Created by gaohaiqing on 16-9-30.
 */
public class FutureData implements Data {
    protected RealData realData = null;//含有真实对象的引用

    protected boolean isReady = false;//真实对象是否构建完毕的标识

    public void setRealData(RealData realData) {
        if(isReady){/** 这里应该也是为多线程考虑 **/
            return;
        }
        this.realData = realData;
        isReady = true;
        //notifyAll();//唤醒线程，这个方法是JVM内部去调用，编写代码的人不需要管
    }

    @Override
    public synchronized String getResult() {/** 这里需要优化，加上重入锁synchronized **/
        while (!isReady){//真实对象没构建好，就一直等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.result;
    }
}
