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
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@400;500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/member.css">
    <link rel="stylesheet" href="/resources/css/header.css">
	<link rel="stylesheet" href="/resources/css/footer.css">

</head>
<body>
  <div id="wrap">
    <%@ include file="header.jsp" %>    
      <div id="container">
          <div class="containerIn">
            <section class="slide">
              <div class="slide-img">
                  
              </div>
            </section>
            <div>
              <h1>회원가입</h1>
              <form action="/sms/member" id="target" method="post" name="target">
                <legend>회원가입</legend>
                <div>
	                <label>이름</label><input type="text" placeholder=" 20자 이하로 입력해주세요." name="name" id="name"><span id="nameMsg"></span>    
                </div>
                <div>
	                 <label>아이디</label><input type="text" placeholder=" 8자 이상 20자 이하로 입력해주세요." id="id" name="id"><span id="idMsg"></span>
	                 <button id="confirmId" class="confirmId" type="button">중복 확인</button>
                </div>
                <div>
	                <label>비밀번호</label><input type="password" placeholder=" 8자 이상 30자 이하로 입력해주세요." id="pass" name="password"><span id="passMsg"></span>
                </div>
                <div>
	                <label>비밀번호확인</label><input type="password" id="compare"><span id="compareMsg"></span>
                </div>
                <div>
                  <label>휴대폰</label>
                  <input type="text" id="num" placeholder=" -을 빼고 입력해주세요." name="phone"><span id="numMsg"></span>
                  <button id="num_btn" class="confirmNum" type="button">인증번호발송</button>
                </div>
                <div>
                  <label>인증번호 입력</label><input type="text" id="passNum" readonly><span id="confirmMsg"></span>
                  <button type="button" class="confirm">확인</button>
                </div>
                <div class="sub_btn"><input type="button" id="log" value="저    장" name="log"></div>
               </form>
            </div>
          </div><!--.containerIn-->
        </div> <!--#container-->
        <%@ include file="footer.jsp" %>
    </div> <!--#wrap-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
   	<script src="/resources/js/member.js"></script> 
</body>
</html>