package com.busanit01.studyingp.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.busanit01.studyingp.dto.ClassDTO;
import com.busanit01.studyingp.dto.MemberDTO;
import com.busanit01.studyingp.dto.OrderDTO;
import com.busanit01.studyingp.service.ClassService;
import com.busanit01.studyingp.service.MemberService;
import com.busanit01.studyingp.service.OrderService;
import com.busanit01.studyingp.util.Utility;

@Controller
public class AdminController {
	private static final String FILE_PATH = "C:\\Users\\mikae\\Desktop\\studyingp_spring\\studyingp_spring\\src\\main\\webapp\\resources\\img";	
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/editClsAdm", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView editClsAdm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		MemberDTO currentUser = (MemberDTO) session.getAttribute("currentUser");
		
		if(currentUser.getMem_access() != 0) {
			String msg = "관리자 계정 외에는 접근할 수 없습니다. 확인을 누르면 메인으로 이동합니다.";
			Map<String, String> params = new HashMap<String, String>();
			params.put("msg", msg);
			return Utility.direction("editclsadm", params);
		}else {
			return Utility.direction("editclsadm", null);
		}		
	}
	
	@RequestMapping(value = "/searchClsAdm", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView searchClsAdm(@RequestParam("searchCon") String searchCon,
			@RequestParam("searchWord") String searchWord) {
		
		List<ClassDTO> clsList = classService.searchCls(searchCon, searchWord);
		
		if(clsList == null) {
			String msg = "검색 조건 설정에 오류가 있습니다. 다시 진행해주세요.";
			Map<String, String> params = new HashMap<String, String>();
			params.put("msg", msg);
			return Utility.direction("editclsadm", params);
		}else {
			Map<String, List<ClassDTO>> params = new HashMap<String, List<ClassDTO>>();
			params.put("clsList", clsList);
			return Utility.direction("editclsadm", params);
		}		
	}
	
	@RequestMapping(value = "/editClsOne", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView goEditClsOne(@RequestParam("clsCode") String clsCode,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberDTO currentUser = (MemberDTO) session.getAttribute("currentUser");
		
		if(currentUser.getMem_access() == 2) {
			String msg = "접근 권한이 없습니다. 메인화면으로 이동합니다.";
			Map<String, String> params = new HashMap<String, String>();
			params.put("msg", msg);
			return Utility.direction("redirect:/main", params);
		}
		
		ClassDTO clsDTO = classService.getClsOne(clsCode);
				
		Map<String, ClassDTO> params1 = new HashMap<String, ClassDTO>();
		params1.put("selCls", clsDTO);
		
		Map<String, MemberDTO> params2 = new HashMap<String, MemberDTO>();
		params2.put("currentUser", currentUser);		
		
		
		return Utility.direction("editclsone", params1, params2);
	}
	
	@RequestMapping(value = "/doEditCls", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView doClsUp(ClassDTO clsDTO,
			@RequestParam("cls_img_file")MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {				
				
		if(!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			clsDTO.setCls_img(fileName);
			file.transferTo(new File(FILE_PATH, fileName));
		}
		
		int editResult = classService.updateCls(clsDTO);
		Map<String, String> params = new HashMap<String, String>();
		
		if(editResult == 1) {
			String msg = "강의 수정에 성공하였습니다. 확인을 누르면 강의 수정페이지로 돌아갑니다.";
			params.put("msg", msg);
			
			return Utility.direction("editclscmpl", params);
		}else {
			String msg = "강의 수정에 실패하였습니다. 확인을 누르면 강의 수정페이지로 돌아갑니다.";
			params.put("msg", msg);
			
			return Utility.direction("editclscmpl", params);
		}
	}
	
	@RequestMapping(value = "/goEditCls", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView goEditCls(HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberDTO currentUser = (MemberDTO) session.getAttribute("currentUser");
		
		if(currentUser.getMem_access() == 0) {
			return Utility.direction("redirect:/editClsAdm", null);
		}
		else {
			return Utility.direction("redirect:/editClsInst", null);
		}
	}
	
	@RequestMapping(value = "/editMem", method = RequestMethod.GET)
	public ModelAndView editMem(HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberDTO currentUser = (MemberDTO) session.getAttribute("currentUser");
		
		if(currentUser.getMem_access() != 0) {
			String msg = "관리자 계정 외에는 접근할 수 없습니다. 확인을 누르면 메인으로 이동합니다.";
			Map<String, String> params = new HashMap<String, String>();
			params.put("msg", msg);
			return Utility.direction("redirect:/main", params);
		}else {
			return Utility.direction("editmem", null);
		}		
	}
	
	@RequestMapping(value = "/searchMem", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView searchMem(@RequestParam("searchCon") String searchCon,
			@RequestParam("searchWord") String searchWord) {
		List<MemberDTO> memList = memberService.searchMem(searchCon, searchWord);
		
		if(memList == null) {
			String msg = "검색 조건 설정에 오류가 있습니다. 다시 진행해주세요.";
			Map<String, String> params = new HashMap<String, String>();
			params.put("msg", msg);
			return Utility.direction("editmem", params);
		}else {
			Map<String, List<MemberDTO>> params = new HashMap<String, List<MemberDTO>>();
			params.put("memList", memList);
			return Utility.direction("editmem", params);
		}
	}
	
	@RequestMapping(value = "/editMemOne", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView goEditMemOne(@RequestParam("memCode") String memCode,
			HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		MemberDTO currentUser = (MemberDTO) session.getAttribute("currentUser");
		
		if(currentUser.getMem_access() != 0) {
			String msg = "접근 권한이 없습니다. 메인화면으로 이동합니다.";
			Map<String, String> params = new HashMap<String, String>();
			params.put("msg", msg);
			return Utility.direction("redirect:/main", params);
		}
				
		MemberDTO memDTO = new MemberDTO();
		memDTO.setMem_code(Integer.valueOf(memCode));
		memDTO = memberService.getMemByCodeAll(memDTO);
		
		Map<String, MemberDTO> params = new HashMap<String, MemberDTO>();
		params.put("selMem", memDTO);				
		
		return Utility.direction("editmemone", params);
	}
	
	@RequestMapping(value = "/doEditMem", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView doEditMem(MemberDTO memDTO) throws Exception {
		int result = memberService.updateUserAccess(memDTO);
		
		Map<String, String> params = new HashMap<String, String>();
		
		if(result == 1) {
			String msg = "회원 권한 및 탈퇴여부 수정에 성공하였습니다. 확인을 누르면 회원 조회 페이지로 돌아갑니다.";
			params.put("msg", msg);
			
			return Utility.direction("editmemcmpl", params);
		}else {
			String msg = "회원 권한 및 탈퇴여부 수정에 실패하였습니다. 확인을 누르면 회원 조회 페이지로 돌아갑니다.";
			params.put("msg", msg);
			
			return Utility.direction("editmemcmpl", params);
		}
	}
	
	@RequestMapping(value = "/goEditMem", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView goEditMem() {
		return Utility.direction("redirect:/editMem", null);
	}
	
	@RequestMapping(value = "/editOrd", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView editOrd(HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberDTO currentUser = (MemberDTO) session.getAttribute("currentUser");
		
		if(currentUser.getMem_access() != 0) {
			String msg = "관리자 계정 외에는 접근할 수 없습니다. 확인을 누르면 메인으로 이동합니다.";
			Map<String, String> params = new HashMap<String, String>();
			params.put("msg", msg);
			return Utility.direction("redirect:/main", params);
		}else {
			return Utility.direction("editord", null);
		}		
	}
	
	@RequestMapping(value = "/searchOrd", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView searchOrd(@RequestParam("searchCon") String searchCon,
			@RequestParam("searchWord") String searchWord) {
		List<OrderDTO> ordList = orderService.searchOrdAdm(searchCon, searchWord);
		
		if(ordList == null) {
			String msg = "검색 조건 설정에 오류가 있습니다. 다시 진행해주세요.";
			Map<String, String> params = new HashMap<String, String>();
			params.put("msg", msg);
			return Utility.direction("editord", params);
		}else {
			Map<String, List<OrderDTO>> params = new HashMap<String, List<OrderDTO>>();
			params.put("ordList", ordList);
			return Utility.direction("editord", params);
		}
	}
	
	@RequestMapping(value = "/editOrdOne", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView goEditOrdOne(@RequestParam("ordCode") String ordCode,
			HttpServletRequest request) throws Exception {
		if(ordCode.equals("") || ordCode.isEmpty()) {
			String msg = "주문정보가 없습니다. 메인화면으로 이동합니다.";
			Map<String, String> params = new HashMap<String, String>();
			params.put("msg", msg);
			return Utility.direction("redirect:/main", params);
		}
		
		// 주문 정보
		OrderDTO ordDTO = new OrderDTO();
		ordDTO.setOrd_code(Integer.valueOf(ordCode));
		ordDTO = orderService.getOrdByCodeAdm(ordDTO);
		
		Map<String, OrderDTO> params1 = new HashMap<String, OrderDTO>();
		params1.put("selOrd", ordDTO);
		
		// 현재 로그인한 계정 정보
		HttpSession session = request.getSession();
		MemberDTO currentUser = (MemberDTO) session.getAttribute("currentUser");
		
		currentUser = memberService.getMemById(currentUser);
		
		Map<String, MemberDTO> params2 = new HashMap<String, MemberDTO>();
		params2.put("currentUser", currentUser);
		
		// 강의 정보
		String[] clsCodeArr = ordDTO.getCls_code_all().split("_");
		List<ClassDTO> clsList = classService.getClsByCookie(clsCodeArr);
		Map<String, List<ClassDTO>> params3 = new HashMap<String, List<ClassDTO>>();
		params3.put("clsList", clsList);
		
		return Utility.direction("editordone", params1, params2, params3);
	}
	
	@RequestMapping(value = "/doEditOrd", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView doEditOrdOne(OrderDTO ordDTO) {
		int result = orderService.updateOrd(ordDTO);
		
		Map<String, String> params = new HashMap<String, String>();
		
		if(result == 1) {
			String msg = "주문 수정에 성공하였습니다. 확인을 누르면 주문 수정 및 조회 페이지로 돌아갑니다.";
			params.put("msg", msg);
			
			return Utility.direction("editordcmpl", params);
		}else {
			String msg = "주문 수정에 실패하였습니다. 확인을 누르면 주문 수정 및 조회 페이지로 돌아갑니다.";
			params.put("msg", msg);
			
			return Utility.direction("editordcmpl", params);
		}
	}
	
	@RequestMapping(value = "/goEditOrd", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView goEditOrd() {
		return Utility.direction("redirect:/editOrd", null);
	}
}
