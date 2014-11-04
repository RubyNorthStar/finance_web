package com.xsjrw.websit.service.impl.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsjrw.websit.dao.project.ProjectInfoMapper;
import com.xsjrw.websit.domain.project.ProjectInfo;
import com.xsjrw.websit.search.project.ProjectInfoSearch;
import com.xsjrw.websit.service.project.IProjectInfoService;

/**
 * Service Implementation:ProjectInfo
 * @author wang.zx
 * @date 2014-10-30
 */
@Service
@Transactional
public class ProjectInfoServiceImpl implements IProjectInfoService {
	
	@Autowired
	private ProjectInfoMapper projectInfoMapper;

	@Override
	public void saveProjectInfo(ProjectInfo projectInfo) {
		projectInfoMapper.insert(projectInfo);
	}

	@Override
	public void batchSaveProjectInfo(List<ProjectInfo> projectInfos) {
		if(projectInfos != null && !projectInfos.isEmpty()){
			projectInfoMapper.batchInsert(projectInfos);
		}
	}

	@Override
	public void update(ProjectInfo projectInfo) {
		projectInfoMapper.update(projectInfo);
	}

	@Override
	public void deleteProjectInfoById(Integer id) {
		projectInfoMapper.deleteById(id);
	}

	@Override
	public void deleteProjectInfoByIds(Integer[] ids) {
		projectInfoMapper.deleteByIds(ids);
	}

	@Override
	public ProjectInfo findProjectInfoById(Integer id) {
		return projectInfoMapper.findById(id);
	}

	@Override
	public List<ProjectInfo> findProjectInfoByPage(ProjectInfoSearch search) {
		Integer totalRecords = projectInfoMapper.pageCount(search);
		search.setTotalRecords(totalRecords);
		return projectInfoMapper.page(search);
	}
	
	
	
	
}
