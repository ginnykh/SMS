/**
 * 
 */

var id = false;
var idCheck = false;
var pw = false;
var pwCheck = false;
var pwc = false;
var name = false;
var num = false;
var numCheck = false;

$(document).ready(function(){

	$("#target").ready(function(){
		
		 var id = $('#id').val();
		 var pw = $('#pass').val();
		 var pwc = $('#compare').val();
		 var name = $('#name').val();
		 var num = $('#num').val();
		
	})
	
	// 아이디 유효성 검사
	if(id == ""){
		idMsg.innerHTML = "아이디를 입력해주세요.";
	    idMsg.style.color = "red";
        idCheck = false;
	    console.log(id);
    }else{
    	idMsg.innerHTML = "입력하였습니다.";
  	  	idMsg.style.color = "blue";
        idCheck = true;
    }
	
	/* 비밀번호 유효성 검사 */
	if(pw == ""){
		passMsg.innerHTML = "비밀번호를 입력해주세요."
		passMsg.style.color = "red";
		pwCheck = false;
	}else{
		passMsg.innerHTML = "입력하였습니다.";
	    passMsg.style.color = "blue";
		pwCheck = true;
	}
	
	/* 비밀번호 확인 유효성 검사 */
	if(pwc == ""){
		compareMsg.innerHTML = "비밀번호 확인을 입력해주세요."
		compareMsg.style.color = "red";
		pwckCheck = false;
	}else{
		compareMsg.innerHTML = "입력하였습니다.";
	    compareMsg.style.color = "blue";
		pwckCheck = true;
	}
	
	/* 이름 유효성 검사 */
	if(name == ""){
		nameMsg.innerHTML = "이름을 입력해주세요.";
		nameMsg.style.color = "red";
		nameCheck = false;
	}else{
		nameMsg.innerHTML = "입력하였습니다";
		nameMsg.style.color = "blue";
		nameCheck = true;
	}		
	
	/* 최종 유효성 검사 */
	if(id&&idCheck&&pw&&pwCheck&&pwc&&name&&num&&numCheck){
		$("#target").attr("action", "/sms/member");
		$("#target").submit();			
	}		
	
	return false;
	
});







//아이디 중복검사
$('.id_input').on("propertychange change keyup paste input", function(){
	/* console.log("keyup 테스트"); */
	
	var memberId = $('#id').val();			// .id_input에 입력되는 값
	var data = {id : id}				// '컨트롤에 넘길 데이터 이름' : '데이터(.id_input에 입력되는 값)'
	
	$.ajax({
		type : "post",
		url : "/member/memberIdChk",
		data : data,
		success : function(result){
			// console.log("성공 여부" + result);
			if(result != 'fail'){
				$('.id_input_re_1').css("display","inline-block");
				$('.id_input_re_2').css("display", "none");	
				idckCheck = true;
			} else {
				$('.id_input_re_2').css("display","inline-block");
				$('.id_input_re_1').css("display", "none");
				idckCheck = false;
			}	
		}// success 종료
	}); // ajax 종료	
});// function 종료


/* 인증번호 이메일 전송 */
$(".mail_check_button").click(function(){
	
	var email = $(".mail_input").val();			// 입력한 이메일
	var cehckBox = $(".mail_check_input");		// 인증번호 입력란
	var boxWrap = $(".mail_check_input_box");	// 인증번호 입력란 박스
	var warnMsg = $(".mail_input_box_warn");	// 이메일 입력 경고글
	
	/* 이메일 형식 유효성 검사 */
	if(mailFormCheck(email)){
		warnMsg.html("이메일이 전송 되었습니다. 이메일을 확인해주세요.");
		warnMsg.css("display", "inline-block");
	} else {
		warnMsg.html("올바르지 못한 이메일 형식입니다.");
		warnMsg.css("display", "inline-block");
		return false;
	}	
	
	$.ajax({
		
		type:"GET",
		url:"mailCheck?email=" + email,
		success:function(data){
			
			//console.log("data : " + data);
			cehckBox.attr("disabled",false);
			boxWrap.attr("id", "mail_check_input_box_true");
			code = data;
			
		}
				
	});
	
});

/* 비밀번호 확인 일치 유효성 검사 */
$('.pwck_input').on("propertychange change keyup paste input", function(){
	
	var pw = $('.pw_input').val();
	var pwck = $('.pwck_input').val();
	$('.final_pwck_ck').css('display', 'none');
	
	if(pw == pwck){
		$('.pwck_input_re_1').css('display','block');
		$('.pwck_input_re_2').css('display','none');
		pwckcorCheck = true;
	}else{
		$('.pwck_input_re_1').css('display','none');
		$('.pwck_input_re_2').css('display','block');
		pwckcorCheck = false;
	}
	
	
});