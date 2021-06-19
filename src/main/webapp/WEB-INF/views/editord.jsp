<%@ include file="settings/taglibsetting.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp" %>

<title>Studying P - Edit Order</title>

<%@ include file="settings/csssetting.jsp" %>
</head>

<script type="text/javascript">

$(document).ready(function(){
	var responseMessage = "${params.msg}";
	
	if(responseMessage == "관리자 계정 외에는 접근할 수 없습니다. 확인을 누르면 메인으로 이동합니다."){
		if(alert(responseMessage)){
			location.href = '/main';
		}else{
			location.href = '/main';
		}
	}
	
	if(responseMessage == "검색 조건 설정에 오류가 있습니다. 다시 진행해주세요."){
		alert(responseMessage);
	}
});

function blankChk(){
	var form = document.searchForm;
	var searchCon = document.getElementById("searchCon");
	var searchWord = document.getElementById("searchWord");
	
	console.log(form);
	
	searchCon = searchCon.options[searchCon.selectedIndex].value;
	searchWord = searchWord.value;
	
	if(searchWord == ""){
		switch(searchCon){
		case "searchOrd":
			break;
		case "searchOrdAll":
			break;
		case "searchOrdDel":
			break;
		case "unchkOrd":
			break;
		default:
			alert("검색어를 입력해주세요.");
			return false;
		}
	}
	
	form.submit;
}
</script>
<body>
	<!-- Menu -->
	<%@ include file="menu.jsp"%>
	
	<div style="background: white;">
		<!-- 위쪽 공간 -->
		<div class="pt-5 pb-2"></div>
	
		<!-- 타이틀 -->
		<div class="pt-5 pb-1">
			<div class="container" align="center">
				<h2>주문 조회 및 수정</h2>
			</div>
		</div>
		
		<!-- 검색 및 조회 -->
		<div class="py-5">
			<div class="container">
				<h3>검색</h3>
				<form name="searchForm" method="post" action="/searchOrd" onsubmit="return blankChk()">
					<div class="form-group">
						<label for="searchCon">검색조건</label>		
							<select class="custom-select" name="searchCon" id="searchCon" required>
								<option selected disabled value="">조건 선택</option>
								<option value="searchOrd">전체(미취소)</option>
								<option value="searchOrdAll">전체(취소포함)</option>
								<option value="searchOrdDel">취소한 주문</option>
								<option value="mem_code">회원코드</option>
								<option value="mem_id">아이디</option>
								<option value="mem_name">회원이름</option>								
								<option value="ord_date">기간(양식; 2021-01-01)</option>
								<option value="ord_code">주문번호</option>
								<option value="unchkOrd">미결제(취소미포함)</option>														
						</select>
					</div>				
					<div class="form-group">
						<input type="text" class="form-control" name="searchWord" id="searchWord" size="50" placeholder="검색어를 입력하세요.">
					</div>
					<button type="submit" class="btn btn-lg btn-primary btn-block" style="border: 2px solid; padding: 14px 5px">검색</button>
				</form>
				<table class="table">
					<thead>
						<tr>
							<th scope="col" class="text-center">주문번호</th>
							<th scope="col" class="text-center">회원코드</th>
							<th scope="col" class="text-center">주문일자</th>
							<th scope="col" class="text-center">결제금액(원)</th>
							<th scope="col" class="text-center">취소여부</th>
							<th scope="col" class="text-center">입금확인</th>
							<th scope="col" class="text-center">입금확인일자</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="item" items="${params.ordList}" begin="0" end="${fn:length(params.ordList)}" step="1">
						<tr style="border-bottom: 2px solid silver !important;">
							<th scope="row" class="text-center"><a href="/editOrdOne?ordCode=${item.ord_code}">${item.ord_code}</a></th>
							<th class="text-center">${item.mem_code}</th>
							<th class="text-center">${item.ord_date}</th>
							<th class="text-center"><fmt:formatNumber value="${item.ord_total}" type="number"/></th>
							<c:choose>
								<c:when test="${item.ord_cancel == 0}">
									<th class="text-center">취소됨</th>
								</c:when>
								<c:when test="${item.ord_cancel == 1}">
									<th class="text-center">정상</th>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${item.ord_check eq ''}">
									<th class="text-center">-</th>
								</c:when>
								<c:when test="${item.ord_check == 1}">
									<th class="text-center">확인</th>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${item.ord_chkdate eq '0001-01-01'}">
									<th class="text-center">-</th>
								</c:when>
								<c:otherwise>
									<th class="text-center">${item.ord_chkdate}</th>
								</c:otherwise>
							</c:choose>					
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