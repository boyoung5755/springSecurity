package com.security.demo.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * 프로그램 설명 : 뷰를 호출하는 콘트롤러들
 * @date        : 2024. 3. 6.
 * @author      : boyoung
 * @version	: 1.0
 * <PRE>
 * ----------------------------
 * 개정이력
 * 2024. 3. 6. boyoung : 최초작성
 * </PRE>
 */
@Controller
public class UserViewController {
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}

}
