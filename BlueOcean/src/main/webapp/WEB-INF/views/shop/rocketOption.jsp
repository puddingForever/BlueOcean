<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<c:import url="/WEB-INF/views/include/header.jsp" />


<div class="selectList" style="padding:20px">
<h2> 옵션 선택 </h2>
<form:form method="post" action="${root }shop/reserveOption"  modelAttribute="optionBean" >
<form:input type="hidden" path="rocket_idx" value="${rocket_idx}" />
<table class="table">
					<tr>
						<td width="300px">보험사</td>
						<td><form:select path="option_insurance">
							<option value="axa">Axa</option>
							<option value="sky">sky</option>
							<option value="sea">sea</option>
							<option value="spacetrip">spacetrip</option>
							<option value="spaceforever">spaceforever</option>
							<option value="notUse">해당사항없음</option>
							</form:select>
							</td>
							<td> 가격 : <div id="ins_price"></div></td>
					</tr>
					<tr>
						<td>가이드</td>
						<td><form:select path="option_guide">
							<option value="hire">적용</option>
							<option value="notUse">비적용</option>
							</form:select>
						</td>
						<td> 가격 : <div id="guide_price"></div></td>
					</tr>
					<tr>
						<td>식사</td>
						<td><form:select path="option_food">
							<option value="korean">한식</option>
							<option value="western">양식</option>
							<option value="vege">채식</option>
							<option value="notUse">해당사항없음</option>
							</form:select>
						</td>
						<td>가격 : <div id="food_price"></div></td>
					</tr>
					<tr>
						<td style="width:100">기타관련 요청사항을 적어주세요 </td>
						<td>
						<form:textarea class="form-control" path="option_req" rows="3"></form:textarea>
						</td>
					</tr>
				</table>
				
			<a href="${root }shop/rocketReserveInfo?rocket_idx=${rocket_idx}" class="btn btn-primary">되돌아가기</a>			
			<form:button class="btn btn-primary">옵션등록</form:button>			
</form:form>

</div>

<script>


/*보험가격*/
$("#option_insurance").on("change",function(){
	var result = $(this).val();
	if(result == "axa"){
		$("#ins_price").html("<p>10000</p>");
	}else if(result=="sky"){
		$("#ins_price").html("<p>20000</p>");
	}else if(result=="sea"){
		$("#ins_price").html("<p>30000</p>");
	}else if(result=="spacetrip"){
		$("#ins_price").html("<p>40000</p>");
	}else if(result=="spaceforever"){
		$("#ins_price").html("<p>50000</p>");
	}else{
		$("#ins_price").html("<p>0</p>");
	}
})

/*가이드 비용*/
$("#option_guide").on("change",function(){
	var result = $(this).val();
	if(result=="hire"){
		$("#guide_price").html("<p>20000</p>");
	}else{
		$("#guide_price").html("<p>0</p>");
	}
})

/*식사 가격*/
$("#option_food").on("change",function(){
	var result = $(this).val();
	if(result=="korean"){
		$("#food_price").html("<p>10000</p>");
	}else if(result=="western"){
		$("#food_price").html("<p>20000</p>");
	}else if(result=="vege"){
		$("#food_price").html("<p>30000</p>");
	}else if(result=="notUse"){
		$("#food_price").html("<p>40000</p>");
	}
})							
							

</script>			
				
<c:import url="/WEB-INF/views/include/footer.jsp" />

