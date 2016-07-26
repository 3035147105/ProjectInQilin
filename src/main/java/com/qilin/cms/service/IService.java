package com.qilin.cms.service;

import java.util.List;

/**
 * Created by gaohaiqing on 16-7-26.
 */
public interface IService<T extends Object> {
    T get(long id);

    int add(T entity);

    int delete(long id);

    int update(T entity);

    List<T> query(Object example);

    List<T> queryByPage(Object example, int offset, int limit);
}
