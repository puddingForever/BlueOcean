<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<c:import url="/WEB-INF/views/include/header.jsp" />

<h3>예약확인</h3>


<h2>총 예약 정보입니다.</h2>
<div class ="form-group row" style="margin: 15px 25px 15px 0px;">
	<label for="" class="col-md-4"></label>
	<div class="col-md-8">
		보험비 : ${totalPrice.insurance}
	</div>
</div>

<div class ="form-group row" style="margin: 15px 25px 15px 0px;">
	<label for="" class="col-md-4"></label>
	<div class="col-md-8">
		보험비 : ${totalPrice.insurance}
	</div>
</div>



로켓명 : 
로켓 비용 :  
보험비 : ${totalPrice.insurance}
가이드비용 : ${totalPrice.guide }
식사 : ${totalPrice.food_price }
총 옵션 비용 : ${totalPrice.insurance + totalPrice.guide + totalPrice.food_price }






<c:import url="/WEB-INF/views/include/footer.jsp" />

