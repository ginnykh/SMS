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
    <link rel="stylesheet" href="/resources/css/itemDetail.css">
    <link rel="stylesheet" href="/resources/css/header.css">
	<link rel="stylesheet" href="/resources/css/footer.css">
    <script type = "text/javascript" src = "https://code.jquery.com/jquery-3.6.0.min.js"></script>

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
                <div class="info">
                
                    <div class="bigImg">
                        <img src="/display?fileName=${itemDetail.uploadPath}/${itemDetail.uuid}_${itemDetail.fileName}">  
                    </div> 
	
                   <div class="detail">
                        <h3><a href="">${itemDetail.contents}</a></h3>
                        <div class="size">${itemDetail.size}</div>
                        <div class="like"></div>
                        <div class="url"><a href="${itemDetail.url}">${itemDetail.url}</a></div>
                    </div>  <!--.detail-->
                    
                    <c:if test = "${login.id=='smsMaster'}">
                    <div class="delete"><a href="/sms/deleteItem?ino=${itemDetail.ino}">상품 삭제</a></div>
                    </c:if>
                    
                </div> <!--.info-->

                <div class="storelist">
                <div id="inonum" class="inonum">${itemDetail.ino}</div>
                    <table>
	                <thead>
	                    <tr>
	                        <th>번호</th>
	                        <th>쇼핑몰명</th>
	                        <th>제품명</th>
	                        <th>가격</th>
	                        <th>배송비</th>
	                    </tr>
                    </thead>
                    <tbody>
	               		
							<tr>
							    <td>1</td>
							    <td><a href="#">무신사</a></td>
							    <td>${itemDetail.name}</td>
							    <td>64000원</td>
							    <td>무료</td>
							</tr>
	                   
               		</tbody>
               	</table>
                    
                       <div class="btn_r"><a href="/sms/storeInsert?ino=${itemDetail.ino}">구매처 등록</a></div>
                	
                </div> <!--.storelist-->

				

            </div> <!--#containerIn-->
        </div> <!--#container-->
        <%@ include file="footer.jsp" %>
    </div> <!--#wrap-->
    

</body>
</html>
