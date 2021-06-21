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
	<!-- Menu -->
	<%@ include file="menu.jsp"%>

	<div style="background: white;">
		<div class="pt-5 pb-2"></div>
	
		<!-- 타이틀 -->
		<div class="pt-5 pb-1">
			<div class="container" align="center">
				<h2>주문완료</h2>
			</div>
		</div>
		
		<!-- 주문완료 바 -->
		<div class="py-5">
			<div class="container">
				<div class="d-flex justify-content-center">
					<div class="py-2 px-5 bg-secondary text-white" style="border-radius: 10px;">01 장바구니</div>
					<div class="py-2 px-5 bg-secondary text-white" style="border-radius: 10px;">02 주문서작성</div>
					<div class="py-2 px-5 bg-secondary text-white" style="border-radius: 10px;">03 결제완료</div>
					<div class="py-2 px-5 bg-primary text-white" style="border-radius: 10px;">04 주문완료</div>
				</div>
			</div>
		</div>
		
		<div class="py-5">
			<div class="container">
				<h3>주문이 완료되었습니다.</h3>				
				<table class="table">
					<thead style="background: #f4f4f4">
						<tr>
							<th scope="col" class="text-center">입금은행</th>
							<th scope="col" class="text-center">계좌번호</th>
							<th scope="col" class="text-center">예금주</th>
							<th scope="col" class="text-center">입금액</th>
						</tr>
					</thead>
					<tbody>
						<tr style="border-bottom: 2px solid silver !important;">
							<th scope="row" class="text-center">국민은행</th>
							<th class="text-center">000000-00-000000</th>
							<th class="text-center">(주)스터딩피플</th>
							<th class="text-center"><fmt:formatNumber value="${params1.totPrice}" type="number"/> 원</th>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		
		<div class="py-5">
			<div class="container">
				<h3>송금내용을 꼭! 구매자 성함과 동일하게 기재해 주세요.</h3>
				<br>
				<a class="btn btn-primary btn-lg btn-block" href="/main">메인화면으로</a>
			</div>			
		</div>		
	</div>
	
	<!-- Footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>