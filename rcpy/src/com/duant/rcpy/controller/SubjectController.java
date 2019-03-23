package com.duant.rcpy.controller;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duant.rcpy.domain.Subject;
import com.duant.rcpy.service.SubjectService;

@Controller
public class SubjectController {
	@Autowired
	private SubjectService subjectService;
	
	//获取学科属性2
	@RequestMapping("rcpy_index_input_insertproperty2.do")
	@ResponseBody
	public Map<String, String> rcpyIndexInputInsertproperty2(Subject subject,Map<Object,Object> map) {
		Map<String, String> resultMap = new HashMap<String,String>();
		String subjectname = subject.getSubjectname();
		subject = subjectService.selectSubjectByName(subjectname);
		if(subject != null) {
			String property2 = subject.getProperty2();
			resultMap.put("success", property2);
		}
		else resultMap.put("error", "error");
		return resultMap;
	}
	
	
	
	
	
	
}











