<%@ include file="settings/taglibsetting.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp"%>

<title>Studying P - Delete User</title>

<%@ include file="settings/csssetting.jsp"%>
</head>
<body>
	<!-- Menu -->
	<%@ include file="menu.jsp"%>
	
	<body style="background-color: #f4f4f4;">

	<div class="container" align="center">
		<div class="row">
			<div class="col-lg-12 mt-5">
				<div class="container mt-4">
					<h2>마이페이지</h2>
				</div>
			</div>
		</div>

		<div class="container">
			<ul class="nav nav-pills nav-fill">
				  <li class="nav-item">
				    <a class="nav-link" href="/mypage/updateUser">회원정보 수정</a>
				  </li>
				  <li class="nav-item">
				  	<a class="nav-link active" href="/mypage/deleteUser">회원탈퇴</a>
				  </li>
			</ul>
		</div>

		<div class="container col-lg-12" align="center">
			<div
				style="background-color: white; color: black; border: 1px solid black; border-radius: 15px; margin: 30px auto; max-width: 550px; padding: 50px;"
				align="left">
				
				<h4>탈퇴하시겠습니까?</h4>
				<br>
				<p>탈퇴 후에는 현재 수강 중인 강의를 들을 수 없습니다.</p>
				
				<a class="btn btn-lg btn-secondary btn-block" href="/deleteUser" style="border: 2px solid; padding: 14px 5px">탈퇴하기</a>
				
			</div>
		</div>
	</div>
	</body>
	
	<!-- Footer -->
	<%@ include file="footer.jsp"%>	
</body>
</html>