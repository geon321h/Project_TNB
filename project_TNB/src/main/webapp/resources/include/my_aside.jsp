<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/mypage/mypage_standard.css?after">
    
	<div class="aside_mypage">
               <div class="nav_area_mypage">
			<button onclick="">회원정보</button>
			<button onclick="">예약확인</button>
			<c:if test="${sessionScope.loginInfo!=null}">
				<c:if test="${sessionScope.loginInfo.user_type=='A' || sessionScope.loginInfo.user_type=='B'}">
					<button onclick="location.href='myshop_list.mp'">시설관리</button>
				</c:if>
			</c:if>
			<button onclick="">보유쿠폰</button>
		</div>
      </div>