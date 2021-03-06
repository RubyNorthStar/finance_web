package com.xsjrw.websit.controller.project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.xsjrw.common.constans.UserConstans;
import com.xsjrw.websit.domain.project.InvestmentIntentionInfo;
import com.xsjrw.websit.domain.user.Users;
import com.xsjrw.websit.search.project.InvestmentIntentionInfoSearch;
import com.xsjrw.websit.service.project.IInvestmentIntentionInfoService;

/**
 * Controller of InvestmentIntentionInfo
 * @author wang.zx
 * @date 2014-11-9
 */
@Controller
@RequestMapping("/center/investment")
public class InvestmentIntentionInfoController {
	
	@Autowired
	private IInvestmentIntentionInfoService investmentIntentionInfoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, InvestmentIntentionInfoSearch search){
		if (search == null) {
			search = new InvestmentIntentionInfoSearch();
			// search.setPageSize(20);
		}
		search.setPageSize(2);
		search.setPageNo(1);
		search.setStatus(1);
		model.addAttribute("list", investmentIntentionInfoService.findInvestmentIntentionInfoByPage(search));
		model.addAttribute("search", search);
		return "project/investment_manage";
	}
	
	@ResponseBody
	@RequestMapping(value="ajaxList")
	public String ajaxList(Model model, InvestmentIntentionInfoSearch search, HttpServletResponse response){
		search.setPageSize(2);
		
		List<InvestmentIntentionInfo> ajaxList = investmentIntentionInfoService.findInvestmentIntentionInfoByPage(search);
		
		String result = "<tr class='tr-title'><td>投资项目名称</td><td>操作</td></tr>";
		if(ajaxList != null && ajaxList.size() > 0){
			try {
				for(InvestmentIntentionInfo pro : ajaxList){
					result += "<tr><td>"+pro.getInvestName()+
							"</td><td><button class='button-style button-style-blue delete' data='"+pro.getId()+"' style='margin:0; padding:5px 7px;'>删除</button>"
							+ " <button class='button-style button-style-blue update' data='"+pro.getId()+"' style='margin:0; padding:5px 7px;'>修改</button></td></tr>";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(InvestmentIntentionInfo InvestmentIntentionInfo) {
		investmentIntentionInfoService.saveInvestmentIntentionInfo(InvestmentIntentionInfo);
		return "redirect:/investmentIntentionInfo";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(InvestmentIntentionInfo InvestmentIntentionInfo) {
		investmentIntentionInfoService.update(InvestmentIntentionInfo);
		return "redirect:/investmentIntentionInfo";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		String del = "";
		InvestmentIntentionInfo info = investmentIntentionInfoService.findInvestmentIntentionInfoById(id);
		info.setStatus(6);
		try {
			investmentIntentionInfoService.update(info);
			del = "succ";
		} catch (Exception e) {
			e.printStackTrace();
			del = "fail";
		}
		return del;
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public InvestmentIntentionInfo getJson(Model model, @PathVariable Integer id){
		return investmentIntentionInfoService.findInvestmentIntentionInfoById(id);
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
	
	@RequestMapping(value="addInvestment", method = RequestMethod.GET)
	public String addInvestmentGet(){
		return "project/add_investment_info";
	}
	
	@RequestMapping(value="addInvestment", method = RequestMethod.POST)
	public String addInvestmentPost(HttpServletRequest request, InvestmentIntentionInfo investment){
		//从session中获取User信息
		Users user = (Users) request.getSession().getAttribute(UserConstans.USER_LOGIN);
		investment.setCreateTime(new Date());
		investment.setStatus(1);
		investment.setUserId(user.getId());
		investmentIntentionInfoService.saveInvestmentIntentionInfo(investment);
		return "project/add_investment_info";
	}
}
