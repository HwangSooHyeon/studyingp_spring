package com.busanit01.studyingp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
		
		int idChk = memberService.idChk(memDTO);
		String msg = null;
		Map<String, String> params = new HashMap<String, String>();
		
		if(idChk == 1) {
			msg = "중복된 아이디입니다.";
			
			params.put("msg", msg);
			
			return Utility.direction("signup", params);
		}else if(idChk == 0) {
			String inputPW = memDTO.getMem_pw();
			String pwd = pwdEncoder.encode(inputPW);
			memDTO.setMem_pw(pwd);
			
			int result = memberService.signUp(memDTO);
			
			
			if(result == 1) {
				msg = "회원가입에 성공했습니다. 로그인 가능합니다!";
				
				params.put("msg", msg);
				
				return Utility.direction("login", params);
			}else {
				msg = "회원가입에 실패했습니다. 다시 시도해주세요!";
				
				params.put("signUpMsg", msg);
				
				return Utility.direction("login", params);
			}
		}else {
			msg = "예기치 못한 에러가 발생했습니다. 로그인 화면으로 돌아갑니다.";
			
			params.put("msg", msg);
			
			return Utility.direction("login", params);
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/idChk", method = RequestMethod.POST)
	public int idChk(MemberDTO memDTO) throws Exception {
		return memberService.idChk(memDTO);
	}
}
