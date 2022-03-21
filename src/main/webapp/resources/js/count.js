var ta = document.querySelector("#target")
var t = document.querySelector("#text")
var tCount = document.querySelector("#tCount")



// tCount.onchange = checkTitle;

// function checkTitle(){
//   if(tCount.value.length>100 || tCount.value.length ==""){
//     alert("제목을 100글자 내로 입력해주세요.");
//     checkTitle.focus();
//   }  
// }
// function checkMain(){
//   if(mainText.value.length == 0){
//     alert("내용을 입력해주세요.");
//     location.reload();
//   }
// }
t.addEventListener("keyup", function(){
  countT.innerHTML = text.value.length
})
tCount.addEventListener("keyup", function(){
  countTi.innerHTML = tCount.value.length
})

ta.addEventListener("submit", function(){
  

  if(tCount.value.length == "" || tCount.value.length >100){
    alert("제목을 100자 내로 입력해주세요.")
  } else if(t.value.length == "" || t.value.length >2000){
    alert("내용을 2000자 내로 입력해주세요.")
  }

})


