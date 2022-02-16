package com.myspring.tibet.admin.product.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myspring.tibet.product.vo.ProductVO;
import com.myspring.tibet.utils.Criteria;

@Repository("adminProductDAO")
public class AdminProductDAOImpl implements AdminProductDAO{
	@Inject
	private SqlSession sqlSession;
	
	// 상품 페이징
	@Override
	public List<ProductVO> selectAllProductList(Criteria cri) throws Exception {
		return sqlSession.selectList("mapper.admin.product.selectAllProductList", cri);
	}
	// 상품 목록
	@Override
	public int adminopenProductList(Criteria cri) throws Exception {
		   return sqlSession.selectOne("mapper.admin.product.adminopenProductList");
	}

}

