package com.busanit01.studyingp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.busanit01.studyingp.util.Utility;

@Controller
public class CourseController {
	
	@RequestMapping(value = "/courseInfo", method = RequestMethod.GET)
	public ModelAndView goCourseInfo(HttpServletRequest request) {
		return Utility.direction(null, null);
	}
}
