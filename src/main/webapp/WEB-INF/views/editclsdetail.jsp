<%@ include file="settings/taglibsetting.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp" %>

<title>Studying P - Edit Class Detail</title>

<%@ include file="settings/csssetting.jsp" %>
</head>

<script type="text/javascript">

$(document).ready(function(){

});

</script>
<body>
	<!-- Menu -->
	<%@ include file="menu.jsp"%>
	<body style="background-color: #f4f4f4;">
		<div class="container" align="center">
			<div class="row">
				<div class="col-lg-12 mt-5">
					<div class="container mt-4">
						<h2>강의 수정(상세)</h2>
					</div>
				</div>
			</div>
			
			<form name="editClsDetailForm" method="post" action="/doEditClsDetail">
				<div class="form-group">
					<label for="cls_totlect">총 회차 수: ${params.clsDetailList[0].cls_totlect}</label>
					<input type="hidden" name="cls_totlect" id="cls_totlect" value="${params.clsDetailList[0].cls_totlect}">
				</div>
				<div class="form-group">
					<label for="cls_code">강의 번호: ${params.clsDetailList[0].cls_code}</label>
					<input type="hidden" name="cls_code" id="cls_code" value="${params.clsDetailList[0].cls_code}">
				</div>				
				
				<c:forEach var="item" items="${params.clsDetailList}" begin="0" end="${fn:length(params.clsDetailList)}" step="1" varStatus="status">
					<div class="form-group">
						<label for="">회차: ${item.clsd_lect}</label>
					</div>
					<div class="form-group">
						<label for="">회차 내용</label>
						<textarea class="form-control" rows="3" cols="" 
						name="clsd_content" id="clsd_content" 
						placeholder="회차 소개 및 내용을 입력하세요.">${item.clsd_content}</textarea>
					</div>
					<div class="form-group">
						<label for="">회차 강의 URL</label>
						<textarea class="form-control" rows="3" cols="" 
						name="clsd_url" id="clsd_url" 
						placeholder="회차 강의 URL을 입력하세요.">${item.clsd_url}</textarea>
					</div>
				</c:forEach>			
			</form>			
		</div>
	</body>
	<!-- Footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>