package com.qilin.common.repository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * Created by gaohaiqing on 16-7-25.
 */
public class BaseCrudRepository<T>{
    // Example的全路径名
    private final String examplePath;
    // Mapper的全路径名
    private final String mapperPath;
    private final Class<T> entityClass;

    private final Log log = LogFactory.getLog(this.getClass());

    private static final String MAPPER_PACKAGE_PATH = "com.qilin.cms.dao";
    private static final String EXAMPLE_PACKAGE_PATH = "com.qilin.cms.model";
    private static final String POINT = ".";

    /**
     * 约定大于配置，Dao命名规则，实体名+Dao
     */
    public BaseCrudRepository() {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        mapperPath = new StringBuffer()
                .append(MAPPER_PACKAGE_PATH)
                .append(POINT)
                .append(entityClass.getSimpleName())
                .append("Mapper")
                .toString();
        log.info("==========mapperPath=====:"+ mapperPath);
        examplePath = new StringBuffer()
                .append(EXAMPLE_PACKAGE_PATH)
                .append(POINT)
                .append(entityClass.getSimpleName())
                .append("Example")
                .toString();
        log.info("==========examplePath=====:"+ examplePath);
    }

    @Autowired
    private SqlSessionTemplate sqlSession;

    public List<T> findAll(){
        Object  example;
        try {
            example = Class.forName(examplePath).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("class loader failed | " + examplePath, e);
        }
        return findList(example);

    }

    public T findOne(long id){
        return this.sqlSession.selectOne(getMapperMethodPath("selectByPrimaryKey"), id);
    }


    public int save(T entity){
        return this.sqlSession.insert(getMapperMethodPath("insert"), entity);
    }

    public int update(T entity){
        return this.sqlSession.update(getMapperMethodPath("updateByPrimaryKey"), entity);
    }

    public int delete(long id){
        return this.sqlSession.delete(getMapperMethodPath("deleteByPrimaryKey"), id);
    }

    /**
     * 按条件筛选集合
     * @param example
     * @return
     */
    public List<T> findList(Object example){
        return this.sqlSession.selectList(getMapperMethodPath("selectByExample"), example);
    }

    /**
     * 分页查询
     */
    public List<T> findList(Object example, int offset, int limit){
        RowBounds rowBounds = new RowBounds(offset, limit);
        return this.sqlSession.selectList(getMapperMethodPath("selectByExample"), example, rowBounds);
    }

    private String getMapperMethodPath(String methodName) {
        return new StringBuffer().append(mapperPath).append(POINT).append(methodName).toString();
    }
}
