package com.qilin.cms.daoImpl;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by gaohaiqing on 16-7-25.
 */
public class BaseDao<T extends Object>{
    // 子类Mapper的全路径名
    private String  classMethod;
    private final String Prefix = "com.qilin.cms.dao.";

    /**
     * 约定大于配置，Dao命名规则，实体名+Dao
     */
    public BaseDao() {
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        String string = entityClass.getName();
        String[] strs = string.split("\\.");
        classMethod = Prefix + strs[strs.length-1]+"Mapper.";
        System.out.println("==========classMethod=====:"+ classMethod);
    }



    @Autowired
    private SqlSessionTemplate sqlSession;

    public T get(long id){
        return this.sqlSession.selectOne(classMethod+"selectByPrimaryKey", id);
    }
    public int add(T entity){
        return this.sqlSession.insert(classMethod+"insert", entity);
    }

    public int edit(T entity){
        return this.sqlSession.update(classMethod+"updateByPrimaryKey", entity);
    }

    public int remove(long id){
        return this.sqlSession.delete(classMethod+"deleteByPrimaryKey", id);
    }

    /**
     * 按条件筛选集合
     * @param example
     * @return
     */
    public List<T> queryByExample(Object example){
        return this.sqlSession.selectList(classMethod+"selectByExample", example);
    }

    /**
     * 分页查询
     */
    public List<T> queryByPage(Object example, int offset, int limit){
        RowBounds rowBounds = new RowBounds(offset, limit);
        return this.sqlSession.selectList(classMethod+"selectByExample", example, rowBounds);
    }
}
