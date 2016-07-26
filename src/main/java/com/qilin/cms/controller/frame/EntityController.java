package com.qilin.cms.controller.frame;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

import static org.json.XMLTokener.entity;

/**
 * Created by luoziyihao on 7/26/16.
 */
public interface EntityController<T> {

    T get(long id);

    List<T> findAll();

    int insert(@ModelAttribute T entity);

    int delete(long id);

    int update(long id, @ModelAttribute T entity);

}
