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
				<button id="btn-back" class="btn btn-secondary mx-1" onclick="history.back()">돌아가기</button>
				<c:if test="${principal.username == post.user.username}">
					<button id="btn-edit" class="btn btn-warning mx-1"  onclick="location.href='/post/updatePost/${post.id}'">수정하기</button>
					<button id="btn-delete" class="btn btn-danger mx-1" onclick="location.href='/post/deletePost/${post.id}'">삭제하기</button>
				</c:if>
			</div>
		</div>
	</div>
</div>

<%@ include file="../layout/footer.jsp"%>