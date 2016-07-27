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
    @RequestMapping(value = "/{id}/find", method = RequestMethod.GET)
    @Override
    public T findOne(@PathVariable("id") long id) {
        return crudService.findOne(id);
    }

    @ResponseBody
    @RequestMapping(value = "/all/", method = RequestMethod.GET)
    @Override
    public List<T> findAll() {
        return crudService.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = {RequestMethod.GET, RequestMethod.POST})
    @Override
    public int save(@ModelAttribute T entity) {
        return crudService.save(entity);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}/delete", method ={RequestMethod.GET, RequestMethod.POST})
    @Override
    public int delete(@PathVariable("id") long id) {
        return crudService.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}/update", method ={RequestMethod.GET, RequestMethod.POST})
    @Override
    public int update(@PathVariable("id") long id, @ModelAttribute T entity) {
        if (crudService.findOne(id) == null ) {return -1;}
        return crudService.update(entity);
    }
}
