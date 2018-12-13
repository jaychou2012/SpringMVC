package com.web.mvc.mapper;

import com.web.mvc.model.Entity;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface EntityMapper {
    int insert(Entity record);

    int insertSelective(Entity record);

    Entity findById(@Param("id") int id) throws SQLException;

    List<Entity> findAll() throws SQLException;

    void delete(int id);

    void update(int id,Entity s);
}