<%@ include file="settings/taglibsetting.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp"%>

<title>Studying P - MyPage</title>

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
	
			<div class="container col-lg-12" align="center">
				<div
					style="background-color: white; color: black; border: 1px solid black; border-radius: 15px; margin: 30px auto; max-width: 550px; padding: 50px;"
					align="left">
	
					<form name="signUpForm" method="post" action="/signUp">
						<div class="form-group">
							<label for="mem_id">아이디</label>		
							<input type="text" class="form-control" name="mem_id" id="mem_id" size="50" placeholder="5~20자의 영문 소문자, 숫자만 가능"/>
							<button type="button" class="btn btn-secondary" id="idCheck" onclick="idChk()">중복확인</button>
						</div>
						<br>
						<div class="form-group">
							<label for="mem_pw">비밀번호</label>
							<input type="password" class="form-control" name="mem_pw" id="mem_pw" size="50" placeholder="8~20자의 영문, 숫자 조합"/>
						</div>
						<br>
						<div class="form-group">
							<label for="mem_pw_chk">비밀번호 확인</label>
							<input type="password" class="form-control" name="mem_pw_chk" id="mem_pw_chk" size="50" placeholder="비밀번호를 한번 더 입력하세요."/>
						</div>
						<br>		
						<div class="form-group">
							<label for="mem_name">이름</label>
							<input type="text" class="form-control" name="mem_name" id="mem_name" size="50" placeholder="이름을 입력하세요."/>
						</div>
						<br>
						<div class="form-group">
							<label for="mem_phone">전화번호</label>
							<input type="text" class="form-control" name="mem_phone" id="mem_phone" size="50" placeholder="휴대전화 번호를 '-'을 포함하여 입력하세요."/>
						</div>
						<br>
						<div class="form-group">
							<label for="mem_email">이메일</label>
							<input type="email" class="form-control" name="mem_email" id="mem_email" size="50" placeholder="이메일을 입력하세요."/>
						</div>
	
						<br>
						<input type="button" onclick="chkSignUp()" class="btn btn-lg btn-primary btn-block" style="border: 2px solid; padding: 14px 5px" value="가입하기">
					</form>
				</div>
			</div>
		</div>
	</body>
	
	
	<!-- Footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>