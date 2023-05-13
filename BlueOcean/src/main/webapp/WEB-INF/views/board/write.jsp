<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
<c:set var='root' value="${pageContext.request.contextPath }/" />

<div class="container" style="margin-top:100px">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="card shadow">
				<div class="card-body">
					<form:form action="${root }board/write_pro" method="post" modelAttribute="writeBoardBean" enctype="multipart/form-data">
						<form:hidden path="board_idx" />
						<div class="form-group">
							<form:label path="board_subject">제목</form:label>
							<form:input path="board_subject" class="form-control" />
							<form:errors path="board_subject" style="color:red"/>
						</div>
						<div class="form-group">
							<form:label path="board_text">내용</form:label>	
							<form:textarea path="board_text" class="form-control" rows="10" style="resize:none"></form:textarea>			
							<form:errors path="board_text" style="color:red" />
						</div>
						<div class="form-group">
							<form:label path="board_file">첨부 이미지</form:label>
							<form:input type="file" path="upload_file" class="form-control" accept="image/*" />
						</div>
						<div class="form-group">
							<div class="text-right">
								<form:button class="btn btn-primary">작성하기</form:button>
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