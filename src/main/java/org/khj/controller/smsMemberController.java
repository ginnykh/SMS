package org.khj.controller;

import javax.servlet.http.HttpSession;

import org.khj.domain.smsMemberDTO;
import org.khj.service.smsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("sms")
public class smsMemberController {
	
	@Autowired
	smsMemberService sservice;
	
	//회원가입 화면 이동
	@GetMapping("member")
	public void write() {
		
	}
	
	//회원가입을 통해 얻어진 데이터 insert
	@PostMapping("member")
	public String Postmember(smsMemberDTO mdto) {
		sservice.insert(mdto);
		return "redirect:/sms/login";
	}    
	
//	// 아이디 중복 검사
//	@RequestMapping(value = "confirmId", method = RequestMethod.POST)
//	@ResponseBody
//	public int confirmId(String id) throws Exception{
//		int result = sservice.confirmId(id);
//		return result;
//	} 
	
	//로그인 화면 이동
	@GetMapping("login")
	public void login() {
		
	}
		
	//로그인 화면을 통해 얻어진 테이터를 활용하여 select	
	@PostMapping("login")
	public String PostLogin(smsMemberDTO mdto, HttpSession session) {
		smsMemberDTO login = sservice.login(mdto);
		       session.setAttribute("login", login );
		       
		       //session.invalidate(); session의 초기화 : 로그아웃
		       //session영역에 login변수에 값이 있으면 로그인 된 채로
		       
		       if(session.getAttribute("login")!=null) {
		    	   //main페이지로 이동
		    	   return "redirect:/sms/main";
		       } else {     //session영역에 login변수에 값이 없으면 (null)
		    	   //다시 로그인 할 수 있게 로그인 페이지로 이동
		    	   return "redirect:/sms/login";
		       }
	
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/sms/main";
	}
	
}