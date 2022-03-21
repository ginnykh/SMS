/**
 * 
 */

$(document).ready(function(){
	// bno값
	var bno=$(".bnonum").html();
	// 상세페이지가 시작되자마자 이미지를 출력하기 위한 ajax
	$.getJSON("/sms/fileList/"+bno+".json",
			function(data){ // BoardController에 있는 fielList를 통해 얻어진 select결과를 저장한 후,
		// detail.jsp에 뿌리기
		console.log(data)
		var str = "";
		$(data).each(function(i, obj){
			if(!obj.image) { // 사용자가 업로드한 파일의 타입이 이미지가 아니면(excel 문서 파일, ppt파일),
				var fileCallPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName)
				str += "<li data-path='" + obj.uploadPath + "'";
				str += "data-uuid='" + obj.uuid + "'data-filename = '" + obj.fileName + "'data-type='" + obj.image + "'>";
				str += "<a href = '/download?fileName=" + fileCallPath + "'>" + obj.fileName + "</a></li>"
			} else { // 사용자가 업르도한 파일의 타입이 이미지이면(.jpg, .png, .gif),
				var fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName)
				// console.log(fileCallPath);
				// img 태그를 사용해서 웹브라우저 이미지 출력
				str += "<li data-path='" + obj.uploadPath + "'";
				str += "data-uuid='" + obj.uuid + "'data-filename = '" + obj.fileName + "'data-type='" + obj.image + "'>";
				str += "<img src = '/display?fileName=" + fileCallPath + "'></li>"
			}
			
		})
		$("#uploadResult ul").html(str)
		
	})

}) 







