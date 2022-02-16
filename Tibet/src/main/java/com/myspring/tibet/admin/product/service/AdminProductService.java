package com.myspring.tibet.admin.product.service;

import java.util.List;

import com.myspring.tibet.product.vo.ProductVO;
import com.myspring.tibet.utils.Criteria;

public interface AdminProductService {
	// 상품 목록
	 public int adminopenProductList(Criteria cri) throws Exception; 
	// 상품 페이징
	public List<ProductVO> selectAllProductList(Criteria cri) throws Exception;
}
