package com.xsjrw.websit.dao.admin;

import com.xsjrw.websit.domain.admin.Master;

public interface MasterMapper {
    int deleteByPrimaryKey(Integer mtId);

    int insert(Master record);

    int insertSelective(Master record);

    Master selectByPrimaryKey(Integer mtId);

    int updateByPrimaryKeySelective(Master record);

    int updateByPrimaryKey(Master record);
}