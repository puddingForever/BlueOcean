<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url = "/WEB-INF/views/include/header.jsp"></c:import>

<link rel="stylesheet" type="text/css"
	href="./resources/styles/spaceInfo.css">

<div class="main">

실시간 우주 뉴스 !!

${yesterday}~ ${today} 접근 소행성의 갯수 : ${asteroidsData.element_count }



</div>
<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>