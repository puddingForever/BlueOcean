<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/include/header.jsp" />

<h3> ${userName}님의 프로필</h3>
<hr>


		<div class="row">
			<div class="col-md-5">
				<img class="img-thumbnail" src="${artPlanet}">
			</div>
			
			<div class="col-md-7">
				<table class="table">
					<tr>
						<td>이름</td>
						<td>${contact.name}</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td>${contact.email}</td>
					</tr>
					<tr>
						<td>번호</td>
						<td>${contact.phone}</td>
					</tr>
					<tr>
						<td>아바타</td>
						<td>${contact.avatar}</td>
					</tr>
					<tr>
						<td>주소</td>
						<td>${contact.address}</td>
					</tr>
					<tr>
						<td>국가</td>
						<td>${contact.country}</td>
					</tr>
				</table>
				
				<a href="./edit-and-update-contact?id=${contact.id}" class="btn btn-primary">수정하기</a>
				<a href="./delete-contact?id=${contact.id}" class="btn btn-outline-danger">삭제하기</a>
			</div>
		</div>
		
<c:import url="/WEB-INF/views/include/footer.jsp" />
