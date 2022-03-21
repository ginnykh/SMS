$(document).ready(function(){
	
	// 파일의 크기와 확장자를 검사하는 함수 선언
	// 서버에서 설정해 놓은 파일크기 설정
	var maxSize = 5242880; // 5MB
	// 서버에서 허용 가능한 확장자 설정
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$")
	
	function checkExtension( filesize , fileName ){ // ( 파일의 크기, 확장자 )
		// 사용자가 선택한 파일의 크기가 서버에서 설정해놓은 파일의 크기보다 이상이면, 
		if( filesize >= maxSize ) { // ( 서버에서 선택한 파일 크기 >= 서버에서 설정해 놓은 파일크기 )
			alert("파일 사이즈 초과")
			return false;
			
		} // 사용자가 선택한 파일의 확장자가 서버에서 설정해 놓은 퍼아의 확장자와 일치하면
		if(regex.test(fileName)){
			alert("해당 종류의 파일은 업로드 할 수 없습니다.")
			return false;
		} 
		return true;
	}
	
	var formObj = $("form[role='form']")
	
	// 글쓰기 버튼을 클릭하면
	$("input[type='submit']").on("click", function(e){
		e.preventDefault();
		var str="";
		
		// li 태그에 있는
		$("#uploadResult ul li").each(function(i,obj){
			console.log(obj);

			str += "<input type = 'hidden' name = 'fileName' value = '" + $(obj).data("filename") + "'>" // 이전에는 확인하기 위해 text를 사용했지만 사용자에게는 보여주지 않기 위해 hidden으로 변경
			str += "<input type = 'hidden' name = 'uuid' value = '" + $(obj).data("uuid") + "'>"
			str += "<input type = 'hidden' name = 'uploadPath' value = '" + $(obj).data("path") + "'>"
			str += "<input type = 'hidden' name = 'image' value = '" + $(obj).data("type") + "'>"
		})
		formObj.append(str).submit(); // html은 덮어쓰기, append는 밑에 추가 / append함과 동시에 submit
	
		
	})
	
	// 파일 선택의 내용이 변경되면
	$("input[type = 'file']").on("change",function(e){

		var formData = new FormData();
		var inputFile = $("input[name='uploadFile']");
		var files = inputFile[0].files;
		console.log(files);
		
		for(var i = 0; i < files.length; i++){
			// 파일의 크기가 이상이면
			if(!checkExtension(files[i].size)){
				// 밑에 있는것 실행 금지
				return false;
			}
			formData.append("uploadFile", files[i]);
		}
		
		// ajax를 이용해서
		// formData 자체를 데이터로 전송하고, 
		// formData를 데이터로 전송할 때에는
		// processData와 contentType은 반드시 false여야 함.
		
		$.ajax({
			url : "/uploadAjaxAction",
			type : "post",
			data : formData,
			processData : false, 
			contentType : false,
			success : function(result){ // 사용자가 선택한 파일을 원하는 경로에 성공적으로 업로드 한 후
				// showUploadedFile함수 호출
				showUploadedFile(result);
			}
		}) // $.ajax 끝
		
	}) 
		
}) // $(document).ready(function(){ 끝

// "사용자가 선택한 파일을 원하는 경로에 성공적으로 업로드 한 후 웹브라우저에 파일을 띄워라"에 대한 함수 선언 ( showUploadFile )
function showUploadedFile(uploadResultArr){
	var str = "";
	$(uploadResultArr).each(function(i,obj){
		console.log(obj);
		if(!obj.image) { // 사용자가 업로드한 파일의 타입이 이미지가 아니면(excel 문서 파일, ppt파일),
			var fileCallPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName)
			str += "<li data-path='" + obj.uploadPath + "'";
			str += "data-uuid='" + obj.uuid + "'data-filename = '" + obj.fileName + "'data-type='" + obj.image + "'>";
			str += "<a href = '/download?fileName=" + fileCallPath + "'>" + obj.fileName + "</a></li>"
		}else { // 사용자가 업르도한 파일의 타입이 이미지이면(.jpg, .png, .gif),
			var fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName)
			// console.log(fileCallPath);
			// img 태그를 사용해서 웹브라우저 이미지 출력
			str += "<li data-path='" + obj.uploadPath + "'";
			str += "data-uuid='" + obj.uuid + "'data-filename = '" + obj.fileName + "'data-type='" + obj.image + "'>";
			str += "<img src = '/display?fileName=" + fileCallPath + "'></li>"
		}
		
	})
	$("#uploadResult ul").html(str)
}
