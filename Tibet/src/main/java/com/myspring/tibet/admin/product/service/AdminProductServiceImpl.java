package com.myspring.tibet.admin.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.tibet.admin.product.dao.AdminProductDAO;
import com.myspring.tibet.product.vo.ProductVO;
import com.myspring.tibet.utils.Criteria;

@Service("adminProductService")
public class AdminProductServiceImpl implements AdminProductService{
	@Autowired
	private AdminProductDAO adminProductDAO;
	
	// 공지사항 페이징
	@Override
    public  List<ProductVO> selectAllProductList(Criteria cri) throws Exception {
	    return adminProductDAO.selectAllProductList(cri);
	}
	
	// 공지사항 목록
	@Override
	public int adminopenProductList(Criteria cri) throws Exception{
	    return adminProductDAO.adminopenProductList(cri);
	}

}