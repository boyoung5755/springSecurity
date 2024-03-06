package com.security.demo.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.security.demo.user.DTO.AddUserRequest;
import com.security.demo.user.service.UserDetailServiceImpl;

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
	
	private final UserDetailServiceImpl service;
	
	
	@PostMapping("/user")
	public String signup(AddUserRequest request) {
		service.createUser(request);
		return "redirect:/login";
	}

}