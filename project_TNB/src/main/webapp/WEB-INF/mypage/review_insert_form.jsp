<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@include file="/resources/include/header.jsp" %>
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/mypage/review.css?after">

    <div class="container-fruid min-vh-100 " id="content_container">


        <div class="content_mypage container">
            <div class="aside_mypage">
                <div class="aside_menu_mypage">
                    <a href="review_list.mp">내 리뷰</a>
                </div>
            </div>
            <div class="content_area">
                <h2>리뷰 등록 하기</h2>
                <form action="review_insert.mp" method="post">
                	<input type="hidden" name="reservation_id" value="${reservation.room_reservation_num}">
                	<input type="hidden" name="shop_id" value="${reservation.shop_id}">
                	<input type="hidden" name="room_id" value="${reservation.room_id}">
                	<input type="hidden" name="user_id" value="${sessionScope.loginInfo.user_id}">
               		<table>
                        <tr>
                            <td>시설명</td>
                            <td>${shop_name}</td>                            
                        </tr>
                        <tr>
                        	<fmt:parseDate value="${reservation.room_checkin_date}" var="room_checkin_date" pattern="yyyy-MM-dd"/>
                        	<fmt:parseDate value="${reservation.room_checkout_date}" var="room_checkout_date" pattern="yyyy-MM-dd"/>
                            <td>예약 기간</td>
                            <td>
                            	<fmt:formatDate value="${room_checkin_date}" pattern="yyyy-MM-dd"/>
                            	~
                            	<fmt:formatDate value="${room_checkout_date}" pattern="yyyy-MM-dd"/>
                            </td>      
                            <tr>
                                <td>평점</td>
                                <td>
                                    <input type="range" name="grade" class="grade_range" min="1" max="20">
                                    <label class="grade_range_text">평점</label>
                                </td>                            
                            </tr>                            
                            <tr>
                                <td>이미지</td>
                                <td></td>                            
                            </tr>                            
                            <tr>
                                <td>내용</td>
                                <td><textarea name=""></textarea></td>                            
                            </tr>                            
                        </tr>
               		</table>
                </form>
                
            </div>
        </div>

    </div>    
    
    <%@include file="/resources/include/footer.jsp" %>