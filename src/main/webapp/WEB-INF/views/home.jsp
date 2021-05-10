<%@ include file="settings/taglibsetting.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp"%>

<title>Studying P - Home</title>

<%@ include file="settings/csssetting.jsp"%>
</head>
<script type="text/javascript"></script>
<body>
	<!-- Menu -->
	<%@ include file="menu.jsp"%>

	<h1>Hello world!</h1>

	<p>${params.HomeClsList.get(0)}</p>
	<p>code: ${params.HomeClsList.get(0).cls_code}</p>
	<p>name: ${params.HomeClsList.get(0).cls_name}</p>
	<p>content: ${params.HomeClsList.get(0).cls_content}</p>

	<button onclick="location.href = '/main';">메인화면</button>

	<!-- Footer -->
	<%@ include file="footer.jsp"%>

</body>
</html>