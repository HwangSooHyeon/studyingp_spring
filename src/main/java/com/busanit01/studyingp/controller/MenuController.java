package com.busanit01.studyingp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.busanit01.studyingp.dto.ClassDTO;
import com.busanit01.studyingp.service.ClassService;
import com.busanit01.studyingp.util.Utility;

@Controller
public class MenuController {
	@Autowired
	private ClassService classService;

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
	
	@RequestMapping(value = "/searchClsUser", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView searchClsUser(@RequestParam("clsCategory") String clsCategory,
			@RequestParam(value = "searchCon", required = false, defaultValue = "") String searchCon,
			@RequestParam(value = "searchWord", required = false, defaultValue = "") String searchWord) {
		List<ClassDTO> clsList = new ArrayList<ClassDTO>();
		
		if(searchCon.equals("")) {
			clsList = classService.searchClsCategory(clsCategory);
			
			Map<String, List<ClassDTO>> params1 = new HashMap<String, List<ClassDTO>>();
			params1.put("clsList", clsList);
			
			Map<String, String> params2 = new HashMap<String, String>();
			params2.put("clsCategory", clsCategory);
			
			return Utility.direction("searchclscategory", params1, params2);
		}else {
			clsList = classService.searchClsWithCategory(searchCon, searchWord, clsCategory);
			
			Map<String, List<ClassDTO>> params1 = new HashMap<String, List<ClassDTO>>();
			params1.put("clsList", clsList);
			
			Map<String, String> params2 = new HashMap<String, String>();
			params2.put("clsCategory", clsCategory);
			
			return Utility.direction("searchclscategory", params1, params2);
		}		
	}
}
