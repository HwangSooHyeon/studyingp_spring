<%@ include file="settings/taglibsetting.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp"%>

<title>Studying P - Search Class</title>

<%@ include file="settings/csssetting.jsp"%>

<script type="text/javascript">

$(document).ready(function(){
	var responseMessage = "${params.msg}";
	
	if(responseMessage != ""){
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
		alert("검색어를 입력해주세요.");
		return false;
	}
	
	form.submit;
}
</script>

</head>
<body>
	<!-- Menu -->
	<%@ include file="menu.jsp"%>
	
	<div style="background: white;">
		<!-- 위쪽 공간 -->
		<div class="pt-5 pb-2"></div>
	
		<!-- 타이틀 -->
		<div class="pt-5 pb-1">
			<div class="container">
				<h2>강의 검색</h2>
				<br>
				<c:choose>
					<c:when test="${params2.clsCategory eq 'MUSIC'}">
					<h3>카테고리: 음악</h3>
					</c:when>
					<c:when test="${params2.clsCategory eq 'ART'}">
					<h3>카테고리: 미술</h3>
					</c:when>
					<c:when test="${params2.clsCategory eq 'COOK'}">
					<h3>카테고리: 요리</h3>
					</c:when>
					<c:when test="${params2.clsCategory eq 'IT'}">
					<h3>카테고리: IT</h3>
					</c:when>
				</c:choose>				
				<br>
				<form name="searchForm" method="post" action="/searchClsUser" onsubmit="return blankChk()">
					<div class="form-group">
						<input type="hidden" class="form-control" name="clsCategory" id="clsCategory" value="${params2.clsCategory}">
					</div>
					<div class="form-group">
						<label for="searchCon">검색조건</label>		
							<select class="custom-select" name="searchCon" id="searchCon" required>
								<option selected disabled value="">조건 선택</option>
								<option value="cls_name">강의명</option>
								<option value="mem_name">강사명</option>
						</select>
					</div>				
					<div class="form-group">
						<input type="text" class="form-control" name="searchWord" id="searchWord" size="50" placeholder="검색어를 입력하세요.">
					</div>			
					<input type="submit" class="btn btn-lg btn-primary btn-block" style="border: 2px solid; padding: 14px 5px" value="검색">
				</form>
				<br>
				<div class="row">
				<!-- Class List -->
				<c:forEach var="item" items="${params1.clsList}" begin="0"
					end="${fn:length(params1.clsList)}" step="1" varStatus="status">
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="#"><img class="card-img-top"
								src="./resources/img/${item.cls_img}" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="/goClsInfo?clsCode=${item.cls_code}"
										style="color: black">${item.cls_name}</a>
								</h4>
								<h5>
									<fmt:formatNumber value="${item.cls_price}" type="number" /> 원
								</h5>
								<p class="card-text">${item.cls_content}</p>
							</div>
							<div class="card-footer">
								<small class="text-muted">&#9733; &#9733; &#9733;
									&#9733; &#9733;</small>
							</div>
						</div>
					</div>
				</c:forEach>
				</div>
			</div>			
		</div>
	</div>
	
	<!-- Footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>