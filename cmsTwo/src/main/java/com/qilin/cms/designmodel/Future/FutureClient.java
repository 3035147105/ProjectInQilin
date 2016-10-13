package com.qilin.cms.designmodel.Future;

/**
 * Created by gaohaiqing on 16-9-30.
 *
 * 未来设计模式 --- 多线程设计模式的一种
 *
 * 这个模式被提出来为了解决什么问题：
 * 客户端请求服务端程序，这个程序比较复杂要等一段时间才能返回；
 * 这种场景下可以先立即给客户端一个未来对象，等真实对象构建好以后，可以通过未来对象得到真实对象
 *
 * 实现时需要的对象：
 * Data:返回数据的接口
 * FutureData: 未来数据对象
 * RealData: 真实数据对象
 * Client: 立即返回未来数据，并开启线程装配真实数据
 */
public class FutureClient {
    //模拟一个http请求
    public Data request(String name){
        final FutureData futureData = new FutureData();

        //开启一个新线程，去构建真实数据对象;
        // 而未来对象可以立即返回，不影响其它客户端对此服务端的请求
        new Thread(){
            @Override
            public void run() {
                RealData realData = new RealData(name);
                futureData.setRealData(realData);
            }
        }.start();

        return futureData;//未来对象会立即返回
    }

    public static void main(String[] args){
        FutureClient client = new FutureClient();
        Data data = client.request("name");
        System.out.println("请求完毕");

        //利用真实数据被构建的时间，可以处理一些其他的业务逻辑
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result = data.getResult();
        System.out.println("服务端返回的结果："+ result);
    }
}
