package org.khj.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.khj.domain.Criteria;
import org.khj.domain.smsItemDTO;
import org.khj.domain.smsPageDTO;
import org.khj.service.smsBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
@RequestMapping("sms")
public class smsItemController {
	
	@Autowired
	private smsBoardService service;
	
	@GetMapping("itemInsert")
	public void itemInsert() {
	}
	
	@PostMapping("itemInsert")
	public String itemInsertPost(smsItemDTO item) {
		System.out.println("itemInsert="+item);
		service.itemInsert(item);
		return "redirect:/sms/date";
	}
	
	@GetMapping("date")
	public void date(Criteria cri, Model model){
		model.addAttribute("item", service.itemList());
	}
	
	@GetMapping("itemDetail")
	public void itemDetail(smsItemDTO item, Model model) {
		model.addAttribute("itemDetail",service.itemDetail(item));
	}
	
	@GetMapping("scoups")
	public void scoups(Model model) {
		model.addAttribute("item", service.scoups());
	}
	
	@GetMapping("shoes")
	public void shoes(Model model) {
		model.addAttribute("item", service.shoes());
	}
	
	@GetMapping("deleteItem")
	public String deleteItem(smsItemDTO item) {
		service.deleteItem(item);
		return "redirect:/sms/date";
	}
	
	
	
	
	@GetMapping("upload")
	public void uploadForm() {
		System.out.println("파일 업로드 화면");
	}
	
	@GetMapping("uploadAjax")
	public void uploadAjaxForm() {
		System.out.println("파일 업로드 화면");
	}
	
	
	
	// 년/월/일 폴더를 생성하기 위한 폴더 이름 추출하여 리턴
	private String getFolder() {
		
		// 현재날짜를 추출
		Date date = new Date();
		// Tue Jan 18 09:35:09 KST 2022 -> 2022-01-18 ( yyyy-mm-dd 형식으로 변경 )
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(date);
		// 2022-01-18 -> 2022\01\18
		return str.replace("-", File.separator);
	}
	
	// 썸네일 이미지 생성을 할 것인지 안 할것인지에 대해 판단하는 메소드 ( 사용자가 업로드 한 파일이 이미지이면 생성, 그렇지 않으면 생성 안 함 )
	private boolean checkImage(File file) {
		try {
			// 파일의 타입을 알아내는 probeContentType메소드 호출하여 사용
			String contentType = Files.probeContentType(file.toPath());
			System.out.println("image="+contentType.startsWith("image"));
			// 그 파일의 타입이 image면 true, 그렇지 않으면 false
			return contentType.startsWith("image");
		} catch (IOException e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	// uploadAjax.jsp에서 ajax를 이용해 파일 업로드 controller
	@PostMapping(value = "uploadAjaxAction",  produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ArrayList<smsItemDTO>> uploadAjaxAction(MultipartFile[] uploadFile) {
		// AttachFileDTO에 저장되는 값이 여러파일에 대한 값이면 배열로 처리가 되어야 하므로 ArrayList타입이 되어야 함
		ArrayList<smsItemDTO> list = new ArrayList();
		
		// 파일업로드 할 경로지정
		String uploadFolder = "C:\\Users\\GreenArt\\Desktop\\SMS\\upload";
		
		
		// 폴더 생성                             (기존폴더,       현재폴더)를 결합
		File uploadPath = new File(uploadFolder, getFolder()); 
		String uploadFolderPath = getFolder();

		System.out.println("uploadPath = " + uploadPath);
		
		// 현재 만드려고 하는 폴더가 없으면
		if(uploadPath.exists()==false) {
			// 폴더 생성
			uploadPath.mkdirs();
		}
		
		
		
		for(MultipartFile multipartFile : uploadFile) {
			
			// UploadController에 있는 uploadAjaxAction에서 AttachFileDTO를 사용해서 값을 저장해야 되는데
			// 이럴경우 UploadController에 AttachFileDTO가 없으면 사용을 할 수가 없음
			// 그래서 UploadController에 AttachFileDTO 포함을 시켜서 사용해야 됨
			smsItemDTO itemdto = new smsItemDTO();
			
			// 사용자가 업로드한 실제 파일 이름
			System.out.println("업로드 파일 이름 = " + multipartFile.getOriginalFilename());
			// 사용자가 업로드한 실제 파일의 크기
			System.out.println("업로드 파일 크기 = " + multipartFile.getSize());
			// 사용자가 업로드한 실제 파일의 형식
			System.out.println("업로드 파일 형식 = " + multipartFile.getContentType());
			// 사용자가 업로드한 실제 파일 이름
			String uploadFileName = multipartFile.getOriginalFilename();
			
			// 실제 파일명을(uploadFileName)을 AttachFileDTO 클래스의 fileName에 저장 
			itemdto.setFileName(uploadFileName);
			
			// 중복이 되지않는 임의의 문자열을 생성
			UUID uuid = UUID.randomUUID();
			
			// uuid값(uploadFileName)을 AttachFileDTO 클래스의 fileName에 저장 
			itemdto.setUuid(uuid.toString());
			
			// UUID + "_" + getOriginalFileName()의 조합으로  파일명을 생성
			uploadFileName = uuid.toString()+"_"+uploadFileName;
			
			
			// uploadFolder에 저장되어 있는 경로로 실제 파일명 저장.
			File saveFile = new File(uploadPath, uploadFileName);
			
			try {
				// saveFile변수에 저장되어 있는 폴더명으로 파일을 보내라.
				multipartFile.transferTo(saveFile);
				// 실제 업로드경로 ( uploadFolderPath )를 AttachFileDTO클래스 (attachdto)에 uploadPath에 저장 (setUploadPath) -> 굳이 try안에 넣을 필요 없고 for 안에만 들어가있으면 됨
				itemdto.setUploadPath(uploadFolderPath);
				// uuid값(UUID)을 AttachFileDTO클래스(attachdto)에 uploadPath에 저장(setUuid)
				itemdto.setUuid(uuid.toString());
				
				// 이미지 파일이면
				if(checkImage(saveFile)) {
					// FileType값(uploadFileName)을 AttachFileDTO 클래스에 uploadPath에 저장 (setImage)
					itemdto.setImage(true);
				
					
					// 썸네일 파일을 생성하기 전에 썸네일 파일을  추출
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_"+uploadFileName));
					// 썸네일 파일을 생성함
					Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnail,100,100);
					// 썸네일 종료 ( 메모리 공간 회수 )
					thumbnail.close();
				}
				
				list.add(itemdto);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		} // for문 
		// 통신상태가 정상적(HttpStatus.OK)이면 ArrayList에 저장되어 있는 값을 uploadAjax.js에 있는 ajax에 success로 보내라
		return new ResponseEntity<>(list,HttpStatus.OK);
	
	}

}
