package com.qilin.common.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

import static org.json.XMLTokener.entity;

/**
 * Created by luoziyihao on 7/26/16.
 */
public interface CrudController<T> {

    T findOne(long id);

    List<T> findAll();

    int save(@ModelAttribute T entity);

    int delete(long id);

    int update(long id, @ModelAttribute T entity);

}
