<%@ include file="settings/taglibsetting.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp" %>

<title>Studying P - Add Cart</title>

<%@ include file="settings/csssetting.jsp" %>
</head>
<body>

<script type="text/javascript">

$(document).ready(function(){
	var responseMessage = "${params.msg}";
	
	if(responseMessage != ""){
		var result = confirm(responseMessage);
		if(result){
			location.href = '/cart';
		}else{
			location.href = '/goClsInfo';
		}
	}
});

</script>

</body>
</html>