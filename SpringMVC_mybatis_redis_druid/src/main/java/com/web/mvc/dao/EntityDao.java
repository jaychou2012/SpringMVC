package com.web.mvc.dao;

import com.web.mvc.model.Entity;

import java.sql.SQLException;
import java.util.List;

public interface EntityDao {

    //添加方法
    void add(Entity s) throws SQLException;

    //更新方法
    void update(Entity s) throws SQLException;

    //删除方法
    void delete(int id) throws SQLException;

    //查找方法
    Entity findById(int id) throws SQLException;

    //查找所有
    List<Entity> findAll() throws SQLException;
}
