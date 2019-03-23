package com.duant.rcpy.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.duant.rcpy.domain.Info;
import com.duant.rcpy.domain.Page;
import com.duant.rcpy.domain.User;
import com.duant.rcpy.service.InfoService;

@Controller
public class ReviewContraller {

	@Autowired
	private InfoService infoService;

	@Autowired
	Page page;
	
	//分页perview
	@RequestMapping(value="review.do")
	@ResponseBody
	public ModelAndView showPage(Integer currentPage,Integer type,Integer infoid,ModelAndView model,HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("user");
		int i = 0;
		if(user == null) {
			model.setViewName("redirect:/index.jsp");
		}else {
			try {
				if(type == 0) {
					if(user.getIsadmin() == 1) {
						i =infoService.updateSubmitByInfoid(infoid);
					}
				}else if(type == 1) {
					if(user.getIsadmin() == 1) {
						i = infoService.updateChangeByInfoid(infoid);
					}		
				}
			} catch (Exception e) {
				new Exception("操作失败！");
			}
			
			if(currentPage == null) {
				currentPage = 1;
			}
			page.setTotalInfos(infoService.selectAllInfo().size());
			page.setCurrentPage(currentPage);	
			List<Info> infoList = infoService.selectInfoByPage( (currentPage - 1) * page.getPageSize(), page.getPageSize());
			
			model.addObject("list",infoList);
			model.addObject("page", page);
			model.setViewName("rcpy_index_review");
		}
		return model;
	}
	
	@RequestMapping(value="rcpy_index_review.do")
	public String rcpIndexReview(User user,Model model) {
			model.addAttribute("rcpy_index_review");
			return "rcpy_index_review";
	}
	
}
