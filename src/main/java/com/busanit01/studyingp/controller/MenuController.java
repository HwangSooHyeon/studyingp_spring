package com.busanit01.studyingp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.busanit01.studyingp.util.Utility;

@Controller
public class MenuController {

	@RequestMapping(value = "/goLogin", method = RequestMethod.GET)
	public ModelAndView goLogin() {
		return Utility.direction("login", null);
	}
	
	@RequestMapping(value = "/signOut", method = RequestMethod.GET)
	public ModelAndView signOut(HttpSession session) {
		
		session.invalidate();
		
		return Utility.direction("redirect:/main", null);
	}
	
	@RequestMapping(value = "/mypage", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView mypage() {
		return Utility.direction("mypage", null);
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public ModelAndView goUpload() {
		return Utility.direction("upload", null);
	}
}
