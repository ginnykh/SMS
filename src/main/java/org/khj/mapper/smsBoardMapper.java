package org.khj.mapper;

import java.util.ArrayList;

import org.khj.domain.Criteria;
import org.khj.domain.smsBoardDTO;
import org.khj.domain.smsItemDTO;
import org.khj.domain.smsStoreDTO;

public interface smsBoardMapper {
	
	// 게시판 글쓰기
	public void write(smsBoardDTO board);                 
	public void insertSelectKey(smsBoardDTO board);
	
	//게시판 목록리스트
	public ArrayList<smsBoardDTO> list(Criteria cri);
	//게시판 페이징에 쓰일 전체 페이지 갯수
	public int getTotalCount(Criteria cri);
		
	//게시판 목록리스트와 관련된 db작업
	public smsBoardDTO detail(smsBoardDTO board);
	public void cntupdate(smsBoardDTO board);
	
	// 게시판 이전글
	public smsBoardDTO detailPrev(smsBoardDTO board);
	
	// 게시판 다음글
	public smsBoardDTO detailNext(smsBoardDTO board);
	
	//글수정과 관련 있는 db작업
	public void modify(smsBoardDTO board);
	
	//게시판 삭제와 관련되 db작업
	public void remove(smsBoardDTO board);

}
