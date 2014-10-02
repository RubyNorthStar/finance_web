package com.xsjrw.websit.dao.admin;

import org.springframework.stereotype.Component;

import com.xsjrw.websit.domain.admin.ActionColumn;

public interface ActionColumnMapper {
    int deleteByPrimaryKey(Integer acId);

    int insert(ActionColumn record);

    int insertSelective(ActionColumn record);

    ActionColumn selectByPrimaryKey(Integer acId);

    int updateByPrimaryKeySelective(ActionColumn record);

    int updateByPrimaryKey(ActionColumn record);
}