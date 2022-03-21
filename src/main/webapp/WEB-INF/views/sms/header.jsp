<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

        <div id="header">
            <div class="headerIn">
                <h1 class="logo">
                    <a href="/sms/main"><img src="/resources/img/common/logo.png" alt=""></a>
                </h1>

                <div class="gnb">
                
		                    <ul>
		                    <c:choose>
			                    <c:when test = "${login==null}">
			                        <li><a href="/sms/login">로그인</a></li>
			                    </c:when>
			                    <c:otherwise>
			                        <li><a href="/sms/logout" id="logout">로그아웃</a></li>
			                    </c:otherwise>   
		                    </c:choose>
		                        <li><a href="/sms/member">회원가입</a></li>
		                        <li><a href="#">손민수 목록</a></li>
		                        <li><a href="#">마이페이지</a></li>       
	                        </ul>
                </div>

                <div class="fixMenu">
                    <ul>
                        <li><a href="#">AB6IX</a></li>
                        <li><a href="#">CIX</a></li>
                        <li><a href="#">EXO</a></li>
                        <li><a href="#">ITZY</a></li>
                        <li><a href="#">MCND</a></li>
                        <li><a href="#">SF9</a></li>
                        <li><a href="#">TO1</a></li>
                        <li><a href="#">WayV</a></li>
                        <li><a href="#">woo!ah!</a></li>
                        <li><a href="#">WOODZ</a></li>
                        <li><a href="#">GOT7</a></li>
                        <li><a href="#">구구단</a></li>
                        <li><a href="#">LUCY</a></li>
                        <li><a href="#">HOPIPOLLA</a></li>
                        <li><a href="/sms/date">SEVENTEEN</a></li>
                        <li><a href="/sms/list">공지사항</a></li>
                    </ul>
                </div> <!--fixMenu-->
            </div> <!--.headerIn-->
        </div> <!--#header-->
        
        <script>
			$("#logout").on("click", function() {
				alert("로그아웃 되었습니다.");
			})
		</script>
