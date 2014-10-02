package com.xsjrw.websit.dao.admin;

import org.springframework.stereotype.Component;

import com.xsjrw.websit.domain.admin.ColumnGroup;

public interface ColumnGroupMapper {
    int deleteByPrimaryKey(Integer cgId);

    int insert(ColumnGroup record);

    int insertSelective(ColumnGroup record);

    ColumnGroup selectByPrimaryKey(Integer cgId);

    int updateByPrimaryKeySelective(ColumnGroup record);

    int updateByPrimaryKey(ColumnGroup record);
}