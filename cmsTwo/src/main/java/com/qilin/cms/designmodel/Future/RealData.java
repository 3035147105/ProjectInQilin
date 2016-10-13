package com.qilin.cms.designmodel.Future;

/**
 * Created by gaohaiqing on 16-9-30.
 */
public class RealData implements Data {
    protected final String result;

    //模拟真实对象漫长的构造方法
    public RealData(String param) {
        StringBuffer sb = new StringBuffer();
        try {
            for(int i=0;i<10;i++){
                sb.append(param);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
