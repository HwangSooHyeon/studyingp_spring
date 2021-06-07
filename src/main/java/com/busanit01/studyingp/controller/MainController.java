package com.busanit01.studyingp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.busanit01.studyingp.dto.ClassDTO;
import com.busanit01.studyingp.service.ClassService;
import com.busanit01.studyingp.util.Utility;

@Controller
public class MainController {
	@Autowired
	private ClassService classService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main() {
		
		List<ClassDTO> classes = new ArrayList<ClassDTO>();
		classes = classService.mainClsList();
		
		Map<String, List<ClassDTO>> params = new HashMap<String, List<ClassDTO>>();
		params.put("MainClsList", classes);
		
		return Utility.direction("main", params);
	}
	
	@RequestMapping(value = "/goClsInfo", method = RequestMethod.GET)
	public ModelAndView goClsInfo(@RequestParam("clsCode") int clsCode, RedirectAttributes redirect) {
		
		ClassDTO singleCls = new ClassDTO();
		singleCls.setCls_code(clsCode);
		singleCls = classService.srchClsByCode(singleCls);
				
		Map<String, ClassDTO> params = new HashMap<String, ClassDTO>();
		params.put("ClsInfo", singleCls);		
		
		return Utility.direction("classInfo", params);
	}
}
