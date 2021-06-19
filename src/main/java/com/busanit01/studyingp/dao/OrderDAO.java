package com.busanit01.studyingp.dao;

import java.util.List;

import com.busanit01.studyingp.dto.MemberDTO;
import com.busanit01.studyingp.dto.OrderDTO;

public interface OrderDAO {

	// 활성화된 주문조회
	public List<OrderDTO> selectOrd();
	// 취소포함 전체 주문조회
	public List<OrderDTO> selectOrdAll();
	// 취소 주문조회
	public List<OrderDTO> selectOrdDel();
	// 주문조회(주문번호)
	public OrderDTO selectOrdCode(OrderDTO orderDto);
	// 주문조회(회원번호)
	public List<OrderDTO> selectOrdMemCode(OrderDTO orderDto);
	// 주문조회(회원명)
	public List<OrderDTO> selectOrdMemName(MemberDTO memberDto);
	// 주문조회(회원아이디)
	public List<OrderDTO> selectOrdMemId(MemberDTO memberDto);
	// 주문조회(기간)
	public List<OrderDTO> selectOrdDate(OrderDTO orderDto);
	// 주문조회(강의번호)
	public OrderDTO selectOrdClsCode(OrderDTO orderDto);
	// 주문조회(결제된 주문 전체)
	public List<OrderDTO> selectOrdCheck();
	// 주문조회(미결제)
	public List<OrderDTO> selectOrdUnchk();
	// 결제완료
	public int updateOrdCheck(OrderDTO orderDto);
	// 결제취소
	public int cancelOrdCheck(OrderDTO orderDto);
	// 주문
	public int insertOrd(OrderDTO orderDto);
	// 주문취소
	public int deleteOrd(OrderDTO orderDto);	
	// 입금확인 및 주문취소, 복구
	public int updateOrd(OrderDTO orderDto);
	// 관리자 주문조회(주문번호)
	public OrderDTO selectOrdCodeAdm(OrderDTO orderDto);
	// 관리자 주문조회(회원번호)
	public List<OrderDTO> selectOrdMemCodeAdm(OrderDTO orderDto);
}