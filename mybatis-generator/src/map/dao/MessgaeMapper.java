package map.dao;

import map.model.Messgae;

public interface MessgaeMapper {
    int insert(Messgae record);

    int insertSelective(Messgae record);
}