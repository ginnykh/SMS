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
    <link rel="stylesheet" href="/resources/css/write.css">
    <link rel="stylesheet" href="/resources/css/header.css">
	<link rel="stylesheet" href="/resources/css/footer.css">
	<script type = "text/javascript" src = "https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type = "text/javascript" src = "/resources/js/uploadAjax.js"></script>
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
          
          <div class="write">
            <form action="/sms/write" method="post" id="target" role = "form">
              <legend>글쓰기</legend>
                <table>
                  <tr>
                    <td><input type="hidden" class="title" value="${login.name}" name="writer" readonly ></td>
                  </tr>
                  <tr>
                    <td><input type="text" placeholder="제목을 입력해주세요." class="title" id="tCount" name="title"></td>
                  </tr>
                  <tr>
                    <td><textarea name="content" id="text" cols="100" rows="15" placeholder="내용을 입력해주세요." class="text"></textarea></td>
                  </tr>
                </table>
                <p class="countTitle"><span id="countTi"></span>/100</p>
                <p class="countText"><span id="countT"></span>/2000</p>
                
                <div>
					<input type = "file" name = "uploadFile" class="upload" multiple>
				</div>
				<input type="submit" value="등록" class="sub">
            </form>
            
            <div id = "uploadResult">
				<ul></ul>
			</div>
            
          </div> <!-- .write -->
           
          
		  
        </div><!--containerIn-->
      </div> <!--#container-->
      <%@ include file="footer.jsp" %>
    </div> <!--#wrap-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>   
	<script src="/resources/js/count.js"></script>
</body>
</html>
