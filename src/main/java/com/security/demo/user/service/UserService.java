package com.security.demo.user.service;

import com.security.demo.user.DTO.AddUserRequest;
import com.security.demo.user.vo.User;

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
public interface UserService {
	

	/**
	 * 메서드 설명 회원가입
	 * @Method Name  	: createUser
	 * @date   			: 2024. 3. 6.
	 * @author   		: boyoung
	 * @version     	: 1.0
	 * ----------------------------------------
	 * @param user
	 * @return
	 */
	public Long createUser(AddUserRequest dto);


	/**
	 * 로그인하기 위한  정보 비교
	 * @param email
	 * @param password
	 * @return
	 */
	public String loginUser(String email, String password);


}
