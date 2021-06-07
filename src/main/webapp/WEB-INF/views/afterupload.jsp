<%@ include file="settings/taglibsetting.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp"%>

<title>Studying P - Main</title>

<%@ include file="settings/csssetting.jsp"%>

<script type="text/javascript">

$(document).ready(function(){
	var responseMessage = "${params.msg}";
	
	if(responseMessage != ""){
		if(alert(responseMessage)){
			location.href='/main';
		}else{
			location.href='/main';
		}
	}	
});

</script>

</head>
<body>
	<!-- Menu -->
	<%@ include file="menu.jsp"%>
	
	<!-- Footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>