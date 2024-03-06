package com.security.demo.user.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User implements UserDetails {
	
	
	private Long id;
	
	private String email;
	
	private String password;
	
	
	
	
	//권한 반환
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	//사용자의 패스워드 반환
	@Override
	public String getPassword() {
		return null;
	}

	//사용자의 id반환
	@Override
	public String getUsername() {
		return null;
	}

	//계정 만료 여부 반환
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}
	
	//계정 잠금 여부 반환
	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	
	//패스워드 만료 여부 반환
	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	
	//계정 사용 가능 여부 반환
	@Override
	public boolean isEnabled() {
		return false;
	}
	
	@Builder
	public User(String email, String password, String auth) {
		this.email = email;
		this.password = password;
	}

	

	
}
	