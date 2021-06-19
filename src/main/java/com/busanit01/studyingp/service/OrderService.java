package com.busanit01.studyingp.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busanit01.studyingp.dao.OrderDAO;
import com.busanit01.studyingp.dto.MemberDTO;
import com.busanit01.studyingp.dto.OrderDTO;

@Service
public class OrderService {

	@Autowired
	private ClassService classService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private OrderDAO ordDAO;
	
	public int addOrder(String clsCodeList, String totPrice, MemberDTO currentUser) {
		OrderDTO order = new OrderDTO();
		
		order.setCls_code_all(clsCodeList);
		order.setMem_code(currentUser.getMem_code());
		order.setOrd_total(Integer.valueOf(totPrice));
		
		return ordDAO.insertOrd(order);
	}
	
	public int delCartInfo(String clsCodeList, String clsCode,
			HttpServletRequest request, HttpServletResponse response) {
		String[] clsCodeListArr = clsCodeList.split("_");
		String[] clsCodeCookieArr = clsCode.split("_");
		String reClsCode = "";
		int delIndex = 0;
		
		if(clsCodeListArr.length > 1) {
			Cookie cookie = new Cookie("clsCode", "");
			cookie.setMaxAge(-1);
			response.addCookie(cookie);
		}else {
			for(int i = 0; i < clsCodeCookieArr.length; i++) {
				if(clsCodeCookieArr[i].equals(clsCodeList)) {
					delIndex = i;
				}
			}
			for(int i = 0; i < clsCodeCookieArr.length; i++) {
				if(i == delIndex) {
					continue;
				}
				
				if(reClsCode.equals("")) {
					reClsCode = clsCodeCookieArr[i];
				}else{
					reClsCode = reClsCode + "_" + clsCodeCookieArr[i];
				}
			}
			Cookie cookie = new Cookie("clsCode", reClsCode);
			cookie.setMaxAge(-1);
			response.addCookie(cookie);
		}
		return 1;
	}
	
	public List<OrderDTO> searchOrd(MemberDTO currentUser){
		OrderDTO ordDTO = new OrderDTO();
		ordDTO.setMem_code(currentUser.getMem_code());
		System.out.println(ordDTO.getMem_code());
		return ordDAO.selectOrdMemCode(ordDTO);		
	}
	
	// 주문 검색 메소드
	public List<OrderDTO> searchOrdAdm(String searchCon, String searchWord){
		List<OrderDTO> ordList = new ArrayList<OrderDTO>();
		MemberDTO memDTO = new MemberDTO();
		OrderDTO ordDTO = new OrderDTO();
		
		if(searchCon.equals("searchOrd")) {
			return ordDAO.selectOrd();
		}else if(searchCon.equals("searchOrdAll")) {
			return ordDAO.selectOrdAll();
		}else if(searchCon.equals("searchOrdDel")) {
			return ordDAO.selectOrdDel();
		}else if(searchCon.equals("mem_code")) {
			ordDTO.setMem_code(Integer.valueOf(searchWord));
			return ordDAO.selectOrdMemCodeAdm(ordDTO);
		}else if(searchCon.equals("mem_id")) {
			memDTO.setMem_id(searchWord);
			return ordDAO.selectOrdMemId(memDTO);
		}else if(searchCon.equals("mem_name")) {
			memDTO.setMem_name(searchWord);
			return ordDAO.selectOrdMemName(memDTO);
		}else if(searchCon.equals("ord_date")) {
			ordDTO.setOrd_date(searchWord);
			return ordDAO.selectOrdDate(ordDTO);
		}else if(searchCon.equals("ord_code")) {
			ordDTO.setOrd_code(Integer.valueOf(searchWord));
			ordList.add(ordDAO.selectOrdCode(ordDTO));
			return ordList;
		}else if(searchCon.equals("unchkOrd")) {
			return ordDAO.selectOrdUnchk();
		}else {
			return null;
		}
	}
	
	// 주문번호로 주문 받아오기(삭제미포함)
	public OrderDTO getOrdByCode(OrderDTO ordDTO) {
		return ordDAO.selectOrdCode(ordDTO);
	}
	
	// 주문번호로 주문 받아오기(삭제포함, 관리자전용)
	public OrderDTO getOrdByCodeAdm(OrderDTO ordDTO) {
		return ordDAO.selectOrdCodeAdm(ordDTO);
	}
	
	// 주문확인 및 주문취소, 복구 메소드
	public int updateOrd(OrderDTO ordDTO) {
		return ordDAO.updateOrd(ordDTO);
	}
	
	// 주문 취소
	public int cancelOrd(OrderDTO ordDTO) {
		return ordDAO.deleteOrd(ordDTO);
	}
}
