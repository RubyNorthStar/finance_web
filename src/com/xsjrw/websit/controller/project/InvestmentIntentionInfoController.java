package com.xsjrw.websit.controller.project;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

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

import com.xsjrw.websit.domain.project.InvestmentIntentionInfo;
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
		model.addAttribute("list", investmentIntentionInfoService.findInvestmentIntentionInfoByPage(search));
		return "investmentIntentionInfo/list";
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
		investmentIntentionInfoService.deleteInvestmentIntentionInfoById(id);
		return "redirect:/investmentIntentionInfo";
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
		investment.setCreateTime(new Date());
		investment.setStatus(1);
		investmentIntentionInfoService.saveInvestmentIntentionInfo(investment);
		return "project/add_investment_info";
	}
}
