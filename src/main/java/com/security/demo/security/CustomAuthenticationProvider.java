package com.security.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.security.demo.user.service.UserdetailService;

import lombok.RequiredArgsConstructor;

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

@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider{

	private final UserdetailService service;
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		// 로그인 로직 
		String id = authentication.getName();
		String pw = (String) authentication.getCredentials();
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(id, pw);
		
		// 유저 디테일서비스에서 DB에서 유저 정보를 가지고 와야합니다.
		UserDetails user = service.loadUserByUsername(id);
		
		// 비밀번호를 암호화한 내용과 요청하면서 들어온 위에 pw 비밀번호가 같은지 확인
		
		if( ! bCryptPasswordEncoder().matches(pw, user.getPassword())) {
			System.out.println("비밀번호불일치");
			throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
		}
		return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
	}

	// 위에 authenticate를 들릴지 안들리지 먼저 확인하는 메서드 true면 authenticate 들리고 false면 안들림
	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
	
	
	//패스워드 인코더로 사용할 빈 등록
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	

}
