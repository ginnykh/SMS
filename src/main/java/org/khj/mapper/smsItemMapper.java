package org.khj.mapper;

import java.util.ArrayList;

import org.khj.domain.Criteria;
import org.khj.domain.smsItemDTO;

public interface smsItemMapper {

	public void itemInsert(smsItemDTO item);
	
	// 아이템 목록
	public ArrayList<smsItemDTO> item();
		
	public smsItemDTO itemDetail(smsItemDTO item);
		
	public ArrayList<smsItemDTO> scoups();
		
	public ArrayList<smsItemDTO> shoes();
	
	public void deleteItem(smsItemDTO item);

}
