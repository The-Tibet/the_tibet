package com.myspring.tibet.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("mainController")
public class MainController {

//	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
//	public String main(Locale locale, Model model) {
//		return "/main";
//	}
	
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/main");
		return mav;
	}
	
	@RequestMapping(value = "/membership.do", method = RequestMethod.GET)
	public ModelAndView membership(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/membership");
		return mav;
	}
	
	
	
	@RequestMapping(value = "/search.do", method = RequestMethod.GET) 
	public ModelAndView search() {
		ModelAndView mav = new ModelAndView("/search");
		return mav; 
	}
	
	/*
	 * @RequestMapping(value = "/orderList.do", method = RequestMethod.GET) public
	 * ModelAndView orderlist(HttpServletRequest request, HttpServletResponse
	 * response) throws Exception { ModelAndView mav = new
	 * ModelAndView("/orderList"); return mav; }
	 * 
	 * @RequestMapping(value = "/cancelList.do", method = RequestMethod.GET) public
	 * ModelAndView cancellist(HttpServletRequest request, HttpServletResponse
	 * response) throws Exception { ModelAndView mav = new
	 * ModelAndView("/cancelList"); return mav; }
	 */
}