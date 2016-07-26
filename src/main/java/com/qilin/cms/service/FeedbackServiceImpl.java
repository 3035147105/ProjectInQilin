package com.qilin.cms.service;

import com.qilin.cms.daoImpl.FeedbackDao;
import com.qilin.cms.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gaohaiqing on 16-7-26.
 */
@Service
public class FeedbackServiceImpl implements IService<Feedback>{

    @Autowired
    FeedbackDao feedbackDao;
    @Override
    public Feedback get(long id) {
        return feedbackDao.get(id);
    }

    @Override
    public int add(Feedback entity) {
        return feedbackDao.add(entity);
    }

    @Override
    public int delete(long id) {
        return feedbackDao.remove(id);
    }

    @Override
    public int update(Feedback entity) {
        return feedbackDao.edit(entity);
    }

    @Override
    public List<Feedback> query(Object example) {
        return feedbackDao.queryByExample(example);
    }

    @Override
    public List<Feedback> queryByPage(Object example, int offset, int limit) {
        return feedbackDao.queryByPage(example, offset, limit);
    }
}
