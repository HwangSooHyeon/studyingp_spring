<%@ include file="settings/taglibsetting.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="settings/metasetting.jsp"%>

<title>Studying P - Login</title>

<%@ include file="settings/csssetting.jsp"%>

<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var responseMessage = "${params.msg}";
	
	if(responseMessage != ""){
		alert(responseMessage);}
});
</script>

</head>
<body>
	<!-- Menu -->
	<%@ include file="menu.jsp"%>
	
	<div class="container" align="center">
		<div class="row">
			<div class="col-lg-12 mt-5">
				<div class="container mt-4">
					<h2>로그인</h2>
				</div>
			</div>
		</div>

		<div class="container">
				<div class="col-lg-3 my-4">
					<form class="form-signin" action="/signIn" method="post">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="아이디" name='j_username' required autofocus>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="비밀번호" name='j_password' required>
						</div>
						<input type="submit" class="btn btn-lg btn-primary btn-block" value="로그인">
					</form>
					<div class="notact my-4" align="left">
						<p>아직 계정이 없으신가요?</p>
						<button class="btn btn-lg btn-primary btn-block"
							onclick="location.href='signup.jsp'"
							style="background-color: white; color: black; border: 2px solid black; padding: 14px 5px">
							회원가입</button>
					</div>
				</div>

				<div class="col-lg-7" align="center">
					<%@ include file="carousel.jsp"%>
				</div>
		</div>
	</div>

	<br>
	<br>
	<br>
	<br>
	<br>
	<!-- Footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>