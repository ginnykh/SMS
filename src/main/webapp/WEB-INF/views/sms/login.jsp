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
    <link rel="stylesheet" href="/resources/css/login.css">
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
	            
                <div id="loginBox">
                <div class="loginImg"></div>
                    <form action="/sms/login" id="login" method="post">
                        <div id="box">
                            <div id="id">
                                <p class="subTxt1">
                                    id
                                    <a href="">아이디를 잊으셨나요?</a>
                                </p>
                                <p>
                                    <input type="text" id="inputBox" name="id">
                                    <input type="checkbox" id="idCheck">
                                    <span>id 저장</span>
                                </p>
                                
                            </div>
                            <div id="password" >
                                <p class="subTxt2">
                                    Password
                                </p>
                                <p>
                                    <input type="password" id="inputBox" name="password">
                                </p>
                            </div>
                        </div>
                        <input type="submit" value="LOGIN" class="buttonss">
                    </form>
                </div> <!--.loginBox-->
            </div> <!--.containerIn-->
        </div> <!--#container-->
        <%@ include file="footer.jsp" %>
    </div> <!--#wrap-->
</body>
</html>