package com.security.demo.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.security.demo.user.DTO.AddUserRequest;
import com.security.demo.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

/**
 * 프로그램 설명
 * @date        : 2024. 3. 6.
 * @author      : boyoung
 * @version	: 1.0
 * <PRE>
 * ----------------------------
 * 개정이력
 * 2024. 3. 6. boyoung : 최초작성
 * </PRE>
 */

@RequiredArgsConstructor
@Controller
public class UserController {
	
	private final UserService service;
	
	
	/**
	 * 회원가입 컨트롤러
	 * @param request
	 * @return
	 */
	@PostMapping("/user")
	public String signup(AddUserRequest request) {
		service.createUser(request);
		return "redirect:/login";
	}
	
	/**
	 * 로그아웃 컨트롤러
	 * @param request
	 * @param response
	 * @return
	 */
	@GetMapping("/logout")
	public String logout(HttpServletRequest request , HttpServletResponse response) {
		new SecurityContextLogoutHandler().logout(request, response, 
				SecurityContextHolder.getContext().getAuthentication());
		
		return "redirect:/login";
	}

}