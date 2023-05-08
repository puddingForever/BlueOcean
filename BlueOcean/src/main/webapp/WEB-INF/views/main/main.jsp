<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<c:import url="/WEB-INF/views/include/header.jsp"></c:import>


<%--css--%>
<link rel="stylesheet" type="text/css"
	href="./resources/styles/mainPage.css">

<div class="main-wrap">

	<div class="main-text">
		<spring:message code="main.title"/> <spring:message code="main.name"/>
		<div class="main-text2">
		<spring:message code="main.one"/> &nbsp; &nbsp;&nbsp; <spring:message code="main.two" />
	</div>
	</div>
	
	


	<div class="main-image">
		<img id="myImg" src="./resources/images/nasaspace.jpg">
	</div>

</div>

<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>


