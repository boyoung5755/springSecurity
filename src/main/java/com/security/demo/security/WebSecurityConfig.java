package com.security.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.security.demo.user.DAO.UserDAO;
import com.security.demo.user.service.UserdetailService;

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
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	
	//스프링 시큐리티 기능 비활성화
	@Bean
	public WebSecurityCustomizer configure() {
		
		return (web) -> web.ignoring()
			.requestMatchers("/static/**");
	}
	
	@Autowired
	private UserDAO dao;
	
	@Bean
	public UserdetailService service() {return new UserdetailService(dao);}
	
	@Bean
	public CustomAuthenticationProvider authenticationProvider() {return new CustomAuthenticationProvider(service());}
	
	@Bean
	public FailHandler failHandler() {return new FailHandler();}
	
	@Bean
	public SuccessHandler successHandler() {return new SuccessHandler();}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		return http
				.authorizeHttpRequests(requests ->requests
				.requestMatchers("/login" , "/signup", "/user").permitAll()
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated())
				.authenticationProvider(authenticationProvider())
				.formLogin(login ->login  // 폼기반 로그인 설정
				.loginPage("/login")
				.loginProcessingUrl("/loginProcess")
				.usernameParameter("email")
				.passwordParameter("password")
				.successHandler(successHandler())
				.failureHandler(failHandler()))
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

		daoAuthenticationProvider.setUserDetailsService(service());
		daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
		
		return daoAuthenticationProvider;
		
	}
	
	//패스워드 인코더로 사용할 빈 등록
	@Bean 
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

}
