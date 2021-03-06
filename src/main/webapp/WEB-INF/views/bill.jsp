<%@ include file="settings/taglibsetting.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp" %>

<title>Studying P - Bill</title>

<%@ include file="settings/csssetting.jsp" %>
</head>

<script type="text/javascript">

$(document).ready(function(){
	var responseMessage = "${params.msg}";
	
	if(responseMessage != ""){
		alert(responseMessage);}
});

function delOrdChk(selOrd){
	var result = confirm("주문을 취소하시겠습니까? 확인을 누르면 계속 진행합니다.");
	
	 if(result){
		 location.href = 'ordCancel?ordCode=' + selOrd;
	 }else{
		 
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
				<h2>주문조회</h2>
			</div>
		</div>
		
		<!-- 주문 목록 테이블 -->
		<div class="py-3">
			<div class="container">
				<table class="table">
					<thead>
						<tr>
							<th scope="col" class="text-center">주문번호</th>
							<th scope="col" class="text-center">가격</th>
							<th scope="col" class="text-center">주문일시</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="item" items="${params1.ordList}" begin="0" end="${fn:length(params1.ordList)}" step="1">
						<tr>
							<th class="align-middle text-center">${item.ord_code}</th>
							<th class="align-middle text-center"><fmt:formatNumber value="${item.ord_total}" type="number"/>원</th>
							<th>
								<div class="d-flex flex-column">
									<a class="py-2 px-3 my-1 text-white btn btn-secondary" 
									style="border-radius: 10px;" href="/editOrdOne?ordCode=${item.ord_code}">주문상세보기</a>
									<a class="py-2 px-3 my-1 text-black btn btn-light"
									style="border-radius: 10px;" onclick="delOrdChk(${item.ord_code})">주문취소</a>
								</div>
							</th>													
						</tr>
					</c:forEach>	
					</tbody>
				</table>
			</div>
		</div>
	</div>

	
	<!-- Footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>