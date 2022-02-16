package com.myspring.tibet.admin.product.service;

import java.util.List;

import com.myspring.tibet.product.vo.ProductVO;

public interface AdminProductService {
	// 惑前 惑技
	public ProductVO productDetail(String product_num) throws Exception ;
	// 惑前 格废
	public List<ProductVO> productListName(int main_category_num) throws Exception;
}
