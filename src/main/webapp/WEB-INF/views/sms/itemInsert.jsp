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
    <link rel="stylesheet" href="/resources/css/itemInsert.css">
    <link rel="stylesheet" href="/resources/css/header.css">
	<link rel="stylesheet" href="/resources/css/footer.css">
    <script type = "text/javascript" src = "https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type = "text/javascript" src = "/resources/js/item.js"></script>

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
          
          <div class="itemInsert">
            <form action="/sms/itemInsert" method="post" id="target" role = "form">
              <legend>상품 등록</legend>
                <table>
                <tr>
                    <td class="flex">
                    <p class="mem">멤버를 입력해주세요.</p>
                    	<select name ="mem">
                    		<option value="에스쿱스">에스쿱스</option>
                    		<option value="정한">정한</option>
                    		<option value="조슈아">조슈아</option>
                    		<option value="준">준</option>
                    		<option value="호시">호시</option>
                    		<option value="원우">원우</option>
                    		<option value="우지">우지</option>
                    		<option value="디에잇">디에잇</option>
                    		<option value="민규">민규</option>
                    		<option value="도겸">도겸</option>
                    		<option value="승관">승관</option>
                    		<option value="버논">버논</option>
                    		<option value="디노">디노</option>
                    	</select>
                    </td>
                  </tr>
                  <tr>
                    <td class="flex">
                    <p class="itemfor">카테고리를 입력해주세요.</p>
                    	<select name ="itemfor">
                    		<option value="상의">상의</option>
                    		<option value="하의">하의</option>
                    		<option value="모자">모자</option>
                    		<option value="신발">신발</option>
                    		<option value="아우터">아우터</option>
                    		<option value="가방">가방</option>
                    		<option value="악세사리">악세사리</option>
                    	</select>
                    </td>
                  </tr>
                  <tr>
                    <td><input type="text" placeholder="날짜를 입력해주세요." class="title" name="dfw"></td>
                  </tr>
                  <tr>
                    <td><input type="text" placeholder="상품명을 입력해주세요." class="title" name="name"></td>
                  </tr>
                  <tr>
                    <td><input type="text" placeholder="컨텐츠을 입력해주세요." class="title" name="contents"></td>
                  </tr>
                  <tr>
                    <td><input type="text" placeholder="url을 입력해주세요." class="title" name="url"></td>
                  </tr>
                  <tr>
                    <td><input type="text" placeholder="사이즈를 입력해주세요." class="title" name="size"></td>
                  </tr>
                  <tr>
                  	<td><input type = "file" name = "uploadFile" class="upload" multiple></td>
                  </tr>
                </table>
                
                <div id = "uploadResult">
					<ul></ul>
				</div>

                <input type="submit" value="등록" class="sub">            
            </form>
	
          </div> <!-- .itemInsert --> 
        </div><!--containerIn-->
      </div> <!--#container-->
      <%@ include file="footer.jsp" %>
    </div> <!--#wrap-->

</body>
</html>