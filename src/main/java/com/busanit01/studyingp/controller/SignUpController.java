package com.busanit01.studyingp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.busanit01.studyingp.dto.MemberDTO;
import com.busanit01.studyingp.service.MemberService;
import com.busanit01.studyingp.util.Utility;

@Controller
public class SignUpController {
	
	@Inject
	BCryptPasswordEncoder pwdEncoder;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public ModelAndView signUp(MemberDTO memDTO) throws Exception {
		String inputPW = memDTO.getMem_pw();
		String pwd = pwdEncoder.encode(inputPW);
		memDTO.setMem_pw(pwd);
		
		int result = memberService.signUp(memDTO);
		String msg = null;
		
		if(result == 1) {
			msg = "회원가입에 성공했습니다. 로그인 가능합니다!";
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("msg", msg);
			
			return Utility.direction("login", params);
		}else {
			msg = "회원가입에 실패했습니다. 다시 시도해주세요!";
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("signUpMsg", msg);
			
			return Utility.direction("login", params);
		}
	}
}
