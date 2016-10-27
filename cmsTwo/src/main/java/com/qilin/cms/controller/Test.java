package com.qilin.cms.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaohaiqing on 16-7-21.
 */
public class Test {

    public static void main(String[] args){
        Test test = new Test();
    }
    void testMap(){
        Map map = new HashMap<>();
        map.put("person","person");

        Map childMap = new HashMap<>();
        childMap.put("child","child");

        map.put("child", childMap);
        System.out.println(map);
    }

    void testJson(){
        JSONObject json = new JSONObject();
        try {
            json.put("json","json");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }

    void testJsonArray(){
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        try {
            jsonObject.put("json1","json1");
            jsonObject.put("json2","json2");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(jsonObject);
        jsonArray.put(jsonObject1);
        System.out.println(jsonArray);
    }

    void testJsonArraySaveMap(){
        Map map = new HashMap<>();
        map.put("map","map");
        JSONObject json = new JSONObject();
        try {
            json.put("json", map);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }
}
