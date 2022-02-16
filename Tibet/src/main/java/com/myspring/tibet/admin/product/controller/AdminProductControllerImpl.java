package com.myspring.tibet.admin.product.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.tibet.admin.board.controller.AdminBoardController;
import com.myspring.tibet.admin.product.service.AdminProductService;
import com.myspring.tibet.product.vo.ProductVO;
import com.myspring.tibet.utils.Criteria;
import com.myspring.tibet.utils.PageMaker;

@Controller("adminProductController")
public class AdminProductControllerImpl implements AdminProductController {
	@Autowired
	private AdminProductService adminProductService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(AdminBoardController.class);
	
	// 회원 목록페이지
	@Override
	@RequestMapping(value = "/admin-product.do", method = RequestMethod.GET)
	public ModelAndView adminopenProductList(Criteria cri, HttpServletRequest request) throws Exception {
		logger.info("viewName:");
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(adminProductService.adminopenProductList(cri));
		List<ProductVO> list = adminProductService.selectAllProductList(cri);
		mav.addObject("list", list);
		mav.addObject("pageMaker", pageMaker);
		return mav;
	}
	// 상품 등록
	@RequestMapping(value = "/admin-register.do", method = RequestMethod.GET)
	public void productregiser() throws Exception {
		

	}
	
	
	

	}
	

	
	
	
