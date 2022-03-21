package org.khj.mapper;

import org.khj.domain.smsMemberDTO;

public interface smsMemberMapper {

	//회원가입하기 설계
	public void insert(smsMemberDTO mdto);
	
	//로그인하기 설계
	public smsMemberDTO login(smsMemberDTO mdto);
	
//	int confirmId(String id) throws Exception;
	
}
