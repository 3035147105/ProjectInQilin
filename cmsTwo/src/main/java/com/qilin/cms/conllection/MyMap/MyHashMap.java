package com.qilin.cms.conllection.MyMap;

import java.io.Serializable;

/**
 * Created by gaohaiqing on 16-8-17.
 * 键不能重复，值能重复
 */
public class MyHashMap<K,V> implements MyMap<K,V>,Serializable {
    transient Node<K,V>[] table;

    transient int size;

    int threshold;

    static final int DEFAULT_IITIAL_CAPACITY = 16;//node数组的初始化大小

    static final int MAXI_CAPACITY = 1 << 30;//node数组的最大大小

    @Override
    public V put(K key, V value) {
        Node<K,V> node = new Node<>(key, value, null);

        return null;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    private Node<K,V>[] resize(){
        Node<K,V>[] oldTab = table;
        int oldCap = (oldTab==null) ? 0: oldTab.length;
        int oldThr = threshold;
        int newCap = 0;
        int newThr = 0;
        /** 达到一定条件时进行扩容，数组的长度超过16时，新的数组长度翻一倍，新的最大容量也翻一倍 **/
        if((newCap = oldCap << 1) < MAXI_CAPACITY && oldCap >= DEFAULT_IITIAL_CAPACITY){
            newThr = oldThr << 1;
        }
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        return newTab;
    }

    static class Node<K,V>{
        final K key;
        V value;
        Node<K,V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Node<K, V> getNext() {
            return next;
        }
    }

}
