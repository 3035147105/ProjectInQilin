package com.qilin.cms.dao.frame;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by gaohaiqing on 16-7-25.
 */
public class BaseEntityDao<T>{
    // 子类Mapper的全路径名
    private final String  classMethod;
    private final static String Prefix = "com.qilin.cms.dao.mapper.";

    /**
     * 约定大于配置，Dao命名规则，实体名+Dao
     */
    public BaseEntityDao() {
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        String[] strs = entityClass.getName().split("\\.");
        classMethod = Prefix + strs[strs.length-1]+"Mapper.";
        System.out.println("==========classMethod=====:"+ classMethod);
    }



    @Autowired
    private SqlSessionTemplate sqlSession;

    public T get(long id){
        return this.sqlSession.selectOne(classMethod+"selectByPrimaryKey", id);
    }
    public int insert(T entity){
        return this.sqlSession.insert(classMethod+"insert", entity);
    }

    public int update(T entity){
        return this.sqlSession.update(classMethod+"updateByPrimaryKey", entity);
    }

    public int delete(long id){
        return this.sqlSession.delete(classMethod+"deleteByPrimaryKey", id);
    }

    /**
     * 按条件筛选集合
     * @param example
     * @return
     */
    public List<T> selectList(Object example){
        return this.sqlSession.selectList(classMethod+"selectByExample", example);
    }

    /**
     * 分页查询
     */
    public List<T> selectList(Object example, int offset, int limit){
        RowBounds rowBounds = new RowBounds(offset, limit);
        return this.sqlSession.selectList(classMethod+"selectByExample", example, rowBounds);
    }
}
