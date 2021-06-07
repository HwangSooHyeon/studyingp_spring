package com.busanit01.studyingp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
public class MyPageController {
	@Inject
	BCryptPasswordEncoder pwdEncoder;
	
	@Autowired
	private MemberService memberService; 
	
	@ResponseBody
	@RequestMapping(value = "/mypage/pwChk", method = {RequestMethod.POST, RequestMethod.GET})
	public boolean pwChk(String mem_pw, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		MemberDTO memDTO = new MemberDTO();
		
		memDTO = (MemberDTO) session.getAttribute("currentUser");		
		memDTO = memberService.signIn(memDTO);
		
		String mem_pw_chk = memDTO.getMem_pw();
		
		return pwdEncoder.matches(mem_pw, mem_pw_chk);
	}
	
	@RequestMapping(value = "/mypage/updateUser", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView updateUser(String mem_pw, HttpServletRequest request) throws Exception {

		if(mem_pw == null) {
			return Utility.direction("mypage", null);
		}else {
			HttpSession session = request.getSession();
			MemberDTO memDTO = (MemberDTO) session.getAttribute("currentUser");
			memDTO = memberService.signIn(memDTO);
			Map<String, MemberDTO> params = new HashMap<String, MemberDTO>();
			
			params.put("userInfo", memDTO);
			
			return Utility.direction("updateuser", params);
		}
	}
	
	@RequestMapping(value = "/updateUserInfo", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView updateUserInfo(MemberDTO memDTO, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		
		MemberDTO currentUser = (MemberDTO) session.getAttribute("currentUser");
		
		memDTO.setMem_id(currentUser.getMem_id());
		memDTO.setMem_pw(pwdEncoder.encode(memDTO.getMem_pw()));
		
		int result = memberService.updateUserInfo(memDTO);
		String msg = null;
		Map<String, String> params = new HashMap<String, String>();
		
		if(result == 1) {
			msg = "회원정보를 수정했습니다.";
			
			params.put("msg", msg);
			
			return Utility.direction("mypage", params);
		}else {
			msg = "회원정보를 수정에 실패했습니다.";
			
			params.put("msg", msg);
			
			return Utility.direction("mypage", params);
		}
	}
	
	@RequestMapping(value = "/mypage/deleteUser", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView deleteUser(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		
		MemberDTO currentUser = (MemberDTO) session.getAttribute("currentUser");
		String msg = null;
		Map<String, String> params = new HashMap<String, String>();
		
		if(currentUser == null) {
			msg = "로그인 후에 접근할 수 있습니다.";
			
			params.put("msg", msg);
			
			return Utility.direction("login", params);
		}else {
			return Utility.direction("deleteuser", params);
		}		
	}
	
	@RequestMapping(value = "/deleteUser", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView deleteUserInfo(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		
		MemberDTO currentUser = (MemberDTO) session.getAttribute("currentUser");
		String msg = null;
		Map<String, String> params = new HashMap<String, String>();
		
		if(currentUser == null) {
			msg = "로그인 후에 접근할 수 있습니다.";
			
			params.put("msg", msg);
			
			return Utility.direction("login", params);
		}else {
			int result = memberService.deleteUser(currentUser);
			if(result == 1) {
				session.invalidate();
				
				msg = "탈퇴에 성공했습니다.";
				
				params.put("msg", msg);
				
				return Utility.direction("login", params);
			}else {
				msg = "탈퇴에 실패했습니다.";
				
				params.put("msg", msg);
				
				return Utility.direction("login", params);
			}
		}
	}
}
