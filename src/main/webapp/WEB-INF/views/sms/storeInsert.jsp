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
    <link rel="stylesheet" href="/resources/css/storeInsert.css">
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
          
          <div class="storeInsert">
            <form action="/sms/storeInsert" method="post" id="target" role = "form">
              <legend>상품 등록</legend>
                <table>
                  <tr>
                    <td><input type="text" class="title" value="${itemDetail.ino}"></td>
                  </tr>
                  <tr>
                    <td><input type="text" placeholder="쇼핑몰을 입력해주세요." class="title" name="store"></td>
                  </tr>
                  <tr>
                    <td><input type="text" placeholder="가격을 입력해주세요." class="title" name="price"></td>
                  </tr>
                  <tr>
                    <td><input type="text" placeholder="배송비를 입력해주세요." class="title" name="price"></td>
                  </tr>
                </table>
                <input type="submit" value="등록" class="sub">            
            </form>
	
          </div> <!-- .itemInsert --> 
        </div><!--containerIn-->
      </div> <!--#container-->
      <%@ include file="footer.jsp" %>
    </div> <!--#wrap-->

</body>
</html>