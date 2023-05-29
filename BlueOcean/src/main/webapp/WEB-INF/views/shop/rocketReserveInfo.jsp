<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath }/" />
<c:import url="/WEB-INF/views/include/header.jsp" />

<h3>예약상세 페이지 </h3>

		<div class="row">
			<div class="col-md-5">
				<img class="img-thumbnail" src="${root }resources/rockets/${rocketReserveInfo.rocket_img}">
			</div>
			
			<div class="col-md-7">
				<table class="table">
					<tr>
						<td width="100px">로켓명</td>
						<td>${rocketReserveInfo.rocket_name}</td>
					</tr>
					<tr>
						<td>가격</td>
						<td>${rocketReserveInfo.rocket_price}억</td>
					</tr>
					<tr>
						<td>로켓 정원</td>
						<td>${rocketReserveInfo.rocket_usepeople}</td>
					</tr>
					<tr>
						<td>로켓회사</td>
						<td>${rocketReserveInfo.rocket_company}</td>
					</tr>
					<tr>
						<td>국적</td>
						<td>${rocketReserveInfo.rocket_nation}</td>
					</tr>
					<tr>
						<td>정보</td>
						<td>${rocketReserveInfo.rocket_info}</td>
					</tr>
					
					<c:if test="${not empty something}">
					<tr>
						<td>옵션정보</td>
						<td>${rocketReserveInfo.rocket_info}</td>
					</tr>
					
					</c:if>
				</table>
				<a href="${root }shop/rocketOption?rocket_idx=${rocketReserveInfo.rocket_idx}" class="btn btn-primary">옵션선택</a>	
				<a href="${root }shop/reserveRocket?id=${rocketReserveInfo.rocket_idx}" class="btn btn-primary">예약하기</a>
			</div>
		</div>



<c:import url="/WEB-INF/views/include/footer.jsp" />
 