<%@ include file="settings/taglibsetting.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp" %>

<title>Studying P - Edit Class(Inst)</title>

<%@ include file="settings/csssetting.jsp" %>
</head>
<body>
	<!-- Menu -->
	<%@ include file="menu.jsp"%>
	
	<div style="background: white;">
	
	<!-- 위쪽 공간 -->
		<div class="pt-5 pb-2"></div>
	
		<!-- 타이틀 -->
		<div class="pt-5 pb-1">
			<div class="container" align="center">
				<h2>강의 수정(강사)</h2>
			</div>
		</div>
		
		<div class="py-5">
			<div class="container">
				<table class="table">
					<thead>
						<tr>
							<th scope="col" class="text-center">강의코드</th>
							<th scope="col" class="text-center">강의명</th>
							<th scope="col" class="text-center">총 회차 수</th>
							<th scope="col" class="text-center">개요 수정</th>
							<th scope="col" class="text-center">상세 수정</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="item" items="${params.clsList}" begin="0" end="${fn:length(params.clsList)}" step="1">
						<tr style="border-bottom: 2px solid silver !important;">
							<th scope="row" class="text-center">${item.cls_code}</th>
							<th class="text-center">${item.cls_name}</th>
							<th class="text-center">${item.cls_totlect}</th>
							<th class="text-center"><a class="btn btn-secondary" href="/editClsOut?cls_code=${item.cls_code}">개요 수정</a></th>
							<th class="text-center"><a class="btn btn-primary" href="/editClsDetail?cls_code=${item.cls_code}">상세 수정</a></th>
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