let t = document.querySelector("#target")
let name = document.querySelector("#name");
let id = document.querySelector("#id");
let idMsg = document.querySelector("#idMsg");
let pass = document.querySelector("#pass");
let passMsg = document.querySelector("#passMsg");
let compare = document.querySelector("#compare");
let num = document.querySelector("#num");
let num_btn = document.querySelector("#num_btn");
let passNum = document.querySelector("#passNum");
let comfirmId = document.querySelector("#confirmId");
// var num = /^[0-9]+/g;

name.onchange= checkName;
id.onchange = checkId;
pass.onchange = checkPw;
compare.onchange = comparePw;
num.onchange = checkNum;

function checkName(){
	if(name.value.length > 20){
		nameMsg.innerHTML = "이름의 길이를20자 이하로 만들어 주세요.";
		nameMsg.style.color = "red";
	  }else {
		  nameMsg.innerHTML = "입력하였습니다.";
		  nameMsg.style.color = "blue";
	  } 
}

function checkId(){
  if(id.value.length < 8 || id.value.length > 12){
    idMsg.innerHTML = "아이디의 길이를 8자 이상 12자 이하로 만들어 주세요.";
    idMsg.style.color = "red";
    userId.select();
    userId.focus();
  }else {
	  idMsg.innerHTML = "입력하였습니다.";
	  idMsg.style.color = "blue";
  }
}

function checkPw(){
  if(pass.value.length < 8 || pass.value.length > 12){
    passMsg.innerHTML = "비밀번호 길이를 8자 이상 12자 이하로 만들어 주세요."
    passMsg.style.color = "red";
    pass.value = "";
    pass.focus();
  } else {
    passMsg.innerHTML = "입력하였습니다.";
    passMsg.style.color = "blue";
  }
}

function comparePw(){
  if(pass.value != compare.value){
    compareMsg.innerHTML = "비밀번호가 다릅니다. 다시 확인해주세요."
    compareMsg.style.color = "red";
    compare.value = "";
    compare.focus();
    console.log(compare.value);
  } else {
    compareMsg.innerHTML = "비밀번호가 일치합니다.";
    compareMsg.style.color = "blue";
  }
}

function checkNum(){
	if(num.value.length >= 13){
		numMsg.innerHTML = "숫자만 입력할 수 있습니다."
		numMsg.style.color = "red";
	  } else {
		numMsg.innerHTML = "입력하였습니다.";
		numMsg.style.color = "blue";
	  }
}

num_btn.addEventListener("click",function(){
	if(num.value != null){
		phoneNum = Math.floor(Math.random()*99999); 
		alert("인증번호가 발송되었습니다.");
		passNum.value = phoneNum;
	}
 
})



t.addEventListener("click",function(){
	
	// 이름 유효성 검사
	if(name.value.length == 0){
		nameMsg.innerHTML = "이름을 입력해주세요.";
		nameMsg.style.color = "red";
		return false;
	}else {
		nameMsg.innerHTML = "입력하였습니다";
		nameMsg.style.color = "blue";
	}
	
	// 아이디 유효성 검사
	if(id.value.length == 0){
		idMsg.innerHTML = "아이디를 입력해주세요.";
	    idMsg.style.color = "red";
	    return false;
    }else{
    	idMsg.innerHTML = "입력하였습니다.";
  	  	idMsg.style.color = "blue";
    }
	
	// 비밀번호 유효성 검사
	if(pass.value.length == 0){
	    passMsg.innerHTML = "비밀번호를 입력해주세요."
	    passMsg.style.color = "red";
	    return false;
	} else {
	  passMsg.innerHTML = "입력하였습니다.";
      passMsg.style.color = "blue";
    }
		
	// 비밀번호 확인 유효성 검사
	if(compare.value.length == 0){
		compareMsg.innerHTML = "비밀번호 확인을 입력해주세요."
		compareMsg.style.color = "red";
		return false;
	}else {
		compareMsg.innerHTML = "입력하였습니다.";
	    compareMsg.style.color = "blue";
	}
	
	// 휴대폰 번호 유효성 검사
	if(num.value.length == 0){
		numMsg.innerHTML = "전화번호를 입력해주세요.";
		numMsg.style.color = "red";
		return false;
	}else{
		numMsg.innerHTML = "입력하였습니다.";
		numMsg.style.color = "blue";
	}
	
	// 인증번호 유효성 검사
	if(passNum.value.length == 0){
		confirmMsg.innerHTML = "인증번호를 입력해주세요.";
		confirmMsg.style.color = "red";
		return false;
	}else{
		confirmMsg.innerHTML = "입력하였습니다.";
		confirmMsg.style.color = "blue";
	}
	
});

$("#log").click(function(){

	$("#target").attr("action", "/sms/member");
    $("#target").submit();
        
});


$("#confirmId").on("click", function() {

	var data = {id : id}
	
	$.ajax({
		type : "post",
		url : "/sms/confirmId",
		data : data,
		success : function(result){
			 console.log("성공 여부" + result);
			if(result != 'fail'){
				nameMsg.innerHTML = "입력하였습니다";
				nameMsg.style.color = "blue";
				idckCheck = true;
			} else {
				idMsg.innerHTML = "이미 사용중인 아이디입니다.";
			    idMsg.style.color = "red";
				idckCheck = false;
			}	
		}// success 종료
	}); // ajax 종료	
	
});


