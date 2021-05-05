package com.busanit01.studyingp.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.busanit01.studyingp.dto.OrderDTO;

@Repository
public class OrderDAOImpl implements OrderDAO{

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<OrderDTO> selectOrd() {
		return sqlSession.selectList("mappers.OrderMapper.selectOrd");
	}
	@Override
	public List<OrderDTO> selectOrdAll() {
		return sqlSession.selectList("mappers.OrderMapper.selectOrdAll");
	}
	@Override
	public List<OrderDTO> selectOrdDel() {
		return sqlSession.selectList("mappers.OrderMapper.selectOrdDel");
	}
	@Override
	public OrderDTO selectOrdCode(OrderDTO orderDto){
		return sqlSession.selectOne("mappers.OrderMapper.selectOrdCode");
	}
	@Override
	public List<OrderDTO> selectOrdMemCode(OrderDTO orderDto) {
		return sqlSession.selectList("mappers.OrderMapper.selectOrdMemCode");
	}
	@Override
	public List<OrderDTO> selectOrdClsCode(OrderDTO orderDto) {
		return sqlSession.selectList("mappers.OrderMapper.selectOrdClsCode");
	}
	@Override
	public OrderDTO selectOrdCheck() {
		return sqlSession.selectOne("mappers.OrderMapper.selectOrdCheck");
	}
	@Override
	public int updateOrdCheck(OrderDTO orderDto) {
		int result = sqlSession.update("mappers.OrderMapper.updateOrdCheck", orderDto);
		sqlSession.commit();
		return result;

	}
	@Override
	public int insertOrd(OrderDTO orderDto) {
		int result = sqlSession.insert("mappers.OrderMapper.insertOrd", orderDto);
		sqlSession.commit();
		return result;
	}
	@Override
	public int deleteOrd(OrderDTO orderDto) {
		int result = sqlSession.update("mappers.OrderMapper.deleteOrd", orderDto);
		sqlSession.commit();
		return result;
	}
	
}