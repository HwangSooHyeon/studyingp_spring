package com.busanit01.studyingp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.busanit01.studyingp.dto.MemberDTO;
import com.busanit01.studyingp.service.MemberService;
import com.busanit01.studyingp.util.Utility;

@Controller
public class LoginController {
	
	@Inject
	BCryptPasswordEncoder pwdEncoder;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public ModelAndView signIn(@RequestParam("j_username") String username, @RequestParam("j_password") String password,
			HttpServletRequest request, HttpServletResponse response ) throws Exception {
		HttpSession session = request.getSession();
		
		MemberDTO user = new MemberDTO();
		MemberDTO currentUser = new MemberDTO();
		
		user.setMem_id(username);
		user = memberService.signIn(user);
		
		if(user != null && pwdEncoder.matches(password, user.getMem_pw())) {
			currentUser.setMem_id(user.getMem_id());
			currentUser.setMem_access(user.getMem_access());

			session.setAttribute("currentUser", currentUser);
			return Utility.direction("redirect:/main", null);
		}else {
			String msg = "ID, PW가 잘못되었거나 존재하지 않는 계정입니다.";
			Map<String, String> params = new HashMap<String, String>();
			params.put("msg", msg);
			
			return Utility.direction("login", params);
		}		
		/*
		 * if(user == null) { String msg = "존재하지 않는 계정입니다."; Map<String, String> params
		 * = new HashMap<String, String>(); params.put("msg", msg);
		 * 
		 * return Utility.direction("login", params); }else {
		 * currentUser.setMem_id(user.getMem_id());
		 * currentUser.setMem_access(user.getMem_access());
		 * 
		 * session.setAttribute("currentUser", currentUser); return
		 * Utility.direction("redirect:/main", null); }
		 */
	}
	
	@RequestMapping(value = "/goSignUp", method = RequestMethod.GET)
	public ModelAndView goSignUp() {
		return Utility.direction("signup", null);
	}
	
}
