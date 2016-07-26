package com.qilin.cms.service;

import com.qilin.cms.daoImpl.BaseDao;
import com.qilin.cms.util.ApplicationContextHolder;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by gaohaiqing on 16-7-26.
 */
public class BaseService<D extends BaseDao,T extends Object> {
    D dao;

    public BaseService() {
        Class<D> entityClass = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//            dao = entityClass.newInstance();
        dao = ApplicationContextHolder.getAutoBean(entityClass);
    }



    public int add(T entity){
//        System.out.println("baseService的add");
        return dao.add(entity);
    }
    public int delete(long id){
//        System.out.println("baseService的delete");
        return dao.remove(id);
    }
    public int update(T entity){
//        System.out.println("baseService的update");
        return dao.edit(entity);
    }
    public List<T> query(Object example){
//        System.out.println("baseService的query");

        return this.dao.queryByExample(example);
    }
    public List<T> queryByPage(Object example, int offset, int limit){
        return dao.queryByPage(example, offset, limit);
    }
    public T get(long id){
        return (T) dao.get(id);
    }
}
