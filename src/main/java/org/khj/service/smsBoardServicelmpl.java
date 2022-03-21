package org.khj.service;

import java.util.ArrayList;

import org.khj.domain.Criteria;
import org.khj.domain.smsAttachFileDTO;
import org.khj.domain.smsBoardDTO;
import org.khj.domain.smsItemDTO;
import org.khj.domain.smsStoreDTO;
import org.khj.mapper.smsAttachMapper;
import org.khj.mapper.smsBoardMapper;
import org.khj.mapper.smsItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class smsBoardServicelmpl implements smsBoardService{

	@Autowired
	private smsBoardMapper sMapper;
	@Autowired
	private smsAttachMapper aMapper;
	@Autowired
	private smsItemMapper iMapper;

	@Transactional
	// 게시판 글쓰기
	public void write(smsBoardDTO board) {
		sMapper.insertSelectKey(board);
		board.getAttachList().forEach(attach->{
			attach.setBno(board.getBno());
			aMapper.insert(attach);
			
		});
	}
	
	//게시판 목록리스트
	public ArrayList<smsBoardDTO> list(Criteria cri) {
		return sMapper.list(cri);          
	}
	
	@Transactional
	public int getTotalCount(Criteria cri) {
		return sMapper.getTotalCount(cri);
	}
	
	@Transactional
	public smsBoardDTO detail(smsBoardDTO board) { 
		// board테이블의 조회수 속성에  + 1
		sMapper.cntupdate(board);
		// 상세페이지 select
		return sMapper.detail(board);
	}
	
	// 게시판 이전글
	public smsBoardDTO detailPrev(smsBoardDTO board) {
		return sMapper.detailPrev(board);
	}
	
	// 게시판 다음글
		public smsBoardDTO detailNext(smsBoardDTO board) {
		return sMapper.detailNext(board);
	}
	
	//게시판 수정페이지 설계를 구현
	public void modify(smsBoardDTO board) {
		sMapper.modify(board);
	}
	
	//게시판 글 삭제에 대한 설계를 구현
	public void remove(smsBoardDTO board) {
		sMapper.remove(board);
	}
	
	// 아이템 목록
	@Override
	public ArrayList<smsItemDTO> itemList(){
		return iMapper.item();
	}

	public smsItemDTO itemDetail(smsItemDTO item) { 
		return iMapper.itemDetail(item);
	}
	
	@Override
	public ArrayList<smsItemDTO> scoups(){
		return iMapper.scoups();
	}
	
	@Override
	public ArrayList<smsItemDTO> shoes(){
		return iMapper.shoes();
	}
	
	public void itemInsert(smsItemDTO item) {
		iMapper.itemInsert(item);	
	}
	
	public void deleteItem(smsItemDTO item) {
		iMapper.deleteItem(item);
	}
	
	public ArrayList<smsAttachFileDTO> fileList(int bno){
		return aMapper.fileList(bno);	
	}

}
