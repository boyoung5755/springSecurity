package com.security.demo.user.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.security.demo.user.vo.User;

@Mapper
public interface UserDAO {
	
	/**
	 * 메서드 설명 :email로 사용자 정보 가져옴
	 * @Method Name  	: selectUser
	 * @date   			: 2024. 3. 6.
	 * @author   		: boyoung
	 * @version     	: 1.0
	 * ----------------------------------------
	 * @param email
	 * @return 
	 */
	public User selectUser(String email);
	
	
	/**
	 * 메서드 설명 : 회원가입
	 * @Method Name  	: insertUser
	 * @date   			: 2024. 3. 6.
	 * @author   		: boyoung
	 * @version     	: 1.0
	 * ----------------------------------------
	 * @param user
	 * @return
	 */
	public Long insertUser(User user);
}
