package com.github.sejoung.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.github.sejoung.model.Test;

@Repository
public class ADao {

    @Resource(name = "sqlSessionAdb")
    private SqlSessionTemplate sqlSessionAdb;

    public List<Test> selectTest(Map<String, String> data) {
        return this.sqlSessionAdb.selectList("selectTest", data);
    }
    
    
}
