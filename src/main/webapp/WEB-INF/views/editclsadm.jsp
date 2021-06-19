<%@ include file="settings/taglibsetting.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp" %>

<title>Studying P - Edit Class(admin)</title>

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
		case "searchCls":
			break;
		case "searchClsAll":
			break;
		case "searchClsDel":
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
				<h2>강의 수정(관리자)</h2>
			</div>
		</div>
		
		<!-- 검색 및 조회 -->
		<div class="py-5">
			<div class="container">
				<h3>검색</h3>
				<form name="searchForm" method="post" action="/searchClsAdm" onsubmit="return blankChk()">
					<div class="form-group">
						<label for="searchCon">검색조건</label>		
							<select class="custom-select" name="searchCon" id="searchCon" required>
								<option selected disabled value="">조건 선택</option>
								<option value="searchCls">전체(미삭제)</option>
								<option value="searchClsAll">전체(삭제포함)</option>
								<option value="searchClsDel">삭제된 강의</option>
								<option value="cls_code">강의코드</option>
								<option value="cls_category">카테고리(IT, COOK, LIVING, SPORTS, ETC)</option>
								<option value="cls_name">강의명</option>
								<option value="mem_code">강사코드</option>
								<option value="mem_name">강사명</option>
						</select>
					</div>
										
						<!-- <div class="form-group">
							<select class="custom-select" name="searchWord" id="searchWordCat">
								<option selected disabled value="">카테고리 선택</option>
								<option value="IT">IT</option>
								<option value="COOK">요리</option>
								<option value="LIVING">생활</option>
								<option value="SPORTS">스포츠</option>
								<option value="ETC">기타</option>
							</select>
						</div> -->
													
					<div class="form-group">
						<input type="text" class="form-control" name="searchWord" id="searchWord" size="50" placeholder="검색어를 입력하세요.">
					</div>
			
					<input type="submit" class="btn btn-lg btn-primary btn-block" style="border: 2px solid; padding: 14px 5px" value="검색">
				</form>
				<table class="table">
					<thead>
						<tr>
							<th scope="col" class="text-center">강의코드</th>
							<th scope="col" class="text-center">카테고리</th>
							<th scope="col" class="text-center">강의명</th>
							<th scope="col" class="text-center">강사코드</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="item" items="${params.clsList}" begin="0" end="${fn:length(params.clsList)}" step="1">
						<tr style="border-bottom: 2px solid silver !important;">
							<th scope="row" class="text-center">${item.cls_code}</th>
							<th class="text-center">${item.cls_category}</th>
							<th class="text-center"><a href="/editClsOne?clsCode=${item.cls_code}">${item.cls_name}</a></th>
							<th class="text-center">${item.mem_code}</th>
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