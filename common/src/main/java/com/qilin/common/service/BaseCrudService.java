package com.qilin.common.service;

import com.qilin.common.repository.BaseCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by gaohaiqing on 16-7-26.
 */
public abstract class BaseCrudService<T> implements CrudService<T> {
    @Autowired
    protected BaseCrudRepository<T> baseCrudRepository;

    public BaseCrudService() {
    }

    public int save(T entity){
        return baseCrudRepository.save(entity);
    }
    public int delete(long id){
        return baseCrudRepository.delete(id);
    }
    public int update(T entity){
        return baseCrudRepository.update(entity);
    }
    public List<T> findList(Object example){
        return this.baseCrudRepository.findList(example);
    }
    public List<T> findList(Object example, int offset, int limit){
        return baseCrudRepository.findList(example, offset, limit);
    }

    @Override
    public List<T> findAll() {
        return baseCrudRepository.findAll();
    }

    public T findOne(long id){
        return baseCrudRepository.findOne(id);
    }
}
