﻿package com.myspring.tibet.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.tibet.board.service.BoardService;
import com.myspring.tibet.board.vo.NoticeVO;
import com.myspring.tibet.board.vo.QnaVO;
import com.myspring.tibet.product.service.ProductService;
import com.myspring.tibet.utils.Criteria;
import com.myspring.tibet.utils.PageMaker;
import com.myspring.tibet.utils.SearchCriteria;

@Controller("boardController")
public class BoardControllerImpl implements BoardController {
	private static final String ARTICLE_IMAGE_REPO = "C:\\tibet_board\\board_image";
	@Autowired
	private BoardService boardService;
	@Autowired
	private ProductService productService;
	
	@Override
	@RequestMapping(value = "/qnaWrt.do", method = RequestMethod.POST)
	public ResponseEntity insertQnaWritePage(@ModelAttribute("qnaVO") QnaVO _qnaVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		try {
			boardService.insertQnaWritePage(_qnaVO);
			message = "<script>";
			message += " alert('글 작성이 완료되었습니다. QNA 페이지로 돌아갑니다.');";
			message += " location.href='" + request.getContextPath() + "/qna.do';";
			message += " </script>";

		} catch (Exception e) {
			message = "<script>";
			message += " alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요.');";
			message += " location.href='" + request.getContextPath() + "/qnaWrite.do';";
			message += " </script>";
			e.printStackTrace();
		}
		resEntity = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}

	@Override
	@RequestMapping(value = "/prodQnaWrite{product_num}.do", method = RequestMethod.GET)
	public ModelAndView prodQnaWrite(@PathVariable("product_num") String product_num, ModelAndView mav) throws Exception {
		mav.setViewName("/prodQnaWrite");
		mav.addObject("vo", productService.productDetail(product_num));
		return mav;
	}

	@Override
	@RequestMapping(value = "/qnaWrite.do", method = RequestMethod.GET)
	public ModelAndView qnaWrite(ModelAndView mav) throws Exception {
		mav.setViewName("/qnaWrite");
		return mav;
	}
	// QNA 페이징+검색 목록
	@Override
	@RequestMapping(value = "/qna.do")
	public ModelAndView openQnaList(SearchCriteria scri, HttpServletRequest request) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(boardService.countQnaList(scri));

		List<QnaVO> list = boardService.selectQnaList(scri);
		mav.addObject("list", list);
		mav.addObject("pageMaker", pageMaker);
		return mav;
	}
	
	// 공지사항 페이징+검색 목록
	@Override
	@RequestMapping(value = "/notice.do", method = RequestMethod.GET)
	public ModelAndView openNoticeList (SearchCriteria scri, HttpServletRequest request) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(boardService.countNoticeList(scri));

		List<NoticeVO> list = boardService.selectAllNoticesList(scri);
		mav.addObject("list", list);
		mav.addObject("pageMaker", pageMaker);
		return mav;
	}

	@Override
	@RequestMapping(value = "/qnaDetail{qna_num}.do", method = RequestMethod.GET)
	public ModelAndView qnaDetail(@PathVariable("qna_num") Integer qna_num, ModelAndView mav) throws Exception {
		mav.setViewName("/qnaDetail");
		mav.addObject("qna", boardService.qnaDetail(qna_num));
		mav.addObject("comment", boardService.qnaDetailComment(qna_num));
		return mav;
	}

	@Override
	@RequestMapping(value = "/qnaModifyForm{qna_num}.do", method = RequestMethod.GET)
	public ModelAndView qnaModifyForm(@PathVariable("qna_num") Integer qna_num, ModelAndView mav) throws Exception {
		mav.setViewName("/qnaModifyForm");
		mav.addObject("qna", boardService.qnaDetail(qna_num));
		return mav;
	}

	@Override
	@RequestMapping(value = "/qnaModify.do", method = RequestMethod.POST)
	public ResponseEntity modifyQna(QnaVO qnaVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		try {
			boardService.modifyQna(qnaVO);
			System.out.println("컨트롤러 : " + qnaVO.getQna_content());
			System.out.println("컨트롤러 : " + qnaVO.getQna_num());
			System.out.println("컨트롤러 : " + qnaVO.getQna_pw());
			message = "<script>";
			message += " alert('글 수정이 완료되었습니다. QNA 페이지로 돌아갑니다.');";
			message += " location.href='" + request.getContextPath() + "/qna.do';";
			message += " </script>";

		} catch (Exception e) {
			message = "<script>";
			message += " alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요.');";
			message += " location.href='" + request.getContextPath() + "/noticeModify.do';";
			message += " </script>";
			e.printStackTrace();
		}
		resEntity = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}	 

	@Override
	@RequestMapping("delete")
	public String delete(@RequestParam("qna_num") Integer qna_num) throws Exception {
		boardService.deleteQna(qna_num);
		return "redirect:/qna.do";
	}

	@Override
	@RequestMapping(value = "/noticeDetail{notice_num}.do", method = RequestMethod.GET)
	public ModelAndView noticeDetail(@PathVariable("notice_num") Integer notice_num, ModelAndView mav) throws Exception {
		mav.setViewName("/noticeDetail");
		mav.addObject("notice", boardService.noticeDetail(notice_num));
		return mav;
	}
}
