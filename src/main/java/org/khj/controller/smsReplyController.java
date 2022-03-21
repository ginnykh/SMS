package org.khj.controller;

import java.util.ArrayList;

import org.khj.domain.smsReplyDTO;
import org.khj.service.smsReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("replies")

public class smsReplyController {
	
	@Autowired
	private smsReplyService rservice;
	
	@PostMapping(value = "new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody smsReplyDTO rdto){
		// insert 성공시 ReplyMapper.xml로 부터 1
		// insert 실패시 ReplyMapper.xml로 부터 0
		int result = rservice.write(rdto); 
		return result == 1?new ResponseEntity<>("success",HttpStatus.OK) // insert가 정상적으로 처리되었을 때, 
		:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // insert가 비정상적으로 처리되었을 때,
	}
	
	@GetMapping(value="list/{bno}", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ArrayList<smsReplyDTO>> getList(@PathVariable int bno){
		return new ResponseEntity<>(rservice.list(bno), HttpStatus.OK);
	}
	
	// 댓글수정을 하기위해 댓글내용 가져오기
	@GetMapping(value="{rno}", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<smsReplyDTO> getDetail(@PathVariable int rno){
		return new ResponseEntity<>(rservice.detail(rno), HttpStatus.OK);
	}
	
	@PutMapping(value="update",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> update(@RequestBody smsReplyDTO rdto){
		return rservice.update(rdto)==1?new ResponseEntity<>("success", HttpStatus.OK)
		:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping(value="remove",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@RequestBody smsReplyDTO rdto){ 
		return rservice.remove(rdto)==1?new ResponseEntity<>("success", HttpStatus.OK)
		:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
