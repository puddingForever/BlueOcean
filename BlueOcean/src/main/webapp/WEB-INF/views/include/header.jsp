<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블루오션 🚀 Mission To Space 🚀</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="../resources/styles/bootstrap.min.css">

<style>
.container{
color:#CFD8DC;
text-decoration: none ;
}

a{
    text-decoration: inherit;
    color:inherit;
}
</style>

</head>
<body>

	<div class="alert alert-primary">
		<div class="container">
			<a href="${root}main" style="text-decoration:none"><h1>Blue Ocean</h1></a>
		</div>
	</div>

	<div class="container">
		 <a href="${root}main/aboutUs">&nbsp;&nbsp;About us</a> &nbsp; &nbsp;|
		  <a href="${root}live/mars">&nbsp; &nbsp;<spring:message code='label.rover' /></a> &nbsp; &nbsp;| 
			<a href="${root}live/live">&nbsp; &nbsp;<spring:message code='label.live' /></a> &nbsp; &nbsp;|   
		  <a href="${root}user/login">&nbsp; &nbsp;<spring:message code='label.login'/></a>	&nbsp; &nbsp;| 
		  <a href="${root}user/join">&nbsp; &nbsp;<spring:message code='label.join' /></a> &nbsp; &nbsp;|
		<a href="${root}user/modify">&nbsp; &nbsp;<spring:message code='label.modify' /></a>	&nbsp; &nbsp;| 
		 <a href="${root}board/main">&nbsp; &nbsp;<spring:message code='label.board'/></a> &nbsp; &nbsp;|  		
			   <a href="${root}user/logout">&nbsp; &nbsp;<spring:message code='label.logout'/></a>	&nbsp; &nbsp;|  
	
	</div>

	<div class="container" style="min-height: 550px;">