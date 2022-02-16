package com.myspring.tibet.admin.member.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.tibet.admin.member.service.AdminMemberService;
import com.myspring.tibet.member.vo.MemberVO;
import com.myspring.tibet.utils.Criteria;
import com.myspring.tibet.utils.PageMaker;

@Controller("adminMemberController")
public class AdminMemberControllerImpl implements AdminMemberController {
	@Autowired
	private AdminMemberService adminMemberService;
	@Autowired
	private MemberVO memberVO;
	
	// 메인
	@RequestMapping(value = "/admin-main.do", method = RequestMethod.GET)
	public void adminmain() throws Exception {
}
	
	// 회원 목록페이지
	@RequestMapping(value = "/admin-memberlist.do")
	public ModelAndView openNoticeList(Criteria cri, HttpServletRequest request) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(adminMemberService.countMemberList());
		List<Map<String, Object>> list = adminMemberService.selectAllmemberList(cri);
		mav.addObject("list", list);
		mav.addObject("pageMaker", pageMaker);
		return mav;
	}

	// 회원 선택삭제
	@RequestMapping(value = "/memberDelete") 
	public String memberDelete(HttpServletRequest request) throws Exception {
		String[] ajaxMsg = request.getParameterValues("valueArr");
		int size = ajaxMsg.length;
		for(int i=0; i < size; i++) {
			adminMemberService.memberDelete(ajaxMsg[i]);
	    }
		return "redirect:/admin-memberlist.do";
	}
}

	