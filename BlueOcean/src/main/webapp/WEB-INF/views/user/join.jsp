<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
<c:set var='root' value="${pageContext.request.contextPath }/" />

<script>
	function checkUserIdExist(){
		
		var user_id = $("#user_id").val();
		
		if(user_id.length==0){
			alert("아이디를 입력해주세요")
			return
		}
		
		$.ajax({
			url: '${root}user/checkUserIdExist/' + user_id,
			type: 'get',
			dataType : 'text',
			success : function(result){
				if(result.trim()=='true'){
					alert("사용할 수 있는 아이디입니다.")
					$("#userIdExist").val('true')
				}else{
					alert("사용할 수 없는 아이디입니다.")
					$("#userIdExist").val('false')
				}
			}
			
		})
		
		/* 중복확인 후 , 새로 입력하면 중복확인을 다시 해야함  */
		function resetUserIdExist(){
			
			$("#userIdExist").val('false')
		}
		
		
	}

</script>
<h3>회원가입</h3>
<div class="container" style="margin-top:100px">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="card shadow">
				<div class="card-body">
				<form:form action="${root }user/join_pro" method='post' modelAttribute="joinUserBean">
						<form:hidden path="userIdExist"/>
						<div class="form-group">
							<form:label path="user_name">이름</form:label>
							<form:input path="user_name" class="form-control" />
							<form:errors path="user_name" style="color:red" />
						</div>
						<div class="form-group">
							<form:label path="user_id">아이디</form:label>
							<div class="input-group">
								<form:input path="user_id" class="form-control" onkeypress="resetUserIdExist()"/>
								<div class="input-group-append">
									<button type="button" class="btn btn-primary" onclick='checkUserIdExist()'>중복확인</button>
								</div>
							</div>
							<form:errors path="user_id" />
						</div>
						<div class="form-group">
							<form:label path="user_nation">국가</form:label>
							<form:input path="user_nation" class="form-control" />
							<form:errors path="user_nation" style="color:red"/>
						</div>
						<div class="form-group">
							<form:label path="user_pw">비밀번호</form:label>
							<form:password path="user_pw" class="form-control" />
							<form:errors path="user_pw" style="color:red" />
						</div>
						<div class="form-group">
							<form:label path="user_pw2">비밀번호 확인</form:label>
							<form:password path="user_pw2" class="form-control" />
							<form:errors path="user_pw2" style="color:red"/>
						</div>
						<div class="form-group">
							<div class="text-right">
								<form:button class="btn btn-primary">회원가입</form:button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>



<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>