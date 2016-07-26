package com.qilin.cms.service.frame;

import com.qilin.cms.dao.frame.BaseEntityDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by gaohaiqing on 16-7-26.
 */
public class BaseEntityService<T> implements EntityService<T> {
    @Autowired
    protected BaseEntityDao<T> dao;

    public BaseEntityService() {
    }

    public int insert(T entity){
        return dao.insert(entity);
    }
    public int delete(long id){
        return dao.delete(id);
    }
    public int update(T entity){
        return dao.update(entity);
    }
    public List<T> query(Object example){
        return this.dao.selectList(example);
    }
    public List<T> queryByPage(Object example, int offset, int limit){
        return dao.selectList(example, offset, limit);
    }
    public T get(long id){
        return dao.get(id);
    }
}
