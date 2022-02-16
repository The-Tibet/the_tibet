package com.myspring.tibet.admin.product.dao;

import java.util.List;

import com.myspring.tibet.product.vo.ProductVO;

public interface AdminProductDAO {
	// 惑前 惑技
	public ProductVO productDetail(String product_num);
	// 惑前 格废
	public List<ProductVO> productlistName(int main_category_num) throws Exception;
}
