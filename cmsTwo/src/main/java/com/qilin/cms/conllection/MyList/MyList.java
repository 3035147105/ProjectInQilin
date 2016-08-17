package com.qilin.cms.conllection.MyList;

/**
 * Created by gaohaiqing on 16-8-17.
 */
public interface MyList<E> {

    boolean add(E e);

    boolean remove(Object o);

    E get(int index);

    E set(int index, E element);

    /**
     * 返回元素的下标
     * @param o
     * @return
     */
    int indexOf(Object o);

    int size();
}
