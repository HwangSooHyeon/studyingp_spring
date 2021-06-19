<%@ include file="settings/taglibsetting.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp" %>

<title>Studying P - Edit Member</title>

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
		case "searchMem":
			break;
		case "searchMemAll":
			break;
		case "searchMemDel":
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
				<h2>회원 조회 및 수정</h2>
			</div>
		</div>
		
		<!-- 검색 및 조회 -->
		<div class="py-5">
			<div class="container">
				<h3>검색</h3>
				<form name="searchForm" method="post" action="/searchMem" onsubmit="return blankChk()">
					<div class="form-group">
						<label for="searchCon">검색조건</label>		
							<select class="custom-select" name="searchCon" id="searchCon" required>
								<option selected disabled value="">조건 선택</option>
								<option value="searchMem">전체(미탈퇴)</option>
								<option value="searchMemAll">전체(탈퇴포함)</option>
								<option value="searchMemDel">탈퇴한 회원</option>
								<option value="mem_code">회원코드</option>
								<option value="mem_id">아이디</option>
								<option value="mem_name">회원이름</option>
								<option value="mem_access">권한(0: 관리자, 1: 강사, 2: 이용자)</option>
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
							<th scope="col" class="text-center">회원코드</th>
							<th scope="col" class="text-center">아이디</th>
							<th scope="col" class="text-center">회원이름</th>
							<th scope="col" class="text-center">전화번호</th>
							<th scope="col" class="text-center">이메일</th>
							<th scope="col" class="text-center">권한</th>
							<th scope="col" class="text-center">가입일</th>
							<th scope="col" class="text-center">탈퇴여부</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="item" items="${params.memList}" begin="0" end="${fn:length(params.memList)}" step="1">
						<tr style="border-bottom: 2px solid silver !important;">
							<th scope="row" class="text-center">${item.mem_code}</th>
							<th class="text-center"><a href="/editMemOne?memCode=${item.mem_code}">${item.mem_id}</a></th>
							<th class="text-center">${item.mem_name}</th>
							<th class="text-center">${item.mem_phone}</th>
							<th class="text-center">${item.mem_email}</th>
							<c:choose>
								<c:when test="${item.mem_access == 0}">
									<th class="text-center">관리자</th>
								</c:when>
								<c:when test="${item.mem_access == 1}">
									<th class="text-center">강사</th>
								</c:when>
								<c:when test="${item.mem_access == 2}">
									<th class="text-center">이용자</th>
								</c:when>
							</c:choose>
							<th class="text-center">${item.mem_date}</th>
							<c:choose>
								<c:when test="${item.mem_status == 1}">
									<th class="text-center">아니오</th>
								</c:when>
								<c:when test="${item.mem_status == 0}">
									<th class="text-center">예</th>
								</c:when>
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