package com.security.demo.user.service;

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
public class UserDetailServiceImpl implements UserdetailService{

	private final UserDAO dao;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User retrieveUser(String email) {
		return dao.selectUser(email);
	}

	@Override
	public Long createUser(AddUserRequest dto) {
		
		return dao.insertUser(User.builder()
			.email(dto.getEmail())
			.password(bCryptPasswordEncoder.encode(dto.getPassword()))
			.build());
	}
	
	
}
