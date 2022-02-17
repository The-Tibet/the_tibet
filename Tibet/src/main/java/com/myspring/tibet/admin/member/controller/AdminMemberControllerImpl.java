package com.myspring.tibet.admin.member.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	// 메인 차트 <-- 예정
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

	// 회원 삭제
	@RequestMapping(value = "/memberDelete", method = RequestMethod.GET)
	public String memberDelete(String user_id) throws Exception {
		adminMemberService.memberDelete(user_id);
		return "redirect:/admin-memberlist.do"; 
	}
	
	// 회원 수정화면
	@RequestMapping(value = "/adminmemModifyForm{user_id}.do", method = RequestMethod.GET)
	public ModelAndView adminmemModifyForm(@PathVariable("user_id") String user_id, ModelAndView mav,HttpServletRequest request, HttpServletResponse response) throws Exception {
		mav.setViewName("/adminmemModifyForm");
		mav.addObject("memMod", adminMemberService.adminmodifyMemberForm(user_id));
		return mav;
	}
	// 회원 수정기능
	@RequestMapping(value="/adminmemModify.do", method = RequestMethod.POST)
	public ResponseEntity adminmemModify(@ModelAttribute("memberVO") MemberVO vo, HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		try {
			adminMemberService.adminmodifyMember(vo);
			session.removeAttribute("memberInfo");
		    message  = "<script>";
		    message +=" alert('회원 수정이 완료되었습니다. 원래페이지로 이동합니다.');";
		    message += " location.href='"+request.getContextPath()+"/login.do';";
		    message += " </script>";    
		} catch(Exception e) {
			message  = "<script>";
		    message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요.');";
		    message += " location.href='"+request.getContextPath()+"/memModifyForm.do';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
}