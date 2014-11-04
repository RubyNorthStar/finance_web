package com.xsjrw.websit.controller.project;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsjrw.websit.domain.project.ImagePath;
import com.xsjrw.websit.search.project.ImagePathSearch;
import com.xsjrw.websit.service.project.IImagePathService;

/**
 * Controller of ImagePath
 * @author wang.zx
 * @date 2014-10-30
 */
@Controller
@RequestMapping("/imagePath")
public class ImagePathController {
	
	@Autowired
	private IImagePathService imagePathServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, ImagePathSearch search){
		if (search == null) {
			search = new ImagePathSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", imagePathServiceImpl.findImagePathByPage(search));
		return "imagePath/list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(ImagePath ImagePath) {
		imagePathServiceImpl.saveImagePath(ImagePath);
		return "redirect:/imagePath";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(ImagePath ImagePath) {
		imagePathServiceImpl.update(ImagePath);
		return "redirect:/imagePath";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		imagePathServiceImpl.deleteImagePathById(id);
		return "redirect:/imagePath";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ImagePath getJson(Model model, @PathVariable Integer id){
		return imagePathServiceImpl.findImagePathById(id);
	}
	
	/**
	 * 后台接收Date转换
	 */
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
