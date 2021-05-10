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
		
		MemberDTO user = new MemberDTO();
		MemberDTO currentUser = new MemberDTO();
		
		user.setMem_id(username);
		user.setMem_pw(password);
		user = memberService.signIn(user);
		
		if(user == null) {
			String msg = "존재하지 않는 계정입니다.";
			Map<String, String> params = new HashMap<String, String>();
			params.put("msg", msg);
			
			return Utility.direction("login", params);
		}else {
			currentUser.setMem_id(user.getMem_id());
			currentUser.setMem_access(user.getMem_access());
			
			List<ClassDTO> classes = new ArrayList<ClassDTO>();
			classes = classService.mainClsList();
			
			Map<String, List<ClassDTO>> params = new HashMap<String, List<ClassDTO>>();
			params.put("MainClsList", classes);

			session.setAttribute("userInfo", currentUser);
			return Utility.direction("main", params);
		}
	}
}
