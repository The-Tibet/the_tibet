package com.myspring.tibet.admin.product.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.myspring.tibet.utils.Criteria;

public interface AdminProductController {
	
	
	public ModelAndView adminopenProductList(Criteria cri, HttpServletRequest request) throws Exception;
	
	

	}
	

	
	
	
