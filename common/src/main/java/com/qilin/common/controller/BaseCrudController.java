package com.qilin.common.controller;

import com.qilin.common.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by luoziyihao on 7/26/16.
 */
public abstract class BaseCrudController<T> implements CrudController<T> {
    @Autowired
    protected CrudService<T> crudService;

    @ResponseBody
    @RequestMapping(value = "/{id}/find")
    @Override
    public T findOne(@PathVariable("id") long id) {
        return crudService.findOne(id);
    }

    @ResponseBody
    @RequestMapping(value = "/all")
    @Override
    public List<T> findAll() {
        return crudService.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/save")
    @Override
    public int save(@ModelAttribute T entity) {
        return crudService.save(entity);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}/delete")
    @Override
    public int delete(@PathVariable("id") long id) {
        return crudService.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}/update")
    @Override
    public int update(@PathVariable("id") long id, @ModelAttribute T entity) {
        if (crudService.findOne(id) == null ) {return -1;}
        return crudService.update(entity);
    }

    public List<T> page(Object example,  int offset, int limit){
        return crudService.findList(example, offset, limit);
    }
}
