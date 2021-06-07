<%@ include file="settings/taglibsetting.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp"%>

<title>Studying P - Update User</title>

<%@ include file="settings/csssetting.jsp"%>
</head>

<script type="text/javascript">

function chkUserInfo(){
	var form = document.updateForm;

	var regExpPw = /^[a-zA-Z0-9]{8,20}$/;
	var regExpName = /^[가-힣]{2,10}$/;
	var regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/;
	var regExpEmail = /^[a-zA-Z0-9]([-_\.]?[a-zA-Z0-9])*@[a-zA-Z0-9]([-_\.]?[a-zA-Z0-9])*\.[a-zA-Z]{2,3}$/i;
	
	var pw = form.mem_pw.value;
	var pwChk = form.mem_pw_chk.value;
	var name = form.mem_name.value;
	var phone = form.mem_phone.value;
	var email = form.mem_email.value;
	
	if(!regExpPw.test(pw)){
		alert("비밀번호는 8~20자를 넘어야 합니다.");
		form.mem_pw.select();
		form.mem_pw.focus();
		return false;
	}
	
	if(pw != pwChk){
		alert("비밀번호와 일치하지 않습니다.");
		form.mem_pw_chk.select();
		form.mem_pw_chk.focus();
		return false;
	}
	
	if(!regExpName.test(name)){
		alert("이름을 입력하세요.");
		form.mem_name.select();
		form.mem_name.focus();
		return false;
	}

	if(!regExpPhone.test(phone)){
		alert("휴대전화번호를 '-'을 포함하여 입력해주세요.");
		form.mem_phone.select();
		form.mem_phone.focus();
		return false;
	}
	
	if(!regExpEmail.test(email)){
		alert("이메일을 확인해주세요.");
		form.mem_email.select();
		form.mem_email.focus();
		return false
	}

	form.submit();
}
</script>

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
				    <a class="nav-link active" href="/mypage/updateUser">회원정보 수정</a>
				  </li>
				  <li class="nav-item">
				  	<a class="nav-link" href="/mypage/deleteUser">회원탈퇴</a>
				  </li>
			</ul>
		</div>

		<div class="container col-lg-12" align="center">
			<div
				style="background-color: white; color: black; border: 1px solid black; border-radius: 15px; margin: 30px auto; max-width: 550px; padding: 50px;"
				align="left">

				<form name="updateForm" method="post" action="/updateUserInfo">
					<div class="form-group">
						<label for="mem_pw">비밀번호</label>
						<input type="password" class="form-control" name="mem_pw" id="mem_pw" size="50" placeholder="8~20자의 영문, 숫자 조합" />
						</div>
					<br>
					<div class="form-group">
						<label for="mem_pw_chk">비밀번호 확인</label>
						<input type="password" class="form-control" name="mem_pw_chk" id="mem_pw_chk" size="50" placeholder="비밀번호를 한번 더 입력하세요." />
					</div>
					<br>	
					<div class="form-group">
						<label for="mem_name">이름</label> 
						<input type="text"	class="form-control" name="mem_name" id="mem_name" size="50" placeholder="이름을 입력하세요." value="${params.userInfo.mem_name}" />
					</div>
					<br>
					<div class="form-group">
						<label for="mem_phone">전화번호</label> 
						<input type="text"	class="form-control" name="mem_phone" id="mem_phone" size="50" placeholder="휴대전화 번호를 '-'을 포함하여 입력하세요." value="${params.userInfo.mem_phone}"/>
					</div>
					<br>
					<div class="form-group">
						<label for="mem_email">이메일</label> 
						<input type="email" class="form-control" name="mem_email" id="mem_email" size="50" placeholder="이메일을 입력하세요." value="${params.userInfo.mem_email}" />
					</div>
					<br> 
					<input type="button" onclick="chkUserInfo()" class="btn btn-lg btn-primary btn-block" style="border: 2px solid; padding: 14px 5px" value="수정하기">
				</form>
			</div>
		</div>
	</div>
	</body>
	<!-- Footer -->
	<%@ include file="footer.jsp"%>
	
</body>

</html>