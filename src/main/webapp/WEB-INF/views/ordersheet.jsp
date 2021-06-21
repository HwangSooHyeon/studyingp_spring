<%@ include file="settings/taglibsetting.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp" %>

<title>Studying P - Order Sheet</title>

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
		<!-- 위쪽 공간 -->
		<div class="pt-5 pb-2"></div>
	
		<!-- 주문서작성 타이틀 -->
		<div class="pt-5 pb-1">
			<div class="container" align="center">
				<h2>주문서작성</h2>
			</div>
		</div>
	
		<!-- 주문서작성 바 -->
		<div class="py-5">
			<div class="container">
				<div class="d-flex justify-content-center">
					<div class="py-2 px-5 bg-secondary text-white" style="border-radius: 10px;">01 장바구니</div>
					<div class="py-2 px-5 bg-primary text-white" style="border-radius: 10px;">02 주문서작성</div>
					<div class="py-2 px-5 bg-secondary text-white" style="border-radius: 10px;">03 결제완료</div>
					<div class="py-2 px-5 bg-secondary text-white" style="border-radius: 10px;">04 주문완료</div>
				</div>
			</div>	
		</div>
		
		<!-- 신청 내역 -->
		<div class="py-5">
			<div class="container">
				<h3>신청 내역</h3>
				<table class="table">
					<thead style="background: #f4f4f4">
						<tr>
							<th scope="col" class="text-center">상품명</th>
							<th scope="col" class="text-center">수강기간</th>
							<th scope="col" class="text-center">판매금액</th>
						</tr>
					</thead>
					<tbody>
					<c:set var="totPrice" value="0"></c:set>
					<c:set var="clsCodeList" value=""></c:set>
					<c:forEach var="item" items="${params1.clsList}" begin="0" end="${fn:length(params1.clsList)}" step="1">
						<c:set var="totPrice" value="${totPrice + item.cls_price}"></c:set>
						<tr style="border-bottom: 2px solid silver !important;">
							<th scope="row" class="text-center">${item.cls_name}</th>
							<th class="text-center">${item.cls_period}</th>
							<th class="text-center"><fmt:formatNumber value="${item.cls_price}" type="number"/> 원</th>
						</tr>
						<c:choose>
							<c:when test="${clsCodeList == ''}">
								<c:set var="clsCodeList" value="${item.cls_code}"></c:set>
							</c:when>
							<c:otherwise>
								<c:set var="clsCodeList" value="${clsCodeList}_${item.cls_code}"></c:set>
							</c:otherwise>
						</c:choose>
					</c:forEach>							
					</tbody>
				</table>
			</div>
		</div>
		
		<!-- 쿠폰 할인 -->
		
		<!-- 구매자 정보 -->
		<div class="py-5">
			<div class="container">
				<h3>구매자 정보</h3>
				<table class="table">
					<thead style="background: #f4f4f4">
						<tr>
							<th scope="col" class="text-center">주문자</th>
							<th scope="col" class="text-center">전화번호</th>
							<th scope="col" class="text-center">이메일</th>
						</tr>
					</thead>
					<tbody>
						<tr style="border-bottom: 2px solid silver !important;">
							<th scope="row" class="text-center">${params2.orderer.mem_name}</th>
							<th class="text-center">${params2.orderer.mem_phone}</th>
							<th class="text-center">${params2.orderer.mem_email}</th>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		
		<!-- 최종 결제 정보 -->
		<div class="py-5">
			<div class="container">
				<h3>최종 결제 정보</h3>
				<div class="d-flex justify-content-around" style="border-top: 2px solid silver; border-bottom: 2px solid silver">
					<div class="py-5 px-5 text-center" style="font-size: 20px;">주문 금액<br><fmt:formatNumber value="${totPrice}" type="number"/> 원</div>
					<div class="py-5 px-5 align-self-center"><i class="fas fa-minus"></i></div>
					<div class="py-5 px-5 text-center" style="font-size: 20px;">총 할인 금액<br>0원</div>
					<div class="py-5 px-5 align-self-center"><i class="fas fa-equals"></i></div>
					<div class="py-5 px-5 text-center align-self-center" style="font-size: 20px;">최종 결제 금액</div>
					<div class="py-5 px-5 text-center align-self-center text-danger" style="font-size: 30px; font-weight: bold;"><fmt:formatNumber value="${totPrice}" type="number"/> 원</div>
				</div>
			</div>
		</div>
		
		<!-- 결제 정보 -->
		<div class="py-5">
			<div class="container">
				<h3>결제 정보</h3>
				<div class="d-flex">
					<table class="table">
						<tr style="border-top: 2px solid silver;">
							<th class="align-middle text-center bg-light">결제 선택</th>
							<th><div class="btn btn-white" style="border: 1px solid black !important;">무통장입금</div> </th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
						<tr style="border-top: 1px solid grey !important; border-bottom: 1px solid grey !important;">
							<th class="align-middle text-center bg-light">입금 은행 선택</th>
							<th> <div class="btn btn-white" style="border: 1px solid black !important;">국민은행</div>
							<div class="btn btn-white" style="border: 1px solid black !important;">우리은행</div>
							<div class="btn btn-white" style="border: 1px solid black !important;">신한은행</div>
							<div class="btn btn-white" style="border: 1px solid black !important;">하나은행</div> </th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
						<tr>
							<th class="align-middle text-center bg-light">결제 안내</th>
							<th> <div class="btn btn-white" style="border: 1px solid black !important;">무통장입금 안내</div> </th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
					</table>
					<form name="completed" method="post">
						<div class="px-5 mx-5" style="border-top: 2px solid silver !important">
							<div class="px-5 pt-3 pb-2 text-center text-nowrap" style="font-size: 15px;">최종 결제 금액</div>
							<div class="px-5 pt-3 pb-4 text-center text-nowrap text-danger" style="font-size: 30px; font-weight: bold;"><fmt:formatNumber value="${totPrice}" type="number"/> 원</div>
							<a class="btn btn-danger text-white btn-block" href="/ordComplete?clsCodeList=${clsCodeList}&totPrice=${totPrice}">구매하기</a>
						</div>
					</form>
				</div>
			</div>
		</div>
		
	</div>
	
	<!-- Footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>