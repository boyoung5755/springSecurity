package com.security.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	private final UserDetailsService userService;
	
	//스프링 시큐리티 기능 비활성화
	@Bean
	public WebSecurityCustomizer configure() {
		
		return (web) -> web.ignoring()
			.requestMatchers("*");
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		return http
				.authorizeHttpRequests(requests ->requests
				.requestMatchers("/login" , "/signup", "/user").permitAll()
				.anyRequest().authenticated())
				.formLogin(login ->login  // 폼기반 로그인 설정
				.loginPage("/login")
				.defaultSuccessUrl("/home"))
				.logout(logout ->logout  // 로그아웃 설정
				.logoutSuccessUrl("/login")
				.invalidateHttpSession(true))
				.csrf(csrf ->csrf.disable())   //csrf 비활성화
				.build();
	}
	
	//인증 관리자 관련 설정
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider()  throws Exception{
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

		daoAuthenticationProvider.setUserDetailsService(userService);
		daoAuthenticationProvider.setPasswordEncoder(BCryptPasswordEncoder());
		
		return daoAuthenticationProvider;
		
	}
	
	//패스워드 인코더로 사용할 빈 등록
	@Bean 
	private PasswordEncoder BCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

}
