package org.khj.service;

import org.khj.domain.smsMemberDTO;
import org.khj.mapper.smsMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class smsMemberServicelmpl implements smsMemberService {
	
	@Autowired
	private smsMemberMapper smapper;
	
	//회원가입하기 설계를 구현
	public void insert(smsMemberDTO mdto) {
		smapper.insert(mdto);
	}
	
	//로그인 설계를 구현 
	public smsMemberDTO login(smsMemberDTO mdto) {
		return smapper.login(mdto);
	}
	
//	@Override
//	public int confirmId(String id) throws Exception{
//		int result = smapper.confirmId(id);
//		return result;
//	}

}
