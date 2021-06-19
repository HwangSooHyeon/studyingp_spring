<%@ include file="settings/taglibsetting.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp" %>

<title>Studying P - Edit Member Detail</title>

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
						<h2>회원 정보 수정</h2>
					</div>
				</div>
			</div>
	
			<div class="container col-lg-12" align="center">
				<div
					style="background-color: white; color: black; border: 1px solid black; border-radius: 15px; margin: 30px auto; max-width: 550px; padding: 50px;"
					align="left">
	
					<form name="editMemForm" method="post" action="/doEditMem">
						<div class="form-group">
							<label for="mem_code">회원코드: ${params.selMem.mem_code}</label>
							<input type="hidden" class="form-control" name="mem_code" id="mem_code" value="${params.selMem.mem_code}">
						</div>
						<br>
						<div class="form-group">
							<label for="mem_id">아이디: ${params.selMem.mem_id}</label>
							<input type="hidden" class="form-control" name="mem_id" id="mem_id" value="${params.selMem.mem_id}">
						</div>
						<br>
						<div class="form-group">
							<label for="mem_name">회원이름: ${params.selMem.mem_name}</label>
							<input type="hidden" class="form-control" name="mem_name" id="mem_name" value="${params.selMem.mem_name}">
						</div>
						<br>
						<div class="form-group">
							<label for="mem_phone">전화번호: ${params.selMem.mem_phone}</label>
							<input type="hidden" class="form-control" name="mem_phone" id="mem_phone" value="${params.selMem.mem_phone}">
						</div>
						<br>
						<div class="form-group">
							<label for="mem_email">이메일: ${params.selMem.mem_email}</label>
							<input type="hidden" class="form-control" name="mem_email" id="mem_email" value="${params.selMem.mem_email}">
						</div>
						<br>						
						<div class="form-group">
							<label for="mem_access">권한: </label>
							<c:choose>
								<c:when test="${params.selMem.mem_access == 0}">
									<label for="mem_access">관리자</label>
								</c:when>
								<c:when test="${params.selMem.mem_access == 1}">
									<label for="mem_access">강사</label>
								</c:when>
								<c:when test="${params.selMem.mem_access == 2}">
									<label for="mem_access">이용자</label>
								</c:when>
							</c:choose>
							<br>
							<br>
							<label for="mem_access">권한 변경</label>		
							<select class="custom-select" name="mem_access" id="mem_access" required>								
								<option selected disabled value="">변경할 권한 선택</option>
								<option value="0">관리자</option>
								<option value="1">강사</option>
								<option value="2">이용자</option>
							</select>							
						</div>
						<br>						
						<div class="form-group">
							<label for="mem_date">가입일: ${params.selMem.mem_date}</label>
							<input type="hidden" class="form-control" name="mem_date" id="mem_date" value="${params.selMem.mem_date}">
						</div>
						<br>						
						<div class="form-group">
							<label for="mem_status">탈퇴여부: </label>
							<c:choose>
								<c:when test="${params.selMem.mem_status == 0}">
									<label for="mem_status">탈퇴한 계정</label>
								</c:when>
								<c:when test="${params.selMem.mem_status == 1}">
									<label for="mem_status">정상 이용자</label>
								</c:when>
							</c:choose>
							<br>
							<br>
							<label for="mem_status">계정 복구 혹은 탈퇴</label>		
							<select class="custom-select" name="mem_status" id="mem_status" required>								
								<option selected disabled value="">복구 혹은 탈퇴를 선택</option>
								<option value="0">탈퇴</option>
								<option value="1">복구</option>
							</select>
						</div>
						<br>								
						<input type="submit" class="btn btn-lg btn-primary btn-block" style="border: 2px solid; padding: 14px 5px" value="수정하기">
					</form>
				</div>
			</div>
		</div>
	</body>
	<!-- Footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>