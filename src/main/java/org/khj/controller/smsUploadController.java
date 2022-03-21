package org.khj.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.khj.domain.smsAttachFileDTO;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class smsUploadController {
	
	@GetMapping("upload")
	public void uploadForm() {
		System.out.println("파일 업로드 화면");
	}
	
	@GetMapping("uploadAjax")
	public void uploadAjaxForm() {
		System.out.println("파일 업로드 화면");
	}
	
	// upload.jsp에서 form태그를 이용해 파일 업로드 controller
	@PostMapping("uploadAction")
	public void uploadAction(MultipartFile[] uploadFile) {
		
		// 파일업로드 할 경로지정
		String uploadFolder = "C:\\Users\\GreenArt\\Desktop\\SMS\\upload";

		
		for(MultipartFile multipartFile : uploadFile) {
			
			// 사용자가 업로드한 실제 파일 이름
			System.out.println("업로드 파일 이름 = " + multipartFile.getOriginalFilename());
			// 사용자가 업로드한 실제 파일의 크기
			System.out.println("업로드 파일 크기 = " + multipartFile.getSize());
			// 사용자가 업로드한 실제 파일의 형식
			System.out.println("업로드 파일 형식 = " + multipartFile.getContentType());
			// 사용자가 업로드한 실제 파일 이름
			
			// uploadFolder에 저장되어 있는 경로로 실제 파일명 저장.
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			
			try {
				// saveFile변수에 저장되어 있는 폴더명으로 파일을 보내라
				multipartFile.transferTo(saveFile);
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		} // for문 끝
		
		
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
	public ResponseEntity<ArrayList<smsAttachFileDTO>> uploadAjaxAction(MultipartFile[] uploadFile) {
		// AttachFileDTO에 저장되는 값이 여러파일에 대한 값이면 배열로 처리가 되어야 하므로 ArrayList타입이 되어야 함
		ArrayList<smsAttachFileDTO> list = new ArrayList();
		
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
			smsAttachFileDTO attachdto = new smsAttachFileDTO();
			
			// 사용자가 업로드한 실제 파일 이름
			System.out.println("업로드 파일 이름 = " + multipartFile.getOriginalFilename());
			// 사용자가 업로드한 실제 파일의 크기
			System.out.println("업로드 파일 크기 = " + multipartFile.getSize());
			// 사용자가 업로드한 실제 파일의 형식
			System.out.println("업로드 파일 형식 = " + multipartFile.getContentType());
			// 사용자가 업로드한 실제 파일 이름
			String uploadFileName = multipartFile.getOriginalFilename();
			
			// 실제 파일명을(uploadFileName)을 AttachFileDTO 클래스의 fileName에 저장 
			attachdto.setFileName(uploadFileName);
			
			// 중복이 되지않는 임의의 문자열을 생성
			UUID uuid = UUID.randomUUID();
			
			// uuid값(uploadFileName)을 AttachFileDTO 클래스의 fileName에 저장 
			attachdto.setUuid(uuid.toString());
			
			// UUID + "_" + getOriginalFileName()의 조합으로  파일명을 생성
			uploadFileName = uuid.toString()+"_"+uploadFileName;
			
			
			// uploadFolder에 저장되어 있는 경로로 실제 파일명 저장.
			File saveFile = new File(uploadPath, uploadFileName);
			
			try {
				// saveFile변수에 저장되어 있는 폴더명으로 파일을 보내라.
				multipartFile.transferTo(saveFile);
				// 실제 업로드경로 ( uploadFolderPath )를 AttachFileDTO클래스 (attachdto)에 uploadPath에 저장 (setUploadPath) -> 굳이 try안에 넣을 필요 없고 for 안에만 들어가있으면 됨
				attachdto.setUploadPath(uploadFolderPath);
				// uuid값(UUID)을 AttachFileDTO클래스(attachdto)에 uploadPath에 저장(setUuid)
				attachdto.setUuid(uuid.toString());
				
				// 이미지 파일이면
				if(checkImage(saveFile)) {
					// FileType값(uploadFileName)을 AttachFileDTO 클래스에 uploadPath에 저장 (setImage)
					attachdto.setImage(true);
				
					
					// 썸네일 파일을 생성하기 전에 썸네일 파일을  추출
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_"+uploadFileName));
					// 썸네일 파일을 생성함
					Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnail,100,100);
					// 썸네일 종료 ( 메모리 공간 회수 )
					thumbnail.close();
				}
				
				list.add(attachdto);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		} // for문 
		// 통신상태가 정상적(HttpStatus.OK)이면 ArrayList에 저장되어 있는 값을 uploadAjax.js에 있는 ajax에 success로 보내라
		return new ResponseEntity<>(list,HttpStatus.OK);
	
	}
	
	// 파일 업로드한 파일 타입이 이미지일 때(.jpg, .png, .gif) 웹 브라우저에 이미지를 띄우기 위해
	@GetMapping("display")
	public ResponseEntity<byte[]> getFile(String fileName) { // getFile()은 문자열로 파일의 경로가 포함된 fileName을 매개변수 받고 byte[](이진수)를 전송
		System.out.println("url 주소를 통한 fileName = " + fileName);
		File file = new File("C:\\Users\\GreenArt\\Desktop\\SMS\\upload\\"+fileName);
		System.out.println("file = " + file);
		
		ResponseEntity<byte[]> result = null;
		
		// byte[]로 이미지 파일의 데이터를 전송할 때 브라우저에 보내는 MIME타입이 파일의 종류(jpg, png, xls, ppt)에 따라 달라짐
		// 이 부분을 해결하기 위해서 probeContentType()를 이용해서 적절한 MIME 타입 데이터를 Http의 헤더 메세지에 포함할 수 있도록 처리
		try {
			HttpHeaders header = new HttpHeaders();
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),header,HttpStatus.OK);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 파일업로드 한 파일타입이 이미지가 아닐때 (.xls, .ppt, .txt) 웹브라우저를 통해서 download 할 수 있도록
	// 댓글쓰기를 하기 위한 RequestMapping
	// Mapping을 할때 우리가 원하는 데이터 타입을 강제함으로써 오류상황을 줄일 수 있다.
	// consumes : 들어오는 데이터 타입 정의 ( 생략  가능 )
	// produces : 반환하는 데이터 타입 정의 ( 생략 가능 )
	// * 생략을 하게 되면, 웹브라우저가 알아서 타입을 판단 *
	// "웹 브라우저가 이 파일은  download해야 하는 파일입니다." 라는 것을 인지할 수 있도록 반환이 되어야 함
	// 그러기 위해서는 APPLICATION_OCTET_STREAM_VALUE 타입으로 반환데이터 타입을 선언
	@GetMapping(value = "download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> downloadFile(String fileName){
		System.out.println("download = " + fileName);
		
		Resource resource = new FileSystemResource("C:\\Users\\GreenArt\\Desktop\\SMS\\upload\\" + fileName);
		System.out.println("download resource = " + resource);
		
		String resourceName = resource.getFilename();
		HttpHeaders header = new HttpHeaders();
		try {
			header.add("Content-Disposition", "attachment; filename = " + new String(resourceName.getBytes("UTF-8"),"ISO-8859-1"));
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
		
	}

}
