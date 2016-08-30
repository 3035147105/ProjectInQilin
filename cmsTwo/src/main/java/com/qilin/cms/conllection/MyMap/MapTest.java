package com.qilin.cms.conllection.MyMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaohaiqing on 16-8-17.
 */
public class MapTest {
    private static final Log log = LogFactory.getLog(MapTest.class);

    public static void main(String[] args){
        Map map = new HashMap<>();
        map.put("","");
        map.get("");
        map.size();
        map.remove("");
    }
}
