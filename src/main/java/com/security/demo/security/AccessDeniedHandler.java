package com.security.demo.security;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 프로그램 설명
 * @date        : 2024. 3. 7.
 * @author      : boyoung
 * @version	: 1.0
 * <PRE>
 * ----------------------------
 * 개정이력
 * 2024. 3. 7. boyoung : 최초작성
 * </PRE>
 */
public class AccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		System.out.println("여기는 권한이 없을때 오는 곳 입니다.");
	}

}
