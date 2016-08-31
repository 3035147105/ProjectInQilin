package com.qilin.cms.designmodel.Prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaohaiqing on 16-8-30.
 *
 * 原型管理器 角色
 */
public class PrototypeManager {
    private static Map<String,Prototype> prototypeMap = new HashMap<>();

    private PrototypeManager(){
    }

    public synchronized static void setPrototype(String prototypeId, Prototype prototype){
        prototypeMap.put(prototypeId, prototype);
    }

    public synchronized static void removePrototype(String prototypeId){
        prototypeMap.remove(prototypeId);
    }

    public synchronized static Prototype getPrototype(String prototypeId){
        Prototype prototype = prototypeMap.get(prototypeId);
        if(prototype == null){
            throw new RuntimeException("未找到匹配的原型");
        }
        return prototype;
    }
}
