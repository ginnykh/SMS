package org.khj.service;

import org.khj.domain.smsMemberDTO;

public interface smsMemberService {

	//회원가입하기
	public void insert(smsMemberDTO mdto);
	
	//로그인 설계
	public smsMemberDTO login(smsMemberDTO mdto);
	
//	int confirmId(String id) throws Exception;
	
}
