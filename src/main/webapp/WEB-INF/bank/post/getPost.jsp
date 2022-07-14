<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container mt-5">
	<div class="card">
		<div class="card-body">
			<h2 class="mb-4">${post.title}</h2>

			<div class="mb-5">${post.content }</div>

			<div class="mb-1">
				<label for="post-id">포스트 번호 :</label> <span id="post-id">${post.id }</span>
			</div>

			<div class="mb-3">
				<label for="author">작성자 :</label> <span id="author">${post.user.username }</span>
			</div>
			<hr>
			<div class="d-flex">
				<button id="btn-back" class="btn btn-secondary mx-1" onclick="location.href='/'">돌아가기</button>
				<c:if test="${principal.username == post.user.username}">
					<button id="btn-edit" class="btn btn-warning mx-1" onclick="location.href='/post/updatePost/${post.id}'">수정하기</button>
					<button id="btn-delete" class="btn btn-danger mx-1" onclick="location.href='/post/deletePost/${post.id}'">삭제하기</button>
				</c:if>
			</div>

			<div id="reply-list" class="my-5 ">
				<!-- 댓글이 없으면 숨김 -->
				<c:if test="${post.replyList.size() != 0 }">
					<table class="table table-striped table-hover">
						<tr class="text-start">
							<td style="width: 80%; font-weight: bold;">내용</td>
							<td style="width: 10%; font-weight: bold;">작성자</td>
							<td style="width: 10%; font-weight: bold;"></td>
						</tr>
						<c:forEach var="reply" items="${post.replyList }">
							<tr>
								<td>${reply.content}</td>
								<td>${reply.user.username}</td>
								<td><c:if test="${principal.username == reply.user.username}">
										<button class="btn btn-sm btn-dark" type="button" onclick="deleteReply(${reply.id})">삭제</button>
									</c:if></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>

			<div class="mt-5">
				<form action="/post/${id}/reply/insertReply" method="post">
					<textarea class="w-100" name="content" placeholder="댓글을 입력하세요.."></textarea>
					<div class="d-flex justify-content-end">
						<button class="btn btn-secondary mx-1" type="submit">댓글 등록</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
	function deleteReply(id){
		$.ajax({
			type: "DELETE",
			url: "/reply/replyDelete/"+id,
		}).done(function(res){
			location = res;
		});
	}
</script>

<%@ include file="../layout/footer.jsp"%>