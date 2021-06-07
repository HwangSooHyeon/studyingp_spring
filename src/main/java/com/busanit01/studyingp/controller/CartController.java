package com.busanit01.studyingp.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.busanit01.studyingp.dto.ClassDTO;
import com.busanit01.studyingp.dto.MemberDTO;
import com.busanit01.studyingp.dto.OrderDTO;
import com.busanit01.studyingp.service.ClassService;
import com.busanit01.studyingp.service.MemberService;
import com.busanit01.studyingp.service.OrderService;
import com.busanit01.studyingp.util.Utility;

@Controller
public class CartController {
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private OrderService orderService;
	
	@ResponseBody
	@RequestMapping(value = "/addCart", produces = "application/text; charset=UTF-8", method = RequestMethod.GET)
	public String addCart(String clsCode, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		
		String msg = "";
		int result = Utility.addClsCookie(clsCode, request, response);
		
		if(result == 1) {
			msg = "장바구니에 추가되었습니다. 확인을 누르면 장바구니로 갑니다.";
			return msg;
		}else {
			msg = "이미 장바구니에 있는 강의 입니다. 확인을 누르면 장바구니로 갑니다.";
			return msg;
		}		
	}
		
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView goCart(@CookieValue(value = "clsCode", required = false) String clsCode ) {
		if(clsCode.equals("")) {
			String msg = "장바구니에 상품이 없습니다.";
			Map<String, String> params = new HashMap<String, String>();
			params.put("msg", msg);
			
			return Utility.direction("cart", params);
		}
		
		String[] clsCodeArr = clsCode.split("_");
		
		Map<String, List<ClassDTO>> params = new HashMap<String, List<ClassDTO>>();
		params.put("cartClsList", classService.getClsByCookie(clsCodeArr));
		
		return Utility.direction("cart", params);
	}	
	
	@RequestMapping(value = "/delCls", method = RequestMethod.GET)
	public ModelAndView deleteClsCart(String selClsCode, @CookieValue(value = "clsCode", required = false) String clsCode,
			HttpServletResponse response) {
		
		String reClsCode = classService.delClsCart(selClsCode, clsCode);
		
		Map<String, String> params = new HashMap<String, String>();
		
		if(reClsCode.equals(clsCode)) {
			String msg = "해당 강의 삭제에 실패했습니다. 확인 버튼을 누르면 장바구니로 돌아갑니다.";
			params.put("msg", msg);
			return Utility.direction("deleteCls", params);
		}else {
			Cookie cookie = new Cookie("clsCode", reClsCode);
			cookie.setMaxAge(-1);
			response.addCookie(cookie);
			
			String msg = "강의를 삭제했습니다. 확인 버튼을 누르면 장바구니로 돌아갑니다.";
			params.put("msg", msg);			
			return Utility.direction("deleteCls", params);
		}		
	}
	
	@RequestMapping(value = "/orderSheet", method = RequestMethod.GET)
	public ModelAndView goOrderSheet(String selClsCode, 
			@CookieValue(value = "clsCode", required = false) String clsCode, 
			HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		
		MemberDTO orderer = (MemberDTO) session.getAttribute("currentUser");
		
		// 이게 문제 인데;
		orderer = memberService.getMemById(orderer);		
		
		List<ClassDTO> clsList = new ArrayList<ClassDTO>();
		
		// 전체 상품 구매
		if(selClsCode == null) {
			String[] clsCodeArr = clsCode.split("_");
			clsList = classService.getClsByCookie(clsCodeArr);
		// 단일 상품 구매
		}else {
			clsList = classService.getClsByQuery(selClsCode);
		}		
		
		Map<String, List<ClassDTO>> params1 = new HashMap<String, List<ClassDTO>>();
		params1.put("clsList", clsList);
		
		Map<String, MemberDTO> params2 = new HashMap<String, MemberDTO>();
		params2.put("orderer", orderer);
		
		return Utility.direction("ordersheet", params1, params2);		
	}
	
	@RequestMapping(value = "/ordComplete", method = RequestMethod.GET)
	public ModelAndView goOrderComplete(String clsCodeList, String totPrice,
			@CookieValue(value = "clsCode", required = false) String clsCode,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		MemberDTO currentUser = (MemberDTO) session.getAttribute("currentUser");
		currentUser = memberService.getMemById(currentUser);
		
		int result = orderService.addOrder(clsCodeList, totPrice, currentUser);
		
		if(result == 0) {
			String msg = "주문에 실패했습니다. 장바구니로 돌아갑니다.";
			Map<String, String> params = new HashMap<String, String>();
			params.put("msg", msg);
			return Utility.direction("/cart", params);	
		}else {
			
			Map<String, String> params1 = new HashMap<String, String>();
			params1.put("totPrice", totPrice);
			
			//추가할 것: 결제 방식 혹은 구매자 정보
			
			//쿠키 삭제 혹은 재조립
			int delResult = orderService.delCartInfo(clsCodeList, clsCode, request, response);
			
			System.out.println(delResult);
			
			return Utility.direction("ordercomplete", params1, null);
		}
	}
	
	@RequestMapping(value = "/bill", method = RequestMethod.GET)
	public ModelAndView goBill(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MemberDTO currentUser = (MemberDTO) session.getAttribute("currentUser");
		currentUser = memberService.getMemById(currentUser);
		
		// 1. orderdto를 가져옴
		List<OrderDTO> ordList = orderService.searchOrd(currentUser);
		
		// 2. cls_code_all을 추출 및 쪼갬
		String[][] clsCodeAllList = new String[ordList.size()][];
		for(int i = 0; i < ordList.size(); i++) {
			clsCodeAllList[i] = ordList.get(i).getCls_code_all().split("_");
		}
		
		// 3. 첫 번째 값만 select로 가져옴
		List<ClassDTO> fClsList = new ArrayList<ClassDTO>();
		for(int i = 0; i < ordList.size(); i++) {
			fClsList.add(i, classService.getClsOne(clsCodeAllList[i][0]));
		}
		
		// 4. params로 주문 정보, 첫 번째 상품 정보, 상품 갯수를 보냄
		Map<String, List<OrderDTO>> params1 = new HashMap<String, List<OrderDTO>>();
		params1.put("ordList", ordList);
		
		Map<String, List<ClassDTO>> params2 = new HashMap<String, List<ClassDTO>>();
		params2.put("fClsList", fClsList);
		
		return Utility.direction("bill", params1, params2);
	}
}
