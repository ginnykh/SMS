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
    <link rel="stylesheet" href="/resources/css/detail.css">
    <link rel="stylesheet" href="/resources/css/modal.css">
    <link rel="stylesheet" href="/resources/css/header.css">
	<link rel="stylesheet" href="/resources/css/footer.css">
    <script type = "text/javascript" src = "https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type = "text/javascript" src = "/resources/js/detail.js"></script>
    
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
                <div class="contents">
                    <h3>공지사항</h3>
                    <c:if test = "${login.id=='smsMaster'}">
                    <div class="btn_m"><a href="/sms/modify?bno=${detail.bno}">수정</a></div>
                    <div class="btn_v"><a href="/sms/remove?bno=${detail.bno}">삭제</a></div>
                    </c:if>
                    <form>
	                    <table>
	                    
	                    	<div id="b" class="bnonum">${detail.bno}</div> 
	                    	
	                        <tr>
	                            <th>${detail.title}</th>
	                        </tr>
	                        <tr>
	                            <td class="writer">
	                                <span>작성자 : ${detail.writer} </span>
	                                <span class="w_r">등록일 : ${detail.regdate}</span>
	                                <span class="w_rr">조회수 : ${detail.cnt}</span>
	                            </td>
	                        </tr>
	                        <tr class="con">
	                            <td>
	                              ${detail.content}
	                            </td>
	                        </tr>
	                    </table>
                    </form>
                    
                    
                    <div id = "uploadResult" class="uploadResult">
						<ul></ul>
					</div>
                    
                    
                    <div class="buttonmo">
                     <!-- Trigger/Open The Modal -->
                     <c:if test = "${login != null}">
						<button id="myBtn" class="btnmo">댓글</button>
					 </c:if>
						<div class="reLi">
	      					<ul id="reList" ></ul>                      	
	                    </div>
					</div> <!-- .buttonmo -->
					
					
					
					<c:if test = "${login != null}">				
					<!-- The Modal -->
					<div id="myModal" class="modal">
					
					  <!-- Modal content -->
					  <div class="modal-content">
					    <div class="modal_top">
					      <p class="modal_name">댓글</p>
					      <p class="close">X</p>
					    </div> 
					    <div class="modal_detail">
					      내용 : <input type="text" class="mo_detail" name="reply">
					      <input type="hidden" name="rno">
					      <input type="hidden" value="${login.name}" id="replyer" name="replyer">
					    </div>
					    <div class="buttons">
					      <button type="button" class="btnmo" id="modalModBtn">수정</button>
					      <button type="button" class="btnmo" id="modalRemoveBtn">삭제</button>
					      <button type="button" class="btnmo" id="modalRegisterBtn">등록</button>
					    </div>
					  </div> <!-- .modal-content -->
					  
					</div> <!-- #myModal -->
                    </c:if>
                    
                    
                    
                    
                    
                    
                    
                    <div class="btn">
                    <c:if test = "${login.id=='smsMaster'}">
                        <div class="btn_r"><a href="/sms/write">글쓰기</a></div>
                    </c:if>
                        <div class="btn_l"><a href="/sms/list">목록보기</a></div>
                    </div> 
                    
                    <div class="beforeAfter">
                        <ul>
                        <c:if test="${detailPrev != null }">
                            <li>
                                <a href="/sms/detail?bno=${detail.bno-1}">
                                    <span class="ba_l">이전글</span>
                                    <span class="ba_r">${detailPrev.title}</span>
                                </a>
                            </li>
                            <li>
                                <a href="/sms/detail?bno=${detail.bno+1}">
                                    <span class="ba_l">다음글</span>
                                    <span class="ba_r">${detailNext.title}</span>
                                </a>
                            </li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div><!--containerIn-->
        </div> <!--#container-->
        <%@ include file="footer.jsp" %>
    </div> <!--#wrap-->
    
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="/resources/js/modal.js"></script>
    <script src="/resources/js/modaldetail.js"></script>
    
</body>
</html>