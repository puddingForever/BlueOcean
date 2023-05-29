<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<c:import url="/WEB-INF/views/include/header.jsp" />


인기 로켓 상품 
<table width="1000" style="padding:20px">
	<tr height="300" align="center">
		
			<c:forEach var="rocket" begin="0" end="2" items="${rocketList }">
			<td>
				<a href="${root }shop/rocketReserveInfo?rocketIdx=${rocket.rocket_idx}">
				<img alt="" src="${root }resources/rockets/${rocket.rocket_img}" width="300" style="padding:20px"/>
				</a>
				<p> 로켓명 : ${rocket.rocket_name } </p>
			</td>		
			</c:forEach>
	</tr>
</table>

<hr color="black" size="3">
	<font size="4" color="grey">로켓 검색하기</font>
	<form action="${root }shop/rocketReserveInfo" method="get" >
	<select class="form-select" name="rocket_idx">
		<c:forEach var="rocket" items="${rocketList }" varStatus="status" >
			<option value="${rocket.rocket_idx}">${rocket.rocket_name }</option>
		</c:forEach>
	</select>
			<button type="submit" class="btn btn-primary">검색하기</button>
 	</form>

<c:import url="/WEB-INF/views/include/footer.jsp" />

