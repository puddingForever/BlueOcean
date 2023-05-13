<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }/" />
<c:import url = "/WEB-INF/views/include/header.jsp"></c:import>

<link rel="stylesheet" type="text/css"
	href="./resources/styles/spaceInfo.css">

<div class="main" style="padding:20px">


<div class="contents" style="padding:20px">
<h5>Astronomy Picture of the Day(APOD)는 NASA에서 제공하는 오늘의 우주 사진을 제공합니다!</h5>
<h5>이미지를 저장하고 프로필 사진으로 지정해보세요 !</h5><br>
<strong>작품제목 : ${artData.title }</strong> <br>
<img src="${artData.url }" style="width:800px;"/> <br><br>
촬영날짜 : ${artData.date }<br/>
작가 : ${artData.copyright }<br/>
설명 : ${artData.explanation }<br/>
<form:form method="post" action="${contextPath }live/addtArt"  modelAttribute="nasaBean" > <br>
<input type="hidden" name="nasa_url" value="${artData.url }" />
<br>
<form:button type="submit" class="btn btn-primary">프로필설정</form:button>
</form:form>
</div>


</div>
<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>