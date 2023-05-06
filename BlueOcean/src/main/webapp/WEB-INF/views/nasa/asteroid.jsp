<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url = "/WEB-INF/views/include/header.jsp"></c:import>

<link rel="stylesheet" type="text/css"
	href="./resources/styles/spaceInfo.css">

<div class="main">

<div id="time">
${requestScope.today}
</div>

<div id="astroid">
지구 접근 소행성 : ${requestScope.element_count}개
</div>
</div>
<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>