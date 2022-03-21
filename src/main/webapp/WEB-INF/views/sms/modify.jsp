<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet" href="/resources/css/modify.css">
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
		                  	슬라이드
		                  <!-- <img src="./img/slide.PNG" alt=""> -->
		                </div>
		              </section>
		              <div class="write">
		                <form action="/sms/modify" method="post">
		                  <legend>글수정</legend>
		                    <table>
		                        <tr class="bno">
		                        <td><input type="hidden" value="${detail.bno}" name="bno" ></td> <!-- readonly로 수정을 못하게 막아 줄수도 있다. -->
		                      </tr>
		                       <tr>
		                        <td><input type="text" value="${detail.title}" name="title"  class="title" id="tCount"></td>
		                      </tr>
		                      <tr>
		                        <td><textarea name="content"  id="text" cols="100" rows="15" class="text">${detail.content}</textarea></td>
		                      </tr>
		                    </table>
		                    <p class="countTitle"><span id="countTi"></span>/100</p>
		                    <p class="countText"><span id="countT"></span>/2000</p>
		                    <input type="submit" value="확인" class="sub">
		                </form>
		              </div>  
		            </div><!--containerIn-->
	          </div> <!--#container-->
	          <%@ include file="footer.jsp" %>
	    </div> <!--#wrap-->
	    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>   
		<script src="/resources/js/count.js"></script>
</body>
</html>