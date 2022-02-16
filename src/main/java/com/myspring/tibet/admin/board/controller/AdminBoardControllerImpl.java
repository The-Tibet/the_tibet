package com.myspring.tibet.admin.board.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.myspring.tibet.admin.board.service.AdminBoardSerivce;
import com.myspring.tibet.board.vo.NoticeVO;
import com.myspring.tibet.utils.Criteria;
import com.myspring.tibet.utils.PageMaker;

@Controller("adminBoardController")
public class AdminBoardControllerImpl implements AdminBoardController {
	@Autowired
	private AdminBoardSerivce adminBoardSerivce;
	@Autowired
	private NoticeVO noticeVO;

	// �������� ������
	@RequestMapping(value = "/admin-notice.do")
	public ModelAndView openNoticeList(Criteria cri, HttpServletRequest request) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(adminBoardSerivce.countNoticeListTotal());

		List<Map<String, Object>> list = adminBoardSerivce.selectNoticeList(cri);
		mav.addObject("list", list);
		mav.addObject("pageMaker", pageMaker);
		return mav;
	}

	// �������� ����
	@Override
	@RequestMapping(value = "/noticedelete", method = RequestMethod.GET)
	public String noticedelete(String notice_num) throws Exception {
		adminBoardSerivce.noticedelete(notice_num);
		return "redirect:/admin-notice.do"; 
	}
	 
	// �������� ���û���
  	@Override
	@RequestMapping(value = "/noticedelete")
	public String alldelete(HttpServletRequest request) throws Exception {
  		String[] ajaxMsg = request.getParameterValues("valueArr");
  		int size = ajaxMsg.length;
  		for(int i=0; i < size; i++) {
  			System.out.println("valueArr:"+ajaxMsg[i]);
  			adminBoardSerivce.noticedelete(ajaxMsg[i]);
  		}
		return "redirect:/admin-notice.do";
	}
	
	// �������� �۾���
	@Override
	@RequestMapping(value = "/admin-noticeWrt.do", method = RequestMethod.POST)
	public ResponseEntity insertNoticeWritePage(@ModelAttribute("noticeVO") NoticeVO _noticeVO,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		try {
			adminBoardSerivce.insertNoticeWritePage(_noticeVO);
			message = "<script>";
			message += " alert('�� �ۼ��� �Ϸ�Ǿ����ϴ�. ���� �������� ���ư��ϴ�.');";
			message += " location.href='" + request.getContextPath() + "/admin-notice.do';";
			message += " </script>";

		} catch (Exception e) {
			message = "<script>";
			message += " alert('�۾� �� ������ �߻��߽��ϴ�. �ٽ� �õ��� �ּ���.');";
			message += " location.href='" + request.getContextPath() + "/noticeWrite.do';";
			message += " </script>";
			e.printStackTrace();
		}
		resEntity = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}

	// �������� ����
	@Override
	@RequestMapping(value = "/noticeModify.do", method = RequestMethod.POST)
	public ResponseEntity modifynotice(@ModelAttribute("_noticeVO") NoticeVO _noticeVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		try {
			adminBoardSerivce.insertNoticeWritePage(_noticeVO);
			message = "<script>";
			message += " alert('�� ������ �Ϸ�Ǿ����ϴ�. ���� �������� ���ư��ϴ�.');";
			message += " location.href='" + request.getContextPath() + "/admin-notice.do';";
			message += " </script>";

		} catch (Exception e) {
			message = "<script>";
			message += " alert('�۾� �� ������ �߻��߽��ϴ�. �ٽ� �õ��� �ּ���.');";
			message += " location.href='" + request.getContextPath() + "/admin-noticeModify.do';";
			message += " </script>";
			e.printStackTrace();
		}
		resEntity = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}

	// �������� ���� ������
	@Override
	@RequestMapping(value = "/noticeModifyForm{notice_num}.do", method = RequestMethod.GET)
	public ModelAndView noticeModifyForm(@PathVariable("notice_num") Integer notice_num, ModelAndView mav) throws Exception {
		mav.setViewName("/noticeModifyForm");
		mav.addObject("notice", adminBoardSerivce.adminnoticeDetail(notice_num));
		return mav;
	}

	// �������� �۾��� ������
	@Override
	@RequestMapping(value = "/noticeWrite.do", method = RequestMethod.GET)
	public ModelAndView noticeWrite(ModelAndView mav) throws Exception {
		mav.setViewName("/admin-noticeWrite");
		return mav;
	}

	@Override
	@RequestMapping(value = "/admin-noticeDetail{notice_num}.do", method = RequestMethod.GET)
	public ModelAndView adminnoticeDetail(@PathVariable("notice_num") Integer notice_num, ModelAndView mav)
			throws Exception {
		mav.setViewName("/admin-noticeDetail");
		mav.addObject("notice", adminBoardSerivce.adminnoticeDetail(notice_num));
		return mav;
	}
}