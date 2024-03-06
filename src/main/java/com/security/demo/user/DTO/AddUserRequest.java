package com.security.demo.user.DTO;

import lombok.Data;

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

@Data
public class AddUserRequest {
	
	private String email;
	private String password;

}
