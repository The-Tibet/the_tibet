package com.myspring.tibet.product.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myspring.tibet.product.dao.ProductDAO;
import com.myspring.tibet.product.vo.MainCateVO;
import com.myspring.tibet.product.vo.ProductVO;

@Service("productService")
public class ProductServiceImpl implements ProductService{
	@Inject
	private ProductDAO productDao;
	
	@Override
	public List<ProductVO> productListNew() throws Exception {
		return productDao.productlistNew();
	}
	
	@Override
	public List<ProductVO> productListHighprice() throws Exception {
		return productDao.productlistHighprice();
	}
	
	@Override
	public List<ProductVO> productListLowprice() throws Exception {
		return productDao.productlistLowprice();
	}
	
//	@Override	
//	public List<ProductVO> productListName(int main_category_num) throws Exception {	
//		return productDao.productlistName(main_category_num);	
//	}
	
	@Override
	public List<ProductVO> productListName() throws Exception {
		return productDao.productlistName();
	}
	
	@Override
	public ProductVO productDetail(String product_num) throws Exception {
		return productDao.productDetail(product_num);
	}
	
	@Override
	public List<ProductVO> productColor(String product_num) throws Exception {
		return productDao.productColor(product_num);
	}	
	
	@Override
	public List<ProductVO> productSize(String product_num) throws Exception {
		return productDao.productSize(product_num);
	}
	
	@Override	
	public List<MainCateVO> mainCate() throws Exception {	
		return productDao.mainCate();	
	}
}
