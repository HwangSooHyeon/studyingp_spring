package com.busanit01.studyingp.util;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

public class Utility {
	public static ModelAndView direction(String url, Map<String, ?> params) {
		
		ModelAndView modelView = new ModelAndView();
		
		modelView.setViewName(url);
		modelView.addObject("params", params);
		
		return modelView;
	}
}
