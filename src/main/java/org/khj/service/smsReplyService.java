package org.khj.service;

import java.util.ArrayList;

import org.khj.domain.smsReplyDTO;

public interface smsReplyService {

	// 댓글 쓰기
	public int write(smsReplyDTO rdto);
	
	// 댓글 목록
	public ArrayList<smsReplyDTO> list(int bno);
	
	//모달창에 댓글 내용을 가져오기 위한 설계
	public smsReplyDTO detail(int rno);
			
	//댓글 수정을 위한 설계
	public int update(smsReplyDTO rdto);
				
	//댓글 삭제을 위한 설계
	public int remove(smsReplyDTO rdto);
}
