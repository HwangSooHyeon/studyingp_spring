package com.busanit01.studyingp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.busanit01.studyingp.dto.ClassDTO;
import com.busanit01.studyingp.service.ClassService;

@Controller
public class HomeController {
	
	@Autowired
	private ClassService classService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("home");
		
		ClassDTO clsDTO = new ClassDTO();
		clsDTO.setCls_code(1);
		
		clsDTO = classService.test(clsDTO);
		
		modelView.addObject("test", clsDTO);
		
		return modelView;
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("main");
		
		return modelView;
	}
}

