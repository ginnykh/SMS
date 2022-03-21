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
    <link rel="stylesheet" href="/resources/css/list.css">
    <link rel="stylesheet" href="/resources/css/header.css">
	<link rel="stylesheet" href="/resources/css/footer.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="/resources/js/board.js"></script>

</head>
<body>
    <div id="wrap">
    <%@ include file="header.jsp" %>
        <div id="container">
            <section class="slide">
                <div class="slide-img">
                    
                </div>
            </section>

            <section class="board">
                <h2>공지사항</h2>
                <table>
	                <thead>
	                    <tr>
	                        <th>번호</th>
	                        <th>제목</th>
	                        <th>작성자</th>
	                        <th>작성일</th>
	                        <th>조회수</th>
	                        <th>좋아요</th>
	                    </tr>
                    </thead>
                    <tbody>
	               		<c:forEach items="${list}" var="board">
							<tr>
							    <td>${board.bno}</td>
							    <td><a href="/sms/detail?bno=${board.bno}">${board.title}</a></td>
							    <td>${board.writer}</td>
							    <td>${board.regdate}</td>
							    <td>${board.cnt}</td>
							    <td>${board.good}</td>
							</tr>
	                   </c:forEach>
               		</tbody>
               	</table>
               	
               	<c:if test = "${login.id=='smsMaster'}">
					<div class="write"><a href="/sms/write">글쓰기</a></div> 
				</c:if>
               	
                <div class="search">
                	<form action="/sms/list" method="get" id="actionForm">	
                		<input type="hidden"  name="pageNum" value="${pageMaker.cri.pageNum}">
                		<input type="hidden"  name="amount" value="${pageMaker.cri.amount}">
          
	                    	<div class="paging">
		             		 	<ul>
		             		 	<c:if test="${pageMaker.prev}">
		             		 		<li class="atag"><a href="${pageMaker.startPage-1}">이전</a></li>
		             			</c:if>
		             		 	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
		             		 		<li class="atag"><a href="${num}">${num}</a></li>
		             		 	</c:forEach>
		             		 	<c:if test="${pageMaker.next}">
		             		 		<li class="atag"><a href="${pageMaker.endPage+1}">다음</a></li>
		             		 	</c:if>
		             		 	</ul>
		             		 </div>
	                    
	                     <select name="search" class="select" >
							<option value="t">---------제목---------</option>
							<option value="c">---------내용---------</option>
							<option value="w">-------작성자-------</option>
							<option value="tc">-----제목+내용-----</option>
							<option value="tcw">제목+내용+작성자</option>				
						</select>
	                    
	                    <input type="text" class="s-text" name="keyword" value="${pageMaker.cri.keyword}">
	                   	<input type="submit" value="검색" class="button" >	    
	                   	                            	
	                </form>
                </div> <!-- .search -->
            </section>
               
               
        </div> <!--#container-->
        <%@ include file="footer.jsp" %>
    </div> <!--#wrap-->
</body>
</html>