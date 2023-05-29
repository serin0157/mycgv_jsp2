package com.mycgv_jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycgv_jsp.service.MemberService;
import com.mycgv_jsp.vo.MemberVo;

@Controller
public class LoginController {
	@Autowired
	private MemberService memberService;
	
	/**
	 *  login_fail.do - �α��� ����
	 * */
	@RequestMapping(value="/login_fail.do", method=RequestMethod.GET)
	public String login_fail() {
		return "/login/login_fail";
	}
	/**
	 *  login.do - �α��� ��
	 * */
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		return "/login/login";
	}
	
	/**
	 *  login_proc.do - �α��� ó��
	 * */
	@RequestMapping(value="/login_proc.do", method=RequestMethod.POST)
	public ModelAndView login_proc(MemberVo memberVo) {
		ModelAndView model = new ModelAndView();
		int result = memberService.getLoginResult(memberVo);
		
		if(result == 1) {
			//index �̵�
			//viewName = "index"; viewResolver�� ȣ�� --> index.jsp : header.do, footer.do ȣ�� X
			model.addObject("login_result", "ok");
			model.setViewName("index"); //= sendResirect
		}else {
			//login_fail.jsp
			model.setViewName("redirect:/login_fail.do");
		}
		return model;
	}
	
}
