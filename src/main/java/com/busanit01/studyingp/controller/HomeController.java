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
import org.springframework.web.servlet.ModelAndView;

import com.busanit01.studyingp.dto.ClassDTO;
import com.busanit01.studyingp.service.ClassService;
import com.busanit01.studyingp.util.Utility;

@Controller
public class HomeController {
	
	@Autowired
	private ClassService classService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		
		List<ClassDTO> classes = new ArrayList<ClassDTO>();
		classes.add(classService.test());
		
		Map<String, List<ClassDTO>> params = new HashMap<String, List<ClassDTO>>();
		params.put("HomeClsList", classes);
		
		return Utility.direction("home", params);
	}
}

