package com.qilin.cms.controller.frame;

import com.qilin.cms.service.frame.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by luoziyihao on 7/26/16.
 */
public abstract class BaseEntityController<T> implements EntityController<T> {
    @Autowired
    protected EntityService<T> entityService;

    @ResponseBody
    @RequestMapping(value = "/{id}/get", method = RequestMethod.GET)
    @Override
    public T get(@PathVariable("id") long id) {
        return entityService.get(id);
    }

    @ResponseBody
    @RequestMapping(value = "/find/all", method = RequestMethod.GET)
    @Override
    public List<T> findAll() {
        return entityService.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/insert", method = {RequestMethod.GET, RequestMethod.POST})
    @Override
    public int insert(@ModelAttribute T entity) {
        return entityService.insert(entity);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}/delete", method ={RequestMethod.GET, RequestMethod.POST})
    @Override
    public int delete(@PathVariable("id") long id) {
        return entityService.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}/update", method ={RequestMethod.GET, RequestMethod.POST})
    @Override
    public int update(@PathVariable("id") long id, @ModelAttribute T entity) {
        if (entityService.get(id) == null ) {return -1;}
        return entityService.update(entity);
    }
}
