package com.web.mvc.service;

import com.web.mvc.mapper.EntityMapper;
import com.web.mvc.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EntityService implements IEntityService {

    @Autowired
    private EntityMapper entityMapper;

    @Override
    public void add(Entity s) throws SQLException {
        entityMapper.insert(s);
    }

    @Override
    public void update(int id,Entity s) throws SQLException {
        entityMapper.update(id,s);
    }

    @Override
    public void delete(int id) throws SQLException {
        entityMapper.delete(id);
    }

    @Override
    public Entity findById(int id) throws SQLException {
        return entityMapper.findById(id);
    }

    @Override
    public List<Entity> findAll() throws SQLException {
        return entityMapper.findAll();
    }
}
