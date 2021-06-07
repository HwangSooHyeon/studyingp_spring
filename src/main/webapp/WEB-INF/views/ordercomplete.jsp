<%@ include file="settings/taglibsetting.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp" %>

<title>Studying P - Order Complete</title>

<%@ include file="settings/csssetting.jsp" %>
</head>

<script type="text/javascript">

$(document).ready(function(){
	var responseMessage = "${params.msg}";
	
	if(responseMessage != ""){
		alert(responseMessage);}
});

</script>
<body>
<p>주문이 완료되었습니다.</p>
<p>입금계좌: 국민은행</p>
<p>계좌번호: 000000-00-000000</p>
<p>예금주: (주)스터딩피플</p>
<p>입금액: ${params1.totPrice}</p>
<a class="btn btn-primary btn-lg" href="/main">메인화면으로</a>

</body>
</html>