package org.khj.service;

import java.util.ArrayList;

import org.khj.domain.Criteria;
import org.khj.domain.smsAttachFileDTO;
import org.khj.domain.smsBoardDTO;
import org.khj.domain.smsItemDTO;

public interface smsBoardService {

	// 게시판 글쓰기
	public void write(smsBoardDTO board);
	public ArrayList<smsAttachFileDTO> fileList(int bno);
	
	// 게시판 목록리스트
	public ArrayList<smsBoardDTO> list(Criteria cri);

	//게시판 페이징에 쓰일 전체 페이지 갯수
	public int getTotalCount(Criteria cri);
	
	// 게시판 목록리스트에서 제목을 클릭했을 때 내용이 나오는 상세페이지
	public smsBoardDTO detail(smsBoardDTO board);
	
	// 게시판 이전글
	public smsBoardDTO detailPrev(smsBoardDTO board);
		
	// 게시판 다음글
	public smsBoardDTO detailNext(smsBoardDTO board);
	
	//게시판 수정
	public void modify(smsBoardDTO board);
	
	//게시판 삭제
	public void remove(smsBoardDTO board);
	
	// 아이템 목록
	public ArrayList<smsItemDTO> itemList();

	public smsItemDTO itemDetail(smsItemDTO item);
	
	public ArrayList<smsItemDTO> scoups();
	
	public ArrayList<smsItemDTO> shoes();
	
	public void itemInsert(smsItemDTO item);
	
	public void deleteItem(smsItemDTO item);

}
