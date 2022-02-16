package com.myspring.tibet.admin.product.dao;

import java.util.List;

import com.myspring.tibet.product.vo.ProductVO;
import com.myspring.tibet.utils.Criteria;

public interface AdminProductDAO {
	// 상품 목록
	public int adminopenProductList(Criteria scri) throws Exception; 
	// 상품 페이징
	public  List<ProductVO> selectAllProductList(Criteria scri) throws Exception;

}