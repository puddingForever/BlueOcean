<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
<c:set var='root' value="${pageContext.request.contextPath }/" />

<div class="container" style="margin-top:100px">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="card shadow">
				<div class="card-body">
					<form action="${root }board/read" method="get">
						<div class="form-group">
							<label for="board_writer_name">작성자</label>
							<input type="text" id="board_writer_name" name="board_writer_name" class="form-control" value="홍길동" disabled="disabled"/>
						</div>
						<div class="form-group">
							<label for="board_date">작성날짜</label>
							<input type="text" id="board_date" name="board_date" class="form-control" value="2018-7-20" disabled="disabled"/>
						</div>
						<div class="form-group">
							<label for="board_subject">제목</label>
							<input type="text" id="board_subject" name="board_subject" class="form-control" value="제목입니다"/>
						</div>
						<div class="form-group">
							<label for="board_content">내용</label>
							<textarea id="board_content" name="board_content" class="form-control" rows="10" style="resize:none">본문입니다</textarea>
						</div>
						<div class="form-group">
							<label for="board_file">첨부 이미지</label>
							<img src="${root }/resources/images/space.jpg" width="100%"/>	
							<input type="file" name="board_file" id="board_file" class="form-control" accept="image/*"/>					
						</div>
						<div class="form-group">
							<div class="text-right">
								<button type="submit" class="btn btn-primary">수정완료</button>
								<a href="${root }board/read" class="btn btn-info">취소</a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>













<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>