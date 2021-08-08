<%@ include file="settings/taglibsetting.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="settings/metasetting.jsp"%>

<title>Studying P - Redirect</title>

<%@ include file="settings/csssetting.jsp"%>

<script type="text/javascript">
$(document).ready(function(){
	var responseMessage = "${params.msg}";
	
	if(alert(responseMessage)){
		location.href='/login';
	}else{
		location.href='/login';
	}	
});
</script>

</head>
<body>

<!-- Footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>