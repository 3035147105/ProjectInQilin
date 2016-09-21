package com.qilin.cms;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import static java.util.Collections.sort;

import java.io.*;
import java.util.*;
/**
 * Created by gaohaiqing on 16-7-21.
 * 功能：过滤敏感词
 * 有问题
 */
public class SensitiveWordFilter {
    //敏感词库
    private static HashMap sensitiveWordMap = null;
    //默认编码格式
    private static final String ENCODING = "utf-8";
    //敏感词库的路径

//    private static final InputStream in = SensitiveWordFilter.class.getClassLoader().getResourceAsStream("sensitive/keyWords.txt");
    /**
     * 初始化敏感词库
     */
    private static void init() {
        //读取文件
        Set<String> keyWords = readSensitiveWords();

        //创建敏感词库
        sensitiveWordMap = new HashMap(keyWords.size());
        for (String keyWord : keyWords) {
            createKeyWord(keyWord);
        }
        System.out.println("敏感词库："+sensitiveWordMap);
    }
    /**
     * 构建敏感词库
     *
     * @param keyWord
     */
    private static void createKeyWord(String keyWord) {
        if (sensitiveWordMap == null) {
//            log.error("sensitiveWordMap 未初始化!");
            return;
        }
        Map nowMap = sensitiveWordMap;
        for (Character c : keyWord.toCharArray()) {
            Object obj = nowMap.get(c);
            if (obj == null) {
                Map<String, Object> childMap = new HashMap();
                childMap.put("isEnd", "false");
                nowMap.put(c, childMap);
                nowMap = childMap;
            } else {
                nowMap = (Map) obj;
            }
        }
        nowMap.put("isEnd", "true");
    }
    /**
     * 读取敏感词文件
     *
     * @return
     */
    private static Set<String> readSensitiveWords() {
        Set<String> keyWords = new HashSet();

        keyWords.add("毛泽东");
        keyWords.add("我草");
        keyWords.add("煞笔");
        keyWords.add("我日");
        keyWords.add("草");

        return keyWords;
    }
    /**
     * 检查敏感词
     *
     * @return
     */
    private static String checkSensitiveWord(String text) {
        if (sensitiveWordMap == null) {
            init();
        }
        List<String> sensitiveWords = new ArrayList();
        Map nowMap = sensitiveWordMap;
        String str = "";
        for (int i = 0; i < text.length(); i++) {
            Character word = text.charAt(i);
            Object obj = nowMap.get(word);
            if (obj == null) {
                continue;
            }
            int j = i + 1;
            Map childMap = (Map) obj;
            int length = text.length();
            do {
                if ("true".equals(childMap.get("isEnd"))) {
                    String v = text.substring(i, j);
                    if(str != ""){
                        str = str.replace(v, "*");
                    }else {
                        str = text.replace(v, "*");
                    }
//                    sensitiveWords.save(v);
                }
                char c = text.charAt(j);
                obj = childMap.get(c);
                if(obj != null) {
                    childMap = (Map) obj;
                    if(c == text.charAt(length-1)){
                        String v2 = text.substring(i, length);
//                        sensitiveWords.save(v2);
                        if(str != ""){
                            str = str.replace(v2, "*");
                        }else {
                            str = text.replace(v2, "*");
                        }
                    }
                } else {
                    break;
                }
                j++;
            }while (j < length);
        }
        return str;
    }

    public static void main(String[] args){
        String list = checkSensitiveWord("草，毛泽东是个大煞笔，对不对啊？我");
        System.out.println("和谐后："+list);
    }
}
