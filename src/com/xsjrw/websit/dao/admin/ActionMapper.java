package com.xsjrw.websit.dao.admin;

import com.xsjrw.websit.domain.admin.Action;

public interface ActionMapper {
    int deleteByPrimaryKey(Integer atId);

    int insert(Action record);

    int insertSelective(Action record);

    Action selectByPrimaryKey(Integer atId);

    int updateByPrimaryKeySelective(Action record);

    int updateByPrimaryKey(Action record);
}