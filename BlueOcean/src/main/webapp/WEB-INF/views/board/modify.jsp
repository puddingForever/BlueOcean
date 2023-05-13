<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

<c:set var='root' value="${pageContext.request.contextPath }/" />

<div class="container" style="margin-top:100px">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="card shadow">
				<div class="card-body">
					<form:form action="${root }board/modify_pro" method="post" modelAttribute="modifyBoardBean" enctype="multipart/form-data">
						<form:hidden path="board_idx" />
						<div class="form-group">
							<form:label path="board_writer_name">작성자</form:label> <!--  -->
							<form:input path="board_writer_name" class="form-control" readonly="true" />
						</div>
						<div class="form-group">
							<form:label path="board_date">작성날짜</form:label>
							<form:input path="board_date" class="form-control" readonly="true"/>
						</div>
						<div class="form-group">
							<form:label path="board_subject">제목</form:label>
							<form:input path="board_subject" class="form-control" />
							<form:errors path="board_subject" style="color:red" />
						</div>
						<div class="form-group">
							<form:label path="board_text">내용</form:label>
							<form:textarea path="board_text" class="form-control" rows="10" style="resize:none" />
							<form:errors path="board_text" style="color:red"/>
						</div>
						<div class="form-group">
							<label for="board_file">첨부 이미지</label>
							<c:if test="${modifyBoardBean.board_file != null }">
							<img src="${root }upload/${modifyBoardBean.board_file}" width="100%"/>	
							<form:hidden path="board_file" />
							</c:if>
							<form:input path="upload_file" type="file" class="form-control" accept="image/*" />
						</div>
						<div class="form-group">
							<div class="text-right">
								<form:button class="btn btn-primary">수정완료</form:button>
								<a href="${root }board/read?board_idx=${board_idx}" class="btn btn-info">취소</a>
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