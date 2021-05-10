<%@ include file="settings/taglibsetting.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp" %>

<title>Studying P - ClassInfo</title>

<%@ include file="settings/csssetting.jsp" %>
</head>

<body>
	<!-- Menu -->
	<%@ include file="menu.jsp"%>

	<div class="classInfo-head col-lg-9 col-md-6 mb-4">
		<div class="container row">
			<div class="col">
				<a href="#"><img class="" src="./resources/img/${params.ClsInfo.cls_img}" alt=""
					width="500vh"></a>
			</div>
			<div class="col">

				<div id="classInfo-info">
					<h5>
						<a href="#">${params.ClsInfo.cls_category}</a>
					</h5>
					<p class="classInfo-p">
						${params.ClsInfo.cls_name}<br> (내용)
						${params.ClsInfo.cls_content}<br> <br> 오늘 신청 시 <br>
						<em>${params.ClsInfo.cls_period}
						</em> <br> 까지 수강 가능 <br>
					</p>
					<button class="classInfo-btn btn btn-primary"><fmt:formatNumber value="${params.ClsInfo.cls_price}" type="number"/> 원
					</button>
				</div>

				<br>
			</div>
		</div>
	</div>

	<div class="">
		<div class="classInfo-box bg-secondary">실시간 리뷰!</div>
		<div class="classInfo-board">
			<div class="row classInfo-review-row">
				<div class="col">사진</div>
				<div class="col">
					<h7> <a href="#">(글제목)</a> </h7>
					<p class="classInfo-rp">
						(게시글작성자)의 후기 (작성일)<br> (평점)<br> (글내용)파이썬을 기초부터 하나씩 알려드리는
						강좌. 초보자용 코스입니다.<br>
					</p>
				</div>
			</div>
			<div class="row classInfo-review-row">
				<div class="col">사진</div>
				<div class="col">
					<h7> <a href="#">(글제목)</a> </h7>
					<p class="classInfo-rp">
						(게시글작성자)의 후기 (작성일)<br> (평점)<br> (글내용)파이썬을 기초부터 하나씩 알려드리는
						강좌. 초보자용 코스입니다.<br>
					</p>
				</div>
			</div>

			<div class="row classInfo-review-row">
				<div class="col">사진</div>
				<div class="col">
					<h7> <a href="#">(글제목)</a> </h7>
					<p class="classInfo-rp">
						(게시글작성자)의 후기 (작성일)<br> (평점)<br> (글내용)파이썬을 기초부터 하나씩 알려드리는
						강좌. 초보자용 코스입니다.<br>
					</p>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	<div class="classInfo-QnA">
		<div class="classInfo-box bg-secondary">강사님, 도와주세요! Q&A</div>
		<div class="classInfo-board">
			<div class="row classInfo-QnA-row">
				<div class="col">사진</div>
				<div class="col">
					<h7> <a href="#">(QnA글제목)</a> </h7>
					<p class="classInfo-rp">
						(작성일)에 작성<br> (글내용) Lorem ipsum dolor sit amet consectetur
						adipisicing elit. Distinctio aliquam, itaque, eaque modi
						voluptatibus labore illo magnam deleniti animi dolores vero et
						exercitationem, incidunt nihil quisquam libero voluptatem. A,
						nesciunt.
					</p>
				</div>

			</div>
			<div class="classInfo_QnA_Answer row">
				<div class="col">(답변아이콘)</div>
				<div class="col">
					<h7> <a href="#">(강사명)의 답변!</a> </h7>
					<p class="classInfo-rp">
						(작성일)<br> (답변내용) Lorem ipsum dolor sit amet consectetur
						adipisicing elit. Distinctio aliquam, itaque, eaque modi
						voluptatibus labore illo magnam deleniti animi dolores vero et
						exercitationem, incidunt nihil quisquam libero voluptatem. A,
						nesciunt.
					</p>
				</div>
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