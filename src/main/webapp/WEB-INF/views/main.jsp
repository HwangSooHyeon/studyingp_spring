<%@ include file="settings/taglibsetting.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp"%>

<title>Studying P - Main</title>

<%@ include file="settings/csssetting.jsp"%>

</head>
<body>
	<!-- Menu -->
	<%@ include file="menu.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<!-- Slide -->
				<%@ include file="carousel.jsp"%>

				<div class="row">
					<!-- Class List -->
					<c:forEach var="item" items="${params.MainClsList}" begin="0"
						end="${fn:length(params.MainClsList)}" step="1" varStatus="status">
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<a href="#"><img class="card-img-top"
									src="./resources/img/${item.cls_img}" alt=""></a>
								<div class="card-body">
									<h4 class="card-title">
										<a href="/goClsInfo?clsCode=${item.cls_code}"
											style="color: black">${item.cls_name}</a>
									</h4>
									<h5>
										<fmt:formatNumber value="${item.cls_price}" type="number" /> 원
									</h5>
									<p class="card-text">${item.cls_content}</p>
								</div>
								<div class="card-footer">
									<small class="text-muted">&#9733; &#9733; &#9733;
										&#9733; &#9733;</small>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.col-lg-9 -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<%@ include file="footer.jsp"%>

</body>
</html>