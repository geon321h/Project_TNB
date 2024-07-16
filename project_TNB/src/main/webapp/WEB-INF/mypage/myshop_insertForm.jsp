<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	<%
	
		String[] region = {
									"서울특별시","세종특별시","부산광역시","대구광역시","인천광역시",
									"광주광역시","대전광역시","울산광역시","경기도","강원도","충청북도",
									"충청남도","전라북도","전라남도","경상북도","경상남도"
									};

	%>
    
    <%@include file="/resources/include/header.jsp"%>
    
    <script src="<%=request.getContextPath()%>/resources/script/mypage/mypage_shop.js?after"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/mypage/myshop.css?after">

    <div class="container-fruid min-vh-100 " id="content_container">
        <div class="content_mypage container">
            <div class="aside_mypage">
                <div class="aside_menu_mypage">
                    <a href="myshop_list.mp">시설 관리</a>
                    <a href="review_list.mp">내 리뷰</a>
                </div>
            </div>
            <div class="content_area">
                <form:form commandName="shop" method="post" action="insert_shop.mp" enctype="multipart/form-data">
                <div class="shop_content_area shop_insert_area">
                	<p class="info_title">숙소명</p>
                    <div class="info_content">
                        <input type="text" name="shop_name" class="shop_text_input" placeholder="숙소명을 입력해주세요. (최대 20자)" value="${shop.shop_name}">
                        <p><form:errors path="shop_name" cssClass="err"></form:errors></p>
                    </div>
                	<p class="info_title">숙소 정보</p>
                    <div class="info_content">
                        <textarea name="shop_info" class="shop_textarea" placeholder="숙소 정보를 입력해주세요. (최대 100자)" >${shop.shop_info}</textarea>
                        <p><form:errors path="shop_info" cssClass="err"></form:errors></p>
                    </div>
                	<p class="info_title">카테고리</p>
                    <div class="info_content">
                    	<c:forEach items="${list_category}" var="category">
	                        <input type="radio" class="btn-check" name="category_id" value="${category.category_id}" 
	                        id="btn-check-outlined${category.category_id}" autocomplete="off">
	                        <label class="btn btn-outline-secondary category_btn" for="btn-check-outlined${category.category_id}">${category.category_name}</label>
                    	</c:forEach>
                    	<p><form:errors path="category_id" cssClass="err"></form:errors></p>
                    </div>
                	<p class="info_title">서비스 및 부대시설</p>
                    <div class="info_content">
                    	<c:forEach items="${list_service}" var="service">
	                        <input type="checkbox" class="btn-check" name="service_id" value="${service.service_id}" 
	                        id="btn-check-outlined-service-${service.service_id}" autocomplete="off">
	                        <label class="btn btn-outline-secondary category_btn" for="btn-check-outlined-service-${service.service_id}">${service.service_name}</label>
                    	</c:forEach>
                    </div>
                	<p class="info_title">지역 및 주소</p>
                    <div class="info_content">
                        <select class="form-select region_select" name="region" 
                        aria-label=".form-select-region">
                            <option selected value="">지역 선택</option>
                            <c:forEach items="<%=region%>" var="region">
	                            <option value="${region}">${region}</option>
                            </c:forEach>
                            <p><form:errors path="region" cssClass="err"></form:errors></p>
                        </select>
                        <div class="address_area">
                            <input type="text" class="address_input" name="shop_address" id="sample6_address" placeholder="주소">
                            <input type="button" class="btn btn-secondary" onclick="sample6_execDaumPostcode()" value="주소 검색"><br>
                            <input type="text" class="address_input" name="shop_address" id="sample6_detailAddress" placeholder="상세주소">   
                            <p><form:errors path="shop_address" cssClass="err"></form:errors></p>
                        </div>
                    </div>
                </div>
                <div class="shop_content_area shop_insert_area">
                    <div class="area_top">
                        <p class="info_title pt-2">이미지</p>
                        <input type="button" class="btn btn-secondary" onclick="image_add()" value="이미지 추가">
                    </div>
                    <div class="image_area">
                        
                    </div>
                </div>

                <div class="shop_content_area shop_insert_area">
                    <div class="area_top">
                        <p class="info_title pt-2">숙소 이용정보</p>
                        <div>
                            <input type="button" class="btn btn-outline-secondary" onclick="guide_delete()" value="이용정보 삭제">
                            <input type="button" class="btn btn-secondary" onclick="guide_add()" value="이용정보 추가">
                        </div>
                    </div>
                    <div class="guide_area">
                        
                    </div>
                    <p class="err guide_err"></p>
                </div>
                <div class="text-end">
                    <input type="submit" value="등록" class="submit_btn" onclick="return checkSubmit()">
                </div>
                </form:form>
            </div>
            <div>
            </div>            
        </div>
    </div>    
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <%@include file="/resources/include/footer.jsp" %>
    