<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/include/header.jsp" />
<c:set var='root' value='${pageContext.request.contextPath }/' />

<div class="container" style="margin-top:100px">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="card shadow">
				<div class="card-body">
					<div class="form-group">
						<input type="hidden" id="board_idx" value="${readBoardBean.board_idx }" />
						<label for="board_writer_name">작성자</label>
						<input type="text" id="board_writer_name" name="board_writer_name" class="form-control" value="${readBoardBean.board_writer_name }" disabled="disabled"/>
					</div>
					<div class="form-group">
						<label for="board_date">작성날짜</label>
						<input type="text" id="board_date" name="board_date" class="form-control" value="${readBoardBean.board_date }" disabled="disabled"/>
					</div>
					<div class="form-group">
						<label for="board_subject">제목</label>
						<input type="text" id="board_subject" name="board_subject" class="form-control" value="${readBoardBean.board_subject }" disabled="disabled"/>
					</div>
					<div class="form-group">
						<label for="board_content">내용</label>
						<textarea id="board_content" name="board_content" class="form-control" rows="10" style="resize:none" disabled="disabled">${readBoardBean.board_text }</textarea>
					</div>
					<c:if test="${readBoardBean.board_file != null }">
					<div class="form-group">	
						<label for="board_file">첨부 이미지</label>
						<img src="${root }upload/${readBoardBean.board_file}" width="100%"/>							
					</div>
					</c:if>	
					<div class="form-group">
						<div class="text-right">
							<a href="${root}board/main" class="btn btn-primary">목록보기</a>
							<c:if test="${loginUserBean.user_idx == readBoardBean.board_writer_idx}">
							<a href="${root}board/modify?board_idx=${board_idx}" class="btn btn-info">수정하기</a>
							<a href="${root}board/delete?board_idx=${board_idx}" class="btn btn-danger">삭제하기</a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>

<div class="card">
  <div class="card-body">
    <h5 class="card-title">댓글작성</h5>
    <p class="card-text"><textarea class="form-control" id="comment" name="comment" rows="3"></textarea></p>
    <button type="button" class="btn btn-primary" id="writeComment" >댓글작성</button>
  </div>
</div>


<div class="card">
  <div class="card-body">
    <h5 class="card-title">댓글</h5>
    <div id="commentList" >
    </div>
  </div>
</div>



<script>
/* 댓글*/
$("#writeComment").on("click",function(){

	saveComment();
	commentList();
	
})


/*댓글 저장*/
function saveComment(){
	
	var comment = $("#comment").val();
	var board_idx = $("#board_idx").val();
	
	var comment_writer= '${loginUserBean.user_name}'
	
	if(comment.length==0){
		alert("댓글을 입력해주세요");
		return;
	}

	
	var params = {
					comment_board_idx : board_idx,
					comment_text : comment,
					comment_writer : comment_writer }
	
	
	$.ajax({ 
		url:"${root}saveComment",
		type:"post",
		contentType: 'application/json',
		data:JSON.stringify(params),
		success:function(data){
			alert("등록이 완료되었습니다")
			
		}
	})//end-ajax
}
	
function commentList(){
	
	$.ajax({
		url:"${root}commentList",
		type:"get",
		dataType:"json",
		success:function(data){
				
				for(commentInfo of data.commentList){
					$("#commentList").append(
							"<p> 작성자: "+commentInfo.comment_writer+"</p>"+
							"<p> 댓글 : "+commentInfo.comment_text+"</p>"+
							"<p> 작성일 : "+commentInfo.comment_date+"</p>"+
							"<hr>"
					)//end-append
					
				}//end-for
		}//end-success	
		
	})
	
}//end-commentlist	

</script>
<c:import url="/WEB-INF/views/include/footer.jsp" />

