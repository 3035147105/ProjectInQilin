package com.qilin.cms.service;

import com.qilin.cms.daoImpl.BaseDao;
import com.qilin.cms.daoImpl.UserDao;
import com.qilin.cms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/3/8.
 */
@Service
public class UserServiceImpl extends BaseService<UserDao, User>{

//    @Autowired
//    UserDao userDao;
//    @Override
//    public User get(long id) {
//        return userDao.get(id);
//    }
//
//    @Override
//    public int add(User entity) {
//        return userDao.add(entity);
//    }
//
//    @Override
//    public int delete(long id) {
//        return userDao.remove(id);
//    }
//
//    @Override
//    public int update(User entity) {
//        return userDao.edit(entity);
//    }
//
//    @Override
//    public List<User> query(Object example) {
//        return userDao.queryByExample(example);
//    }
//
//    @Override
//    public List<User> queryByPage(Object example, int offset, int limit) {
//        return userDao.queryByPage(example, offset, limit);
//    }
}
