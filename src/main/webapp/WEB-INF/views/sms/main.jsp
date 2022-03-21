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
    <link rel="stylesheet" href="../resources/css/main.css">
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


                <div id="items">
                    <div class="best">
                        <h2>BEST</h2>
                        <ul>
                            <li>
                                <a href="#">
                                    <img src="/resources/img/JH/outer1.jpg" alt="" class="thumbnail" onmouseover="this.src='/resources/img/JH/outer2.jpg'" onmouseout="this.src='/resources/img/JH/outer1.jpg'">
                                    <p class="description">220204 브이앱 "밥이나 먹자여~~" 가디건</p>
                                    <p class="desSize">FREE</p>
                                </a>
                            </li>
                            <li>
                                <a href="#"><img src="/resources/img/JH/bag1.jpg" alt="" class="thumbnail" onmouseover="this.src='/resources/img/JH/bag2.jpg'" onmouseout="this.src='/resources/img/JH/bag1.jpg'">
                                    <p class="description">220204 뮤직뱅크 출근길 가방</p>
                                    <p class="desSize">FREE</p>
                                </a>
                            </li>
                            <li>
                                <a href="#"><img src="/resources/img/JH/muffler1.jpg" alt="" class="thumbnail" onmouseover="this.src='/resources/img/JH/muffler2.jpg'" onmouseout="this.src='/resources/img/JH/muffler1.jpg'">
                                    <p class="description">220204 위버스 목도리</p>
                                    <p class="desSize">FREE</p>
                                </a>
                            </li>
                            <li>
                                <a href="#"><img src="/resources/img/JH/shirts1.jpg" alt="" class="thumbnail" onmouseover="this.src='/resources/img/JH/shirts2.jpg'" onmouseout="this.src='/resources/img/JH/shirts1.jpg'">
                                    <p class="description">220204 INSIDE SEVENTEEN "Ready To Love 안무 연습 비하인드" 반팔</p>
                                    <p class="desSize">FREE</p>
                                </a>
                            </li>
                        </ul>
                    </div> <!--best-->
                    <div class="new">
                        <h2>NEW</h2>
                        <ul>
                            <li>
                                <a href="#"><img src="/resources/img/SC/shirts1.jpg" alt="" class="thumbnail" onmouseover="this.src='/resources/img/SC/shirts2.jpg'" onmouseout="this.src='/resources/img/SC/shirts1.jpg'">
                                    <p class="description">220204 INSIDE SEVENTEEN "Ready To Love 안무 연습 비하인드" 반팔</p>
                                    <p class="desSize">FREE</p>
                                </a>
                            </li>
                            <li>
                                <a href="#"><img src="/resources/img/SC/hood2.jpg" alt="" class="thumbnail" onmouseover="this.src='/resources/img/SC/hood1.jpg'" onmouseout="this.src='/resources/img/SC/hood2.jpg'">
                                    <p class="description">SEVENTEEN 7th Mini Album "Rock with you" 자켓 티저 사진 후드</p>
                                    <p class="desSize">FREE</p>
                                </a>
                            </li>
                            <li>
                                <a href="#"><img src="/resources/img/SK/shoes1.JPG" alt="" class="thumbnail" onmouseover="this.src='/resources/img/SK/shoes2.jpg'" onmouseout="this.src='/resources/img/SK/shoes1.JPG'">
                                    <p class="description">220204 위버스 가디건</p>
                                    <p class="desSize">FREE</p>
                                </a>
                            </li>
                            <li>
                                <a href="#"><img src="/resources/img/SY/beanie1.jpg" alt="" class="thumbnail" onmouseover="this.src='/resources/img/SY/beanie2.jpg'" onmouseout="this.src='/resources/img/SY/beanie1.jpg'">
                                    <p class="description">220204 INSIDE SEVENTEEN "Ready To Love 안무 연습 비하인드" 반팔</p>
                                    <p class="desSize">FREE</p>
                                </a>
                            </li>
                        </ul>
                    </div> <!--new-->
                </div> <!--items-->
            </div> <!--containerIn-->         
        </div> <!--container-->
        <%@ include file="footer.jsp" %>
    </div> <!--#wrap-->
</body>
</html>
