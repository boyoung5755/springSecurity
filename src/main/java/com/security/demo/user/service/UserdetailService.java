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

public interface UserdetailService {
	
	/**
	 * 메서드 설명 로그인을 하기위한 하나의 유저정보 조회
	 * @Method Name  	: retrieveUser
	 * @date   			: 2024. 3. 6.
	 * @author   		: boyoung
	 * @version     	: 1.0
	 * ----------------------------------------
	 * @param email
	 * @return
	 */
	public User retrieveUser(String email);
	
	
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

}
