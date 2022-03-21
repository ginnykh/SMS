package org.khj.mapper;

import java.util.ArrayList;

import org.khj.domain.smsReplyDTO;

public interface smsReplyMapper {
	
	public int write(smsReplyDTO rdto);
	
	//게시판 댓글 리스트 값을 가지고오기위한 설계
	public ArrayList<smsReplyDTO> list(int bno);

	//모달창에 댓글 내용을 가져오기위한 설계
	public smsReplyDTO detail(int rno);
		
	//댓글 수정을 위해 댓글의 정보를 가지고오기위한 설계를 
	public int update(smsReplyDTO rdto);
		
	//댓글 삭제을 위해 정보를 가지고오기위한 설계를 
	public int remove(smsReplyDTO rdto);
	
}
