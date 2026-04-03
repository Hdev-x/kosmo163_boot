package com.gguek.app.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

//annotaion 설명 + 기능
@Controller
@RequestMapping("/member/*")
public class MemberController {

	
	
	
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public void join(MemberDTO dto) {
		//파라미터의 이름과 dto의 setter의 이름이 같아야 한다.
		//타입도 동일해야 함
		dto.setName(dto.getName());
		
		
		
		System.out.println("회원가입 정보 입력");
	}
	
	
	
	
	
	
//	@RequestMapping(value = "join", method = RequestMethod.POST)
//	public void join(@RequestParam (name = "name" ) String name, @RequestParam (name = "age") Integer age) {
//		
//		MemberDTO dto = new MemberDTO();
//		dto.setName(name);
//		
//		
//		
//		System.out.println("회원가입 정보 입력");
//	}
//	
	
	
	
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		System.out.println("회원가입 페이지");
		
		
		return "member/join";
	}
//	@RequestMapping(value = "join", method = RequestMethod.POST)
//	public void join(HttpServletRequest request) {
//		System.out.println("회원가입 정보 입력");
//		
//		String name = request.getParameter("name");
//		String age = request.getParameter("age");
//		String date = request.getParameter("date");
//		String [] nums = request.getParameterValues("num");
//		
//		
//		System.out.println("name : " + name);
//		System.out.println("age : " + age);
//		System.out.println("date : " + date);
//		
//		
//		
//	}

	@RequestMapping("login")
	public String login() {
		System.out.println("로그인");
		
		return "member/login";
	}

}
