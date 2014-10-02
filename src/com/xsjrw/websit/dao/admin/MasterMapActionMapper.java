package com.xsjrw.websit.dao.admin;

import org.springframework.stereotype.Component;

import com.xsjrw.websit.domain.admin.MasterMapAction;

public interface MasterMapActionMapper {
    int deleteByPrimaryKey(Integer mmaId);

    int insert(MasterMapAction record);

    int insertSelective(MasterMapAction record);

    MasterMapAction selectByPrimaryKey(Integer mmaId);

    int updateByPrimaryKeySelective(MasterMapAction record);

    int updateByPrimaryKey(MasterMapAction record);
}