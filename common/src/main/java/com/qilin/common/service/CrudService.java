package com.qilin.common.service;

import java.util.List;

/**
 * Created by gaohaiqing on 16-7-26.
 */
public interface CrudService<T> {
    T findOne(long id);

    int save(T entity);

    int delete(long id);

    int update(T entity);

    List<T> findList(Object example);

    List<T> findList(Object example, int offset, int limit);
    List<T> findAll();
}
