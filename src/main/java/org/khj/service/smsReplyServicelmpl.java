package org.khj.service;

import java.util.ArrayList;

import org.khj.domain.smsReplyDTO;
import org.khj.mapper.smsReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class smsReplyServicelmpl implements smsReplyService {

	@Autowired
	private smsReplyMapper rMapper;
	
	// 댓글 쓰기
	public int write(smsReplyDTO rdto) {
		return rMapper.write(rdto);
	}
	
	// 댓글 목록 리스트
	public ArrayList<smsReplyDTO> list(int bno){
		return rMapper.list(bno);
	}
	
	// 댓글 내용 가져오기
	public smsReplyDTO detail(int rno) {
		return rMapper.detail(rno);
	}
	
	// 댓글 수정
	public int update(smsReplyDTO rdto) {
		return rMapper.update(rdto);
	}
	
	public int remove(smsReplyDTO rdto) {
		return rMapper.remove(rdto);
	}
	
}
