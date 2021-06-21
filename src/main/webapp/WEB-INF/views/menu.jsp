<%@ include file="settings/taglibsetting.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 네비바 -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
	
		<c:set var="username" value="${currentUser.mem_name}"></c:set>
		<c:set var="access" value="${currentUser.mem_access}"></c:set>
		
		<a class="navbar-brand" href="/main"><img width="100px"
			src="/resources/img/mlog.png"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<!-- 드롭다운 메뉴-->
		<li class="nav-item dropdown navbar-dark" style="list-style: none;">
			<a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown"
			style="color: #fff"> 강의 </a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="/searchClsUser?clsCategory=MUSIC">음악</a> 
				<a class="dropdown-item" href="/searchClsUser?clsCategory=ART">미술</a> 
				<a class="dropdown-item" href="/searchClsUser?clsCategory=COOK">요리</a> 
				<a class="dropdown-item" href="/searchClsUser?clsCategory=IT">IT</a>
			</div>
		</li>
		<li class="nav-item dropdown navbar-dark" style="list-style: none;">
			<a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown"
			style="color: #fff"> 게시판 </a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="#">공지</a> 
				<a class="dropdown-item" href="#">리뷰</a> 
				<a class="dropdown-item" href="#">QnA</a> 
				<a class="dropdown-item" href="#">자유</a>
			</div>
		</li>
		
		<c:if test="${access == 1}">
			<li class="nav-item navbar-dark" style="list-style: none;">
				<a class="nav-link" href="/upload" style="color: #fff"> 강의 업로드 </a>
			</li>
			<li class="nav-item navbar-dark" style="list-style: none;">
				<a class="nav-link" href="/editClsInst" style="color: #fff"> 강의 수정(강사) </a>
			</li>
		</c:if>
		
		<c:if test="${access == 0}">
			<li class="nav-item navbar-dark" style="list-style: none;">
				<a class="nav-link" href="/editClsAdm" style="color: #fff"> 강의 수정(관리자) </a>
			</li>
			<li class="nav-item navbar-dark" style="list-style: none;">
				<a class="nav-link" href="/editMem" style="color: #fff"> 회원 조회 및 수정 </a>
			</li>
			<li class="nav-item navbar-dark" style="list-style: none;">
				<a class="nav-link" href="/editOrd" style="color: #fff"> 주문 조회 및 수정 </a>
			</li>
		</c:if>
		
		<div class="collapse navbar-collapse" id="navbarResponsive"
			style="text: center">
			<ul class="navbar-nav ml-auto">				

				<c:choose>
					<c:when test="${username != null}">
						<li class="nav-item active"><a class="nav-link" href="#">${username}님</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="/signOut">로그아웃</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="/cart">장바구니</a>
						</li>
						<li class="nav-item active"><a class="nav-link" href="#">GUEST님
						</a></li>
						<li class="nav-item"><a class="nav-link" href="/goLogin">로그인</a>
						</li>						
					</c:otherwise>
				</c:choose>
				
				<c:if test="${access != null}">
					<li class="nav-item dropdown navbar-dark" style="list-style: none;">
						<a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown"	style="color: #fff">
							<i class="fas fa-user-circle"></i>
						</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="/mypage">마이페이지</a> 
							<a class="dropdown-item" href="/cart">장바구니</a>
							<a class="dropdown-item" href="/bill">주문조회</a> 
							<a class="dropdown-item" href="#">수강 정보</a>
						</div>
					</li>
				</c:if>				
				
			</ul>
		</div>
	</div>
</nav>