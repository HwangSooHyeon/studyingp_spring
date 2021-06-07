package com.busanit01.studyingp.dao;

import java.util.List;

import com.busanit01.studyingp.dto.OrderDTO;

public interface OrderDAO {

	// 활성화된 주문조회
	public List<OrderDTO> selectOrd();
	// 취소포함 전체 주문조회
	public List<OrderDTO> selectOrdAll();
	// 취소 주문조회
	public List<OrderDTO> selectOrdDel();
	// 주문조회 (주문번호)
	public OrderDTO selectOrdCode(OrderDTO orderDto);
	// 주문조회(회원번호)
	public List<OrderDTO> selectOrdMemCode(OrderDTO orderDto);
	// 주문조회(강의번호)
	public OrderDTO selectOrdClsCode(OrderDTO orderDto);
	// 주문조회(결제확인 체크)
	public OrderDTO selectOrdCheck();
	
	// 결제완료
	public int updateOrdCheck(OrderDTO orderDto);
	// 주문
	public int insertOrd(OrderDTO orderDto);
	// 주문취소
	public int deleteOrd(OrderDTO orderDto);	
}