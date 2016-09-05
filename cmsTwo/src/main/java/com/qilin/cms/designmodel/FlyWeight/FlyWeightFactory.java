package com.qilin.cms.designmodel.FlyWeight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaohaiqing on 16-9-5.
 *
 * 生产享元对象的工厂
 */
public class FlyWeightFactory {

     Map<String,FlyWeight> map = new HashMap<>();

    /**
     * 模拟根据颜色取棋子
     * @param color
     * @return
     */
     public FlyWeight get(String color){
         FlyWeight flyWeight = map.get(color);
         if (flyWeight == null){
             map.put(color, new FlyWeight(color));
             return map.get(color);
         }
         return flyWeight;
     }

}
