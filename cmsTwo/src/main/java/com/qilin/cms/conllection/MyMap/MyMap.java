package com.qilin.cms.conllection.MyMap;

/**
 * Created by gaohaiqing on 16-8-17.
 */
public interface MyMap<K,V> {
    V put(K key,V value);

    V get(Object key);

    int size();

    V remove(Object key);
}
