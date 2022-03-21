<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@400;500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/css/date.css">
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="/resources/css/header.css">
	<link rel="stylesheet" href="/resources/css/footer.css">

</head>
<body>
    <div id="wrap">
	<%@ include file="header.jsp" %> 
        <div id="container">
                <div id="containerIn">
                    <section class="slide">
                        <div class="slide-img">
                            
                        </div>
                    </section>

                    <div class="select">
                        <div class="calender">
                            <p>조회기간을 선택해주세요</p>
                            <p><input type="text" id="datepicker1" readonly name="start"></p>
                            <p><input type="text" id="datepicker2" readonly name="end"></p>
                            <input type="submit" value="조회" class="sub">
                    </div>
                
                        <div class="member">
                            <ul>
                                <li><a href="/sms/scoups">#에스쿱스</a></li>
                                <li><a href="">#정한</a></li>
                                <li><a href="">#조슈아</a></li>
                                <li><a href="">#준</a></li>
                                <li><a href="">#호시</a></li>
                                <li><a href="">#원우</a></li>
                                <li><a href="">#우지</a></li>
                                <li><a href="">#디에잇</a></li>
                                <li><a href="">#민규</a></li>
                                <li><a href="">#도겸</a></li>
                                <li><a href="">#승관</a></li>
                                <li><a href="">#버논</a></li>
                                <li><a href="">#디노</a></li>

                            </ul>
                        </div> <!--member-->
                    </div> <!--select-->
                    

                    <div class="itemFor">
                        <ul>
                            <li><a href="">#상의</a></li>
                            <li><a href="">#하의</a></li>
                            <li><a href="">#모자</a></li>
                            <li><a href="/sms/shoes">#신발</a></li>
                            <li><a href="">#아우터</a></li>
                            <li><a href="">#가방</a></li>
                            <li><a href="">#악세사리</a></li>
                        </ul>
                     </div> <!--itemFor-->
					
					
                    <div class="item">
                    <ul>
                    	<c:forEach items="${item}" var="item">

                            <li>
                                <a href="/sms/itemDetail?ino=${item.ino}">             
                                    <img src="/display?fileName=${item.uploadPath}/${item.uuid}_${item.fileName}" class="thumbnail">  
                                    <p class="description">${item.contents}</p>
                                    <p class="desSize">${item.size}</p>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                    </div> <!--item-->
                    <c:if test = "${login.id=='smsMaster'}">
                        <div class="btn_r"><a href="/sms/itemInsert">상품 등록</a></div>
                    </c:if>
                    
            </div> <!--containerin-->
        </div> <!--container-->
        
         <%@ include file="footer.jsp" %> 
        
    </div> <!--#wrap-->


<script>

    $(function() {
        $("#datepicker1,#datepicker2").datepicker({
            dateFormat: 'yy-mm-dd' //달력 날짜 형태
           ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
           ,showMonthAfterYear:true // 월- 년 순서가아닌 년도 - 월 순서
           ,changeYear: true //option값 년 선택 가능                     
           ,changeMonth: true //option값  월 선택 가능                
           ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
           ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
           ,buttonImageOnly: true //버튼 이미지만 깔끔하게 보이게함
           ,buttonText: "선택" //버튼 호버 텍스트              
           ,yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
           ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
           ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip
           ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
           ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 Tooltip
           ,minDate: "-5Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
           ,maxDate: "+5y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
        });                           
    });
    
    $(function() {
    	  $( "input[name='start']" ).datepicker();
    	  $( "input[name='end']" ).datepicker();
    });
    
	//조회버튼을 클릭하면 
//	$("input[type='submit']").on("click", function(){
//		actionForm.find("input[name='pageNum']");
//		actionForm.submit();
//	});
	
	$(document).ready(function(){

	var actionForm = $("#actionForm")
	//현재페이지 번호를 클릭하면
	$(".atag a").on("click",function(e){
		
		e.preventDefault();
		//form태그 안에 있는 값을 가져와라
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		//form태그 안에 있는 값을 controller로 보내라
		actionForm.submit();

	})
})
    
		</script>
	</body>
</html>