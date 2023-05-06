<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/views/include/header.jsp" />
<c:set var="root" value="${pageContext.request.contextPath }/" />

<div class="container" style="padding:10px">
<div class="title" style="padding:10px">

<strong>ROVER?</strong><br/>
미국항공우주국(NASA)이 보낸 화성탐사 로봇(Mars rovers)은 화성 표면을 검사하는 기차입니다.<br>
5개의 성공적으로 운용되는 Rover들이 있으며,현재 미국항공우주국(NASA)에서는 Curiosity라는 Rover가 
촬영한 사진들을 무료로 제공하고 있습니다.
<br><br>
<strong>SOL?</strong><br>
화성의 하루는 지구의 하루인 24시간에 37분 22초 더해지며, 이를 sol(solar day)라고 부릅니다.<br>
Curiosty의 화성 도착일은 <strong>2012년 8월 6일</strong>이며 화성에서의 sol을 계산해보면 현재까지 <strong>${diff}일</strong>을 지냈습니다.<br>

이 프로그램은 Curiosity가 도착한 날인 1일부터 1000일까지의 사진들을 보여줍니다.
다음의 칸에 원하는 날을 숫자로 입력하시고 확인버튼을 누르면 Curiosity가 촬영한 이미지들이 나옵니다<br/><br/>
<form method="get" id="solType">
<div class="form-group">
<label>Sol 선택(화성의 하루)</label><br/>
<input type="number" name="marsSol" min="0" max="1000" style="width:200px"/> &nbsp;
<button type="submit" class="btn btn-primary">확인</button>
</div>
</form>
</div>




<c:forEach var="photos" items="${roverData.photos}" varStatus="status" begin="0" end="${arrSize}" >
   <img src="${photos.img_src }" width="400px" height="300px" style="padding:10px"/>
</c:forEach>
</div>


<c:import url="/WEB-INF/views/include/footer.jsp" />