package com.security.demo.user.service;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.security.demo.user.DAO.UserDAO;

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
public class UserdetailService implements UserDetailsService{

	private final UserDAO dao;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UserDetails user =  dao.selectUser(email);
		// 권한을 가져와야합니다. DB 
		String role = dao.selectUser(email).getRole();
		
		Collection<? extends GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(role));
		System.out.println(authorities);
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		return new User(user.getUsername(), user.getPassword(), authorities);
	}

}
