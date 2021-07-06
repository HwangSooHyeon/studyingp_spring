package com.busanit01.studyingp.util;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public class Utility {
	
	// 기본 생성자 생성 방지
	private Utility() {
		throw new AssertionError();
	}
	
	public static ModelAndView direction(String url, Map<String, ?> params) {
		
		ModelAndView modelView = new ModelAndView();
		
		modelView.setViewName(url);
		modelView.addObject("params", params);
		
		return modelView;
	}
	
	public static ModelAndView direction(String url, Map<String, ?> params1, Map<String, ?> params2) {
		
		ModelAndView modelView = new ModelAndView();
		
		modelView.setViewName(url);
		modelView.addObject("params1", params1);
		modelView.addObject("params2", params2);
		
		return modelView;
	}
	
	public static ModelAndView direction(String url, 
			Map<String, ?> params1, Map<String, ?> params2, Map<String, ?> params3) {
		ModelAndView modelView = new ModelAndView();
		
		modelView.setViewName(url);
		modelView.addObject("params1", params1);
		modelView.addObject("params2", params2);
		modelView.addObject("params3", params3);
		
		return modelView;
	}
	
	public static int addClsCookie(String clsCode, HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		String clsCodeCookie = "";
		
		for(int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("clsCode")) {
				clsCodeCookie = cookies[i].getValue();
				break;
			}
		}
		
		if(clsCodeCookie.equals("")) {
			Cookie cookie = new Cookie("clsCode", clsCode);
			cookie.setMaxAge(-1);
			response.addCookie(cookie);
			return 1;
		}else{
			String[] clsCodeArr = clsCodeCookie.split("_");
			for(int i = 0; i < clsCodeArr.length; i++) {
				if(clsCodeArr[i].equals(clsCode)) {
					return 0;
				}
			}
			Cookie cookie = new Cookie("clsCode", clsCodeCookie + "_" + clsCode);
			cookie.setMaxAge(-1);
			response.addCookie(cookie);
			return 1;
		}
	}
}
