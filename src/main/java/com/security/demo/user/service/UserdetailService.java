package com.security.demo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.demo.user.DAO.UserDAO;
import com.security.demo.user.DTO.AddUserRequest;
import com.security.demo.user.vo.User;

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


@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService{

	private final UserDAO dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return dao.selectUser(username);
	}


//	@Override
//	public User loadUserByUsername(String email) {
//		return dao.selectUser(email);
//	}
//	
	
}
