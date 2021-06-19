<%@ include file="settings/taglibsetting.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp" %>

<title>Studying P - Edit Order Complete</title>

<%@ include file="settings/csssetting.jsp" %>
</head>

<script type="text/javascript">

$(document).ready(function(){
	var responseMessage = "${params.msg}";
	
	if(responseMessage != ""){
		if(alert(responseMessage)){
			
		}
		else{
			location.href = '/goEditOrd';
		}
	}
});

</script>
<body>
	<!-- Menu -->
	<%@ include file="menu.jsp"%>

	<!-- Footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>