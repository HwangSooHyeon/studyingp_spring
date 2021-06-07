package com.busanit01.studyingp.service;

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
	
}
