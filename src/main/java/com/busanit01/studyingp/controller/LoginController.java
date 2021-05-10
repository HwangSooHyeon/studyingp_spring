package com.busanit01.studyingp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.busanit01.studyingp.dto.ClassDTO;
import com.busanit01.studyingp.dto.MemberDTO;
import com.busanit01.studyingp.service.ClassService;
import com.busanit01.studyingp.service.MemberService;
import com.busanit01.studyingp.util.Utility;

@Controller
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ClassService classService;
	
	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public ModelAndView signIn(@RequestParam("j_username") String username, @RequestParam("j_password") String password,
			HttpServletRequest request, HttpServletResponse response 
			) throws Exception {
		HttpSession session = request.getSession();
		
		MemberDTO userInfo = new MemberDTO();
		userInfo.setMem_id(username);
		userInfo.setMem_pw(password);
		userInfo = memberService.signIn(userInfo);
		
		if(userInfo == null) {
			session.setAttribute("status", false);
			session.setAttribute("userInfo", null);
			return Utility.direction("login", null);
		}else {
			List<ClassDTO> classes = new ArrayList<ClassDTO>();
			classes = classService.mainClsList();
			
			Map<String, List<ClassDTO>> params = new HashMap<String, List<ClassDTO>>();
			params.put("MainClsList", classes);
			
			session.setAttribute("status", true);
			session.setAttribute("userInfo", userInfo);
			return Utility.direction("main", params);
		}
	}
}
