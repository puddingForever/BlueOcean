<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css"
	href="../resources/styles/bootstrap.min.css">
<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
<c:set var='root' value="${pageContext.request.contextPath }/"/>

<!-- 게시글 리스트 -->
<div class="container" style="margin-top:100px">
	<div class="card shadow">	
		<div class="card-body">
			<h4 class="card-title">&nbsp; 후기게시판</h4>	
			<table class="table table-hover" id='board_list'>
				<thead>
					<tr>
						<th class="text-center d-none d-md-table-cell">글번호</th>
						<th class="w-50">제목</th>
						<th class="text-center d-none d-md-table-cell">작성자</th>
						<th class="text-center d-none d-md-table-cell">작성날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var='obj' items="${boardList}">
						<tr>
						<td class="text-center d-none d-md-table-cell">${obj.board_idx }</td>
						<td><a href='${root }board/read?board_idx=${obj.board_idx}'>${obj.board_subject }</a></td>
						<td class="text-center d-none d-md-table-cell">${obj.board_writer_name }</td>
						<td class="text-center d-none d-md-table-cell">${obj.board_date }</td>
						
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div class="d-none d-md-block">
				<ul class="pagination justify-content-center">
					<c:choose>
						<c:when test="${pageBean.prevPage <=0 }">
						<li class="page-item disabled">
							<a href="#" class="page-link">이전</a>
						</li>
						</c:when>
						<c:otherwise>
						<li class="page-item">
							<a href="${root }board/main?page=${pageBean.prevPage}" class="page-link">이전</a>
						</li>
						</c:otherwise>
					</c:choose>
					
					<c:forEach var="idx" begin="${pageBean.min }" end="${pageBean.max }">
					<c:choose>
					<c:when test="${idx == pageBean.currentPage }">
					<li class="page-item active">
						<a href="${root }board/main?page=${idx}" class="page-link">${idx }</a>
					</li>
					</c:when>
					<c:otherwise>
					<li class="page-item">
						<a href="${root }board/main?page=${idx}" class="page-link">${idx }</a>
					</li>
					</c:otherwise>	
					</c:choose>	
					</c:forEach>
					
					<c:choose>
						<c:when test="${pageBean.max>=pageBean.pageCnt }">
						<li class="page-item disabled">
							<a href="#" class="page-link">다음</a>
						</li>
						</c:when>
						<c:otherwise>
						<li class="page-item">
							<a href="${root }board/main?page=${pageBean.nextPage}" class="page-link">다음</a>
						</li>
						
						</c:otherwise>
					</c:choose>
					
				</ul>
			</div>
			
			
			<div class="text-right">
				<a href="${root}board/write" class="btn btn-primary">글쓰기</a>
			</div>
			
		</div>
	</div>
</div>







<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>