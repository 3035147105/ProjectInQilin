package com.qilin.cms.conllection.MyList;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 问题：list是一种动态性的集合，它的动态性体现在那里？是如何实现的
 * Created by gaohaiqing on 16-8-17.
 *
 * 自己实现sun的 ArrayList的功能
 *
 * list适合使用场景：长度已知，
 * 原因：每次扩容时，都要把原集合中的元素重新拷贝一份到新集合
 * 长度未知的时候：建议使用LinkedList
 */
public class MyArrayList<E> implements MyList<E>,Serializable {
    transient Object[] elementDate;
    private static final Object[] EMPTY_ELEMENTDATE = {};
    private int size;

    public MyArrayList(){
        elementDate = EMPTY_ELEMENTDATE;
    }

    @Override
    public boolean add(E e) {
        ensureCapacity(size + 1);
        elementDate[size++] = e;
        return true;
    }

    /**
     * list的动态性体现，自动扩容
     * @param minlength
     */
    private void ensureCapacity(int minlength){
        int oldlength = elementDate.length;
        int newlength = oldlength + (oldlength >> 1);//在原来的基础上增加一倍再加上原来的长度
        System.out.println("==newlength==:"+ newlength);
        if (newlength - minlength < 0)
            newlength = minlength;
        elementDate = Arrays.copyOf(elementDate, newlength);
    }

    @Override
    public boolean remove(Object o) {
        if(o == null){
            for(int i=0; i<size; i++){
                if(elementDate[i]==null){
                    fastRemove(i);
                    return true;
                }
            }
        } else {
            for(int i=0; i<size; i++){
                if(o.equals(elementDate[i])){
                    fastRemove(i);
                    return true;
                }
            }
        }
        return false;
    }

    private void fastRemove(int index){
        int numMoved = size - index - 1;
        if(numMoved > 0)
            System.arraycopy(elementDate, index+1, elementDate, index, numMoved);
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return (E) elementDate[index];
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E oldValue = (E) elementDate[index];
        elementDate[index] = element;
        return oldValue;
    }

    /**
     * 检查下标是否越界
     * @param index
     */
    private void rangeCheck(int index){
        if(index >= size)
            throw new RuntimeException("数组下标越界");
    }

    @Override
    public int indexOf(Object o) {
        if(o == null){
            for(int index=0; index<size; index++){
                if(elementDate[index]==null){
                    return index;
                }
            }
        }else {
            for(int index=0; index<size; index++){
                if(o.equals(elementDate[index])){
                    return index;
                }
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }
}
