<%@ include file="settings/taglibsetting.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="settings/metasetting.jsp" %>

<title>Studying P - Edit Order Detail</title>

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
						<h2>주문 상세 조회</h2>
					</div>
				</div>
			</div>
	
			<div class="container col-lg-12" align="center">
				<div
					style="background-color: white; color: black; border: 1px solid black; border-radius: 15px; margin: 30px auto; max-width: 550px; padding: 50px;"
					align="left">
	
					<form name="uploadForm" method="post" action="/doEditOrd">
						<div class="form-group">
							<label for="ord_code">주문번호: ${params1.selOrd.ord_code}</label>
							<input type="hidden" class="form-control" 
							name="ord_code" id="ord_code" 
							value="${params1.selOrd.ord_code}" required>
						</div>
						<br>
						<div class="form-group">
							<label for="mem_code">주문회원번호: ${params1.selOrd.mem_code}</label>		
							<input type="hidden" class="form-control" 
							name="mem_code" id="mem_code" 
							value="${params1.selOrd.mem_code}" required>
						</div>
						<br>
						<label>주문강의목록</label>
						<table class="table">
							<thead>
								<tr>
									<th scope="col" class="text-center">강의코드</th>
									<th scope="col" class="text-center">카테고리</th>
									<th scope="col" class="text-center">강의명</th>
									<th scope="col" class="text-center">강사코드</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="item" items="${params3.clsList}" begin="0" end="${fn:length(params3.clsList)}" step="1">
								<tr style="border-bottom: 2px solid silver !important;">
									<th scope="row" class="text-center">${item.cls_code}</th>
									<th class="text-center">${item.cls_category}</th>
									<th class="text-center">${item.cls_name}</th>
									<th class="text-center">${item.mem_code}</th>
								</tr>
							</c:forEach>
							</tbody>
						</table>
						<br>
						<div class="form-group">
							<label for="ord_date">주문일자: ${params1.selOrd.ord_date}</label>
							<input type="hidden" class="form-control" 
							name="ord_date" id="ord_date" size="50"  
							value="${params1.selOrd.ord_date}" required/>
						</div>
						<br>
						<div class="form-group">
							<label for="ord_total">결제금액: <fmt:formatNumber value="${params1.selOrd.ord_total}" type="number"/> 원</label>
							<input type="hidden" class="form-control" 
							name="ord_total" id="ord_total"
							value="${params1.selOrd.ord_total}" required/>
						</div>
						<br>
						
					<c:if test="${params2.currentUser.mem_access == 0}">
						<div class="form-group">
							<label for="ord_cancel">취소여부: </label>
						<c:choose>
							<c:when test="${params1.selOrd.ord_cancel == 0}">
								<label for="ord_cancel">취소됨</label>
							</c:when>
							<c:when test="${params1.selOrd.ord_cancel == 1}">
								<label for="ord_cancel">정상</label>
							</c:when>
						</c:choose>
							<br>
							<label for="ord_cancel">주문을 취소하시겠습니까?</label>
							<select class="custom-select" name="ord_cancel" id="ord_cancel" required>								
								<option selected disabled value="">취소여부 선택</option>
								<option value="0">취소</option>
								<option value="1">취소안함</option>
							</select>
						</div>
						<br>
						<div class="form-group">
							<label for="ord_check">입금확인: </label>
						<c:choose>
							<c:when test="${params1.selOrd.ord_check == 0}">
								<label for="ord_check">-</label>
							</c:when>
							<c:when test="${params1.selOrd.ord_check == 1}">
								<label for="ord_check">확인</label>
							</c:when>
						</c:choose>
							<br>
							<label for="ord_check">입금확인 체크하시겠습니까?</label>
							<select class="custom-select" name="ord_check" id="ord_check" required>								
								<option selected disabled value="">확인여부 선택</option>
								<option value="0">미확인</option>
								<option value="1">확인완료</option>
							</select>
						</div>
						<br>
						<div class="form-group">
							<label for="ord_chkdate">입금확인일자: </label>
						<c:choose>
							<c:when test="${params1.selOrd.ord_chkdate eq '0001-01-01'}">
								<label for="ord_chkdate">-</label>
							</c:when>
							<c:otherwise>
								<label for="ord_chkdate">${params1.selOrd.ord_chkdate}</label>
							</c:otherwise>
						</c:choose>
							<input type="hidden" class="form-control" 
							name="ord_chkdate" id="ord_chkdate" 
							value="${params1.selOrd.ord_chkdate}" required>
						</div>
						<br>
						<input type="submit" class="btn btn-lg btn-primary btn-block" style="border: 2px solid; padding: 14px 5px" value="수정하기">
					</c:if>	
					</form>
				</div>
			</div>
		</div>
	</body>
	<!-- Footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>