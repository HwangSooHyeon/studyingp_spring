<%@ include file="settings/taglibsetting.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp"%>

<title>Studying P - MyPage</title>

<%@ include file="settings/csssetting.jsp"%>

<script type="text/javascript">
$(document).ready(function(){
	var responseMessage = "${params.msg}";
	
	if(responseMessage != ""){
		alert(responseMessage);}
});

function pwChk(){
	var form = document.pwChkForm;
	
	$.ajax({
		url : "/mypage/pwChk",
		type : "POST",
		dataType : "json",
		data : {mem_pw : $("#mem_pw").val()},
		success : function(data){
			if(data == false){
				alert("비밀번호를 확인해주세요.");
			}else if(data == true){
				form.submit();
			}
		}
	});
}

</script>

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

					<form name="pwChkForm" method="post" action="/mypage/updateUser">
						<div class="form-group">
							<label for="mem_pw">본인 확인을 위해 비밀번호를 입력해주세요.</label>		
							<input type="password" class="form-control" name="mem_pw" id="mem_pw" size="50" placeholder="비밀번호를 입력해주세요."/>
						</div>
						
						<input type="button" onclick="pwChk()" class="btn btn-lg btn-primary btn-block" style="border: 2px solid; padding: 14px 5px" value="확인하기">
					</form>
				</div>
			</div>
		</div>
	</body>
	
	<!-- Footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>