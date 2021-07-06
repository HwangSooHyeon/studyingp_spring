<%@ include file="settings/taglibsetting.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>

<%@ include file="settings/metasetting.jsp"%>

<title>Studying P - Upload Class</title>

<%@ include file="settings/csssetting.jsp"%>
</head>

<script type="text/javascript"></script>

<body>
	<!-- Menu -->
	<%@ include file="menu.jsp"%>
	
	<body style="background-color: #f4f4f4;">
	
		<div class="container" align="center">
			<div class="row">
				<div class="col-lg-12 mt-5">
					<div class="container mt-4">
						<h2>강의 업로드</h2>
					</div>
				</div>
			</div>
	
			<div class="container col-lg-12" align="center">
				<div
					style="background-color: white; color: black; border: 1px solid black; border-radius: 15px; margin: 30px auto; max-width: 550px; padding: 50px;"
					align="left">
	
					<form name="uploadForm" method="post" action="/doUpload" enctype="multipart/form-data">
						<div class="form-group">
							<label for="cls_category">카테고리</label>		
							<select class="custom-select" name="cls_category" id="cls_category" required>
								<option selected disabled value="">카테고리 선택</option>
								<option value="IT">IT</option>
								<option value="COOK">요리</option>
								<option value="LIVING">생활</option>
								<option value="SPORTS">스포츠</option>
								<option value="ETC">기타</option>
							</select>
						</div>
						<br>
						<div class="form-group">
							<label for="cls_name">강의명</label>
							<input type="text" class="form-control" name="cls_name" id="cls_name" size="50" placeholder="강의명을 입력하세요." required/>
						</div>
						<br>
						<div class="form-group">
							<label for="cls_price">금액</label>
							<input type="text" class="form-control" name="cls_price" id="cls_price" size="50" placeholder="금액을 입력하세요." required/>
						</div>
						<br>		
						<div class="form-group">
							<label for="cls_time">회당 시간(양식; 00:00:00)</label>
							<input type="text" class="form-control" name="cls_time" id="cls_time" size="50" placeholder="강의 회당 시간을 입력하세요.(예; 2시간일 경우 - 02:00:00)"/>
						</div>
						<br>
						<div class="form-group">
							<label for="cls_content">강의내용</label>
							<textarea class="form-control" rows="3" cols="" name="cls_content" id="cls_content" placeholder="강의 소개 및 내용을 입력하세요." required></textarea>
						</div>
						<br>
						<div class="form-group">
							<label for="cls_img_file">강의 이미지</label>
							<input type="file" class="form-control" name="cls_img_file" id="cls_img_file" size="50" required/>
						</div>	
						<br>
						<div class="form-group">
							<label for="cls_url">강의 URL</label>
							<textarea class="form-control" rows="3" cols="" name="cls_url" id="cls_url" placeholder="Youtube 공유의 퍼가기 내용을 복사 후 붙여넣어 주세요." required></textarea>
						</div>	
						<div class="form-group">
							<label for="cls_totlect">총 강의 차수</label>							
							<input type="text" class="form-control" name="cls_totlect" id="cls_totlect" placeholder="총 강의 차수를 입력하세요." required/>
						</div>			
						<input type="submit" class="btn btn-lg btn-primary btn-block" style="border: 2px solid; padding: 14px 5px" value="업로드하기">
					</form>
				</div>
			</div>
		</div>
	</body>
	
	<!-- Footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>