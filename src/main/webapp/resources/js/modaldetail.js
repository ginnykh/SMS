$(document).ready(function() {
	
	// bno값
	var bno = $("#b").html();
	
	//상세페이지가 실행되면 댓글 글쓰기 버튼활성화
	$("#modalRegisterBtn").show(); 
	//댓글 글수정버튼 활성화
	$("#modalModBtn").show(); 
	//댓글 글삭제버튼 활성화
	$("#modalRemoveBtn").show(); 

	// 댓글쓰기 버튼을 클릭하면
	$("#myBtn").on("click", function() {
		// 사용자가 입력한 댓글 내용을 저장
		var reply = $("input[name='reply']").val("")
		// 로그인한 이름을 댓글작성자로 저장
//		var replyer = $("input[name='replyer']").val("")
		var replyer=$("#replyer").val();
		$("input[name='replyer']").val(replyer);
		//댓글 등록 버튼활성화
		$("#modalRegisterBtn").show(); 
		//댓글 글수정버튼 비활성화
		$("#modalModBtn").hide(); 
		//댓글 글삭제버튼 비활성화
		$("#modalRemoveBtn").hide(); 

		
	});
	
	
	

	showList();
	function showList() {
		// detail.jsp가 실행되자마자 댓글목록리스트가 실행
		smsReplyService.getList({
			bno : bno
		}, function(list) {
			// 변수:값
			console.log(list);
			var str = " ";
			for (var i = 0; i < list.length; i++) {
			
				str += "<li class='replyli' data-rno='"+list[i].rno+"'><div><b>" + list[i].replyer + "</b></div>"
				str += "<div>" + list[i].reply + "</div><div class='replydate'>"+list[i].replydate+"</div>"
				str += "</li>";

			}
			
			// getList가 실행될때
			$("#reList").html(str);

		});
	}

	// console.log(smsReplyService); //smsReplyService 함수호출 -> return값을 콘솔에 호출
	// 댓글쓰기 버튼(id값이 modalRegisterBtn)을 클릭하면
	$("#modalRegisterBtn").on("click", function() {
		// 사용자가 입력한 댓글 내용을 저장
		var reply = $("input[name='reply']").val()
		// 사용자가 입력한 댓글작성자를 저장
		var replyer = $("input[name='replyer']").val()
		// ajax로 보내고자하는 json타입
		
		smsReplyService.add({
			reply : reply,
			replyer : replyer,
			bno : bno
		},
		// callback함수호츨
		function(result) {
			//alert("insert 작업 : " + result)
			// 목록리스트 새로고침
			showList();

		}

		);
		// 모달창을 숨김
		$(".modal").hide();
	})//모달창 안에 댓글쓰기버튼 $("#modalRegisterBtn").on("click", function() 종료
	
	//댓글내용을 클릭하면
	$("#reList").on("click","li",function(){ // 범위가 #reList의 ul인 것에서 li로 축소시킨다.
		
		//rno값을 가져오기
		var rno=($(this).data("rno"));
		
		
		// 호출의 경우 ready안에 있어야 한다. 
		   
		smsReplyService.reDetail(rno,function(detail){
			
			console.log(detail);
			$("input[name='rno']").val(detail.rno)
			$("input[name='replyer']").val(detail.replyer)
			$("input[name='reply']").val(detail.reply)
			
			//댓글쓰기 버튼 비활성
			$("#modalRegisterBtn").hide(); 
			//댓글 글수정버튼 활성화
			$("#modalModBtn").show(); 
			//댓글 글삭제버튼 활성화
			$("#modalRemoveBtn").show(); 
			//모달창을 띄워라
			$(".modal").show();
		})
		
		
	})
	
	
	//댓글 수정함수를 호출해서 처리
	//댓글 수정버튼을 클릭하면
	$("#modalModBtn").on("click",function(){
		
		var reply={rno:$("input[name='rno']").val(),reply:$("input[name='reply']").val()}  //위에 함수 선언을 제이슨 타입으로 받기에 제이슨 타입으로 선언
		
		//댓글 수정함수를 호출해서 처리
		smsReplyService.reupdate(reply,function(update){
			//콜백영역(update가 정상적으로 처리된 후 조치)
			
			//modal창을 닫고 목록리스트 실행
			$(".modal").hide();
			showList();
		})
		
	})

	
	//댓글 삭제함수를 호출해서 처리
	//댓글 삭제버튼을 클릭하면
	$("#modalRemoveBtn").on("click",function(){
		//해당되는 댓글 번호만 삭제하면 됨
		var reply={rno:$("input[name='rno']").val()}
		  
		//댓글 삭제함수를 호출해서 처리
		smsReplyService.remove(reply,function(remove){
			//콜백영역(update가 정상적으로 처리된 후 조치)
			
			//modal창을 닫고 목록리스트 실행
			$(".modal").hide();
			showList();
		})
		
	})
	
	
	
	
	
	
	
	
	
	
	
	
	

}) // $(document).ready(function() { 종료




//------------------------------------함수 선언부----------------------------------------------




var smsReplyService = (function() { // smsReplyService함수 선언
	// 댓글쓰기를 하기위한 함수 선언
	function add(reply, callback) {
		console.log("reply........")
		$.ajax({
			url : "/replies/new",
			type : "post",
			data : JSON.stringify(reply), // JSON.stringify : 자바스크립트의 값을 JSON
			// 문자열로 변환
			contentType : "application/json;charset=utf-8",
			success : function(result) { // 통신이 정상적으로 성공했을때
				// callback함수선언
				// 만약에 callback이 있으면
				if (callback)
					// callback 함수를 호출해라
					callback(result);
			},
			error : function() { // 통신이 비정상적으로 처리가 되어 error가 있으면
			}
		})
	}
	
	
	
	
	// 댓글 목록리스트를 하기위한 함수 선언
	function getList(param, callback) { // type이 get일때 사용
		var bno = param.bno;
		console.log(bno);

		$.getJSON("/replies/list/" + bno + ".json", // json type으로
		function(data) {
			if (callback)
				callback(data);
		})
		
	}
	
	

	// 댓글 수정을 위해 댓글 내용가져 오기위한 함수선언
	function reDetail(rno, callback){
		var rno = rno;
		$.getJSON("/replies/"+rno+".json",
			function(data) {
			if (callback)
				callback(data);
		})
	}
	// 댓글 수정을 하기위한 함수 선언
	function reupdate(reply, callback){
		$.ajax({
			url : "/replies/update",
			type : "put",
			data : JSON.stringify(reply), 
			contentType : "application/json;charset=utf-8",
			success : function(result) { 	
				if (callback)
					callback(result);
			},
			error : function() { 
			}
		})
	}

	// 댓글 삭제를 하기위한 함수 선언
	function remove(reply, callback){
		$.ajax({
			url : "/replies/remove",
			type : "delete",
			data : JSON.stringify(reply), 
			contentType : "application/json;charset=utf-8",
			success : function(result) { 	
				if (callback)
					callback(result);
			},
			error : function() { 
			}
		})
	}
	
	
	
	
	
	
	
	return {
		add : add,
		getList : getList,
		reDetail : reDetail,
		reupdate : reupdate,
		remove : remove
	};
})()