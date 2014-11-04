package com.xsjrw.websit.service.impl.project;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.xsjrw.common.constans.Constans;
import com.xsjrw.websit.core.util.ParamUtil;
import com.xsjrw.websit.dao.project.ImagePathMapper;
import com.xsjrw.websit.domain.project.ImagePath;
import com.xsjrw.websit.search.project.ImagePathSearch;
import com.xsjrw.websit.service.project.IImagePathService;

/**
 * Service Implementation:ImagePath
 * @author wang.zx
 * @date 2014-10-30
 */
@Service
@Transactional
public class ImagePathServiceImpl implements IImagePathService {
	
	@Autowired
	private ImagePathMapper imagePathMapper;

	@Override
	public void saveImagePath(ImagePath T) {
		imagePathMapper.insert(T);
	}

	@Override
	public void batchSaveImagePath(List<ImagePath> T) {
		imagePathMapper.batchInsert(T);
	}

	@Override
	public void update(ImagePath T) {
		imagePathMapper.update(T);
	}

	@Override
	public void deleteImagePathById(Integer id) {
		imagePathMapper.deleteById(id);
	}

	@Override
	public void deleteImagePathByIds(Integer[] ids) {
		imagePathMapper.deleteByIds(ids);
	}

	@Override
	public ImagePath findImagePathById(Integer id) {
		return imagePathMapper.findById(id);
	}

	@Override
	public List<ImagePath> findImagePathByPage(ImagePathSearch search) {
		Integer totalRecords = imagePathMapper.pageCount(search);
		search.setTotalRecords(totalRecords);
		return imagePathMapper.page(search);
	}

	@Override
	public void saveImagePathByProjectId(int projectId, List<ImagePath> images) {
		// TODO Auto-generated method stub
		saveByProjectId(projectId, images);
		
	}
	
	public void saveByProjectId(Integer projectId, List<ImagePath> images) {
		// 图片保存路径
		String uploadPath = getUploadPath(projectId);
		
		for(ImagePath image : images){
			// 上传语音解析文件
			if(image.getImagePath() != null){
				image.setPath(uploadVoiceFiles(image.getImagePath(),uploadPath));
			}
		}
		
		
		// 增加新的图片
		for(ImagePath image : images){
			if(StringUtils.isBlank(image.getPath())) continue;
			image.setProjectId(projectId);
			image.setCreateTime(new Date());
			image.setStatus(1);
			imagePathMapper.insert(image);
		}
		
	}
	
	private String getUploadPath(Integer projectId){
		StringBuffer path = new StringBuffer();
		Calendar cal = Calendar.getInstance();
		path.append("project/");
		path.append(cal.get(Calendar.YEAR));
		path.append(cal.get(Calendar.MONTH) + 1).append(cal.get(Calendar.DAY_OF_MONTH)).append("/");
		path.append(projectId).append("/");
		return path.toString();
	}
	
	private String uploadVoiceFiles(MultipartFile voiceFile,String uploadPath){
		if(voiceFile.isEmpty()){
			return "";
		}
		String fileName = getFileName(voiceFile.getOriginalFilename());
		File parentFile = new File(Constans.product_real_path + "/" + uploadPath);
		if(!parentFile.exists()){
			parentFile.mkdirs();
		}
		try {
			FileCopyUtils.copy(voiceFile.getBytes(), new File(parentFile,fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return uploadPath + fileName;
	}
	
	private String getFileName(String name){
		StringBuffer fileName = new StringBuffer(String.valueOf(System.currentTimeMillis()));
		fileName.append(new Random().nextInt(1000));
		if(name.indexOf(".") > -1){
			fileName.append(name.substring(name.lastIndexOf(".")));
		}
		return fileName.toString();
	}
	
	
}
