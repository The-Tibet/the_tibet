package com.myspring.tibet.member.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.tibet.OAuth.SNSLogin;
import com.myspring.tibet.OAuth.SnsVO;
import com.myspring.tibet.common.base.BaseController;
import com.myspring.tibet.member.service.MemberService;
import com.myspring.tibet.member.vo.MemberVO;

@Controller("memberController")
public class MemberControllerImpl extends BaseController implements MemberController{
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;
	
	@Inject
	private SnsVO naverSns;
	@Inject
	private SnsVO googleSns;
	@Inject
	private GoogleConnectionFactory googleConnectionFactory;
	@Inject
	private OAuth2Parameters googleOAuth2Parameters;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value = "/auth/{snsService}/callback", method = { RequestMethod.GET, RequestMethod.POST})
	public String snsLoginCallback(@PathVariable String snsService,
			Model model, @RequestParam String code, HttpSession session) throws Exception {		
		logger.info("snsLoginCallback: service={}", snsService);
		
		SnsVO sns = null;
		if (StringUtils.equals("naver", snsService))		
			sns = naverSns;
		else
			sns = googleSns;
		
		// 1. code??? ???????????? access_token ??????
		// 2. access_token??? ???????????? ????????? profile ?????? ????????????
		SNSLogin snsLogin = new SNSLogin(sns);
		
		MemberVO snsUser = snsLogin.getUserProfile(code); // 1,2??? ??????
		System.out.println("Profile>>" + snsUser);
		
		// 3. DB ?????? ????????? ???????????? ?????? (googleid, naverid ?????? ??????)
		MemberVO user = memberService.getBySns(snsUser);
		if (user == null) {
			model.addAttribute("result", "???????????? ?????? ??????????????????. ????????? ?????????.");
			
			// ???????????? ??????????????????!!		
		} else {
			model.addAttribute("result", user.getUser_name() + "??? ???????????????.");
			
			// 4. ????????? ???????????????
		    session.setAttribute("isLogOn", true);
		    
			model.addAttribute("redirect:/main.do");
		}
		return "/main.do";
		
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET) 
	public ModelAndView naver(Model model, HttpSession session) {
		logger.info("login GET .....");
	  
		ModelAndView mav = new ModelAndView();
	  
		SNSLogin snsLogin = new SNSLogin(naverSns); 
		mav.addObject("naver_url", snsLogin.getNaverAuthURL()); 
		mav.setViewName("/login");
	  
		return mav;
	}
	
	@Override
	@RequestMapping(value="/signup.do", method = RequestMethod.POST)
	public ResponseEntity addMember(@ModelAttribute("memberVO") MemberVO _memberVO,
			                HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		try {
			memberService.addMember(_memberVO);

		    message  = "<script>";
		    message +=" alert('?????? ????????? ???????????????. ?????????????????? ???????????????.');";
		    message += " location.href='"+request.getContextPath()+"/login.do';";
		    message += " </script>";    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('?????? ??? ????????? ??????????????????. ?????? ????????? ?????????.');";
		    message += " location.href='"+request.getContextPath()+"/signupForm.do';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam Map<String, String> loginMap, // loginMap??? ???????????? ????????? ??????
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		memberVO = memberService.login(loginMap);
		HttpSession session = request.getSession();
		session = request.getSession();
		session.setAttribute("isLogOn", false);

		if (memberVO != null && memberVO.getUser_id() != null) { // ???????????? ?????????????????? ?????? ??????			
			session.setAttribute("isLogOn", true); // ???????????? ?????????????????? true??? ?????? ???????????????
			session.setAttribute("memberInfo", memberVO);
			
			mav.setViewName("redirect:/main.do");

//			String action = (String) session.getAttribute("action"); // ??????????????? ???????????? ???????????????
//
//			if (action != null && action.equals("/order.do")) { // ?????? ???????????? ????????? ???????????????
//				mav.setViewName("forward:" + action);
//			} else {
//				mav.setViewName("redirect:/main.do");
//			}

		} else {
			String message = "????????? ?????? ??????????????? ???????????????. ?????? ????????? ????????????.";
			mav.addObject("message", message);
			mav.setViewName("/login");
		}
		return mav;
	}

	@Override
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET) // ??????????????? main.do ?????????????????? ??????
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		session.setAttribute("isLogOn", false);
		session.removeAttribute("memberInfo");
		mav.setViewName("redirect:/main.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/overlapped.do", method = RequestMethod.POST) 
	public ResponseEntity overlapped(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) throws Exception{
		ResponseEntity resEntity = null;
		String result = memberService.overlapped(id);
		resEntity = new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}

	@RequestMapping(value="/findID.do")
	public String findIDView() {
		return "/findID";
	}
	
	@Override
	@RequestMapping(value="/resultID.do", method = RequestMethod.POST) 
	public String findID(MemberVO memberVO, Model model) throws Exception {
		MemberVO member = memberService.findID(memberVO);
		
		if(member == null) { 
			model.addAttribute("check", 1);
		} else { 
			model.addAttribute("check", 0);
			model.addAttribute("user_id", member.getUser_id());
		}
		
		return "/resultID";
	}
	
	@RequestMapping(value="/findPW.do")
	public String findPWView() {
		return "/findPW";
	}

	@Override
	@RequestMapping(value="/resultPW.do", method = RequestMethod.POST) 
	public String findPW(MemberVO memberVO, Model model) throws Exception {
		MemberVO member = memberService.findPW(memberVO);

		if (member == null) {
			model.addAttribute("check", 1);
		} else {
			model.addAttribute("check", 0);
			model.addAttribute("user_pw", member.getUser_pw());
		}

		return "/resultPW";
	}
	
	@Override
	@RequestMapping(value = "/userDelete.do", method = RequestMethod.POST)
	public String deletePOST(MemberVO vo, HttpSession session) throws Exception {
		// ????????? ?????? member??? ????????? member????????? ???????????????.	
		MemberVO member = (MemberVO) session.getAttribute("memberInfo");
		// ??????????????? ????????????
		String sessionPass = member.getUser_pw();
		// vo??? ???????????? ????????????
		String voPass = vo.getUser_pw();
		if((sessionPass.equals(voPass))) {
			memberService.deleteMember(vo);
			session.invalidate();
			return "redirect:/main.do";
		}
		return "redirect:/memModifyForm.do";
	}
	
	@Override
	@RequestMapping(value = "/memModifyForm{user_id}.do", method = RequestMethod.GET)
	public ModelAndView memModifyForm(@PathVariable("user_id") String user_id, ModelAndView mav,HttpServletRequest request, HttpServletResponse response) throws Exception {
		mav.setViewName("/memModifyForm");
		mav.addObject("memMod", memberService.modifyMemberForm(user_id));
		return mav;
	}
	
	@Override
	@RequestMapping(value="/memModify.do", method = RequestMethod.POST)
	public ResponseEntity memModify(@ModelAttribute("memberVO") MemberVO vo, HttpServletRequest request, 
			HttpServletResponse response,HttpSession session) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		try {
			memberService.modifyMember(vo);
			session.removeAttribute("memberInfo");
		    message  = "<script>";
		    message +=" alert('?????? ????????? ?????????????????????. ???????????? ??? ????????????????????? ???????????????.');";
		    message += " location.href='"+request.getContextPath()+"/login.do';";
		    message += " </script>";    
		} catch(Exception e) {
			message  = "<script>";
		    message +=" alert('?????? ??? ????????? ??????????????????. ?????? ????????? ?????????.');";
		    message += " location.href='"+request.getContextPath()+"/memModifyForm.do';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
		return resEntity;
	}
}
