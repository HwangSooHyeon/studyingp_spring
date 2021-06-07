<%@ include file="settings/taglibsetting.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp" %>

<title>Studying P - Cart</title>

<%@ include file="settings/csssetting.jsp" %>
</head>

<c:set var="currentUserId" value="${currentUser.mem_id}"></c:set>
<script type="text/javascript">

$(document).ready(function(){
	var responseMessage = "${params.msg}";
	
	if(responseMessage != ""){
		alert(responseMessage);}
});

function signInChkOne(selectedOne){
	var currentUser = "${currentUserId}";
	
	if(currentUser == ""){
		var result = confirm("로그인 후 가능합니다. 확인 버튼을 누르면 로그인 화면으로 이동합니다.");
		
		if(result){
			location.href="/goLogin";
		}
	}else if(currentUser != "" && selectedOne === undefined){
		location.href = "/orderSheet";
	}else{
		location.href = "/orderSheet?selClsCode=" + selectedOne;
	}
}

</script>

<body>
	<!-- Menu -->
	<%@ include file="menu.jsp"%>
	
	<div style="background: white;">
		<!-- 위쪽 공간 -->
		<div class="pt-5 pb-2"></div>
	
		<!-- 장바구니 타이틀 -->
		<div class="pt-5 pb-1">
			<div class="container" align="center">
				<h2>장바구니</h2>
			</div>
		</div>
	
		<!-- 01 장바구니 바 -->
		<div class="py-5">
			<div class="container">
				<div class="d-flex justify-content-center">
					<div class="py-2 px-5 bg-primary text-white" style="border-radius: 10px;">01 장바구니</div>
					<div class="py-2 px-5 bg-secondary text-white" style="border-radius: 10px;">02 주문서작성</div>
					<div class="py-2 px-5 bg-secondary text-white" style="border-radius: 10px;">03 결제완료</div>
					<div class="py-2 px-5 bg-secondary text-white" style="border-radius: 10px;">04 주문완료</div>
				</div>
			</div>	
		</div>
	
		<!-- 주문 목록 테이블 -->
		<div class="py-3">
			<div class="container">
				<table class="table">
					<thead>
						<tr>
							<th scope="col" class="text-center">강의명</th>
							<th scope="col" class="text-center">가격</th>
							<th scope="col" class="text-center">선택</th>
						</tr>
					</thead>
					<tbody>
					<c:set var="totPrice" value="0"></c:set>
					<c:forEach var="item" items="${params.cartClsList}" begin="0" end="${fn:length(params.cartClsList)}" step="1">
						<c:set var="totPrice" value="${totPrice + item.cls_price}"></c:set>
						<tr>
							<th class="align-middle text-center">${item.cls_name}</th>
							<th class="align-middle text-center"><fmt:formatNumber value="${item.cls_price}" type="number"/>원</th>
							<th>
								<div class="d-flex flex-column">
									<div class="py-2 px-3 my-1 text-white btn btn-secondary" 
									align="center" style="border-radius: 10px;"
									id="ordOne" onclick="signInChkOne(${item.cls_code})">주문하기</div>
									<div class="py-2 px-3 my-1 text-black btn btn-light" 
									align="center" style="border-radius: 10px;"
									onclick="location.href = '/delCls?selClsCode=${item.cls_code}';">삭제</div>
								</div>
							</th>													
						</tr>
					</c:forEach>	
						<tr style="border-top: 2px solid silver !important; border-bottom: 2px solid silver !important;">
							<th></th>
							<th></th>
							<th></th>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		
		<!-- 총 상품 금액, 결제 예정 금액 -->
		<div class="py-3">
			<div class="container">
				<table class="table">
					<thead>
						<tr>
							<th scope="col" class="py-4 text-center" style="background-color: gainsboro !important; border: 2px solid silver; font-size: 20px;">총 상품금액</th>
							<th scope="col" class="py-4 text-center" style="background-color: gainsboro !important; border: 2px solid silver; font-size: 20px;">결제예정금액</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th class="py-4 text-center" style="border: 2px solid silver; font-size: 25px;"><fmt:formatNumber value="${totPrice}" type="number"/>원</th>
							<th class="py-4 text-center text-primary" style="border: 2px solid silver; font-size: 25px;"><fmt:formatNumber value="${totPrice}" type="number"/>원</th>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	
		<!-- 전체상품 주문, 선택상품 주문 -->
		<div class="py-3">
			<div class="container">
				<div class="row">
					<table align="center">
						<tr>
							<td>
								<a id="ordAll" class="btn btn-primary text-white py-3 px-5 mr-3" 
								style="font-size: 25px;" onclick="signInChkOne()">전체 상품 주문하기</a>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>