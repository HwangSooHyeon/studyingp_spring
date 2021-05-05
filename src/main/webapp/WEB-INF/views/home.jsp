<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<title>Home</title>
</head>
<script type="text/javascript"></script>
<body>

<h1>
	Hello world!  
</h1>

<p>${test}</p>
<p>code: ${test.cls_code}</p>
<p>name: ${test.cls_name}</p>
<p>content: ${test.cls_content}</p>

<button onclick="location.href = '/main';">메인화면</button> 

</body>
</html>