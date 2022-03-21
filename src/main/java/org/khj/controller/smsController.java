package org.khj.controller;

import java.util.ArrayList;

import org.khj.domain.Criteria;
import org.khj.domain.smsAttachFileDTO;
import org.khj.domain.smsPageDTO;
import org.khj.domain.smsStoreDTO;
import org.khj.domain.smsBoardDTO;
import org.khj.domain.smsItemDTO;
import org.khj.service.smsBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("sms")
public class smsController {
	
	@Autowired
	private smsBoardService service;
	
	// 글쓰기 화면
	@GetMapping("write")
	public void write() {

	}
	
	// 글쓰기 버튼 클릭시 서버로 전송 후 목록
	@PostMapping("write")
	public String writePost(smsBoardDTO board) {
		service.write(board);
		return "redirect:/sms/list";
	}
	
	// 게시판 목록 리스트
	@GetMapping("list")
	public void list(Criteria cri, Model model) {
		model.addAttribute("list", service.list(cri));
		int total = service.getTotalCount(cri);
		model.addAttribute("pageMaker",new smsPageDTO(cri,total));
	}
	
	// 게시판 목록 리스트에서 제목을 클릭하면
	@GetMapping("detail")
	public void detail(smsBoardDTO board,Model model) {
		model.addAttribute("detail",service.detail(board));
		model.addAttribute("detailPrev",service.detailPrev(board));
		model.addAttribute("detailNext",service.detailNext(board));
	}
	
	// 게시판 상세페이지에서 이미지를 출력하기 위한 select된 결과를 javascript로
	@GetMapping(value = "fileList/{bno}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ArrayList<smsAttachFileDTO>> fileList(@PathVariable int bno){
		return new ResponseEntity<>(service.fileList(bno),HttpStatus.OK);
	}
	
	// 글수정 화면으로
	@GetMapping("modify")
	public void modify(smsBoardDTO board, Model model) {
		model.addAttribute("detail", service.detail(board));
	}
	
	//글수정 후 값을 넘겨주는 작업
	@PostMapping("modify")
	public String modifyPost(smsBoardDTO board, RedirectAttributes rttr) {
		service.modify(board);
		rttr.addAttribute("bno", board.getBno());
		return "redirect: /sms/detail";
	}
	
	//글을 삭제하는 작업
	@GetMapping("remove")
	public String remove(smsBoardDTO board) {
		service.remove(board);
		return "redirect: /sms/list";
	}
	
	@GetMapping("main")
	public void main() {
		
	}
	
}
