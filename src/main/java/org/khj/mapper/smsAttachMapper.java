package org.khj.mapper;

import java.util.ArrayList;

import org.khj.domain.smsAttachFileDTO;

public interface smsAttachMapper {
	
	// 게시판 글쓰기 할때 파일과 관련되어 있는 attach테이블에 insert
	public void insert(smsAttachFileDTO board);
	// 게시판 상세페이지에 업로드된 이미지를 부리기위한 데이터 list
	public ArrayList<smsAttachFileDTO> fileList(int bno);
	
}
