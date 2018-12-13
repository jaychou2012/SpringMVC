package com.web.mvc.service;

import com.web.mvc.model.Entity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

public interface IEntityService {
    //添加方法
    void add(Entity s) throws SQLException;

    //更新方法
    void update(int id, Entity s) throws SQLException;

    //删除方法
    void delete(int id) throws SQLException;

    //查找方法
    Entity findById(int id) throws SQLException;

    //查找所有
    List<Entity> findAll() throws SQLException;
}
