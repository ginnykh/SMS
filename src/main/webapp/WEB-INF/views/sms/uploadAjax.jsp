<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@400;500&display=swap" rel="stylesheet">
<title>Insert title here</title>
<script type = "text/javascript" src = "https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type = "text/javascript" src = "../resources/js/uploadAjax.js"></script>
</head>
<body>

<div>
	<input type = "file" name = "uploadFile" multiple>
</div>

<input type = "submit" value = "전송">

<div id = "uploadResult">
	<ul></ul>
</div>

</body>
</html>