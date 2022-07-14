<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="./layout/header.jsp"%>

<div class="container-fluid mt-3">
	<c:if test="${!empty postList }">
		<div class="card">
			<c:forEach var="post" items="${postList.content }">
				<form action="/post/${post.id}" method="post">				
					<div class="card-body">
						<h4 class="card-title">${post.title }</h4>
						<button class="btn btn-secondary" type="submit" id="btn-getPost">상세 보기</button>
					</div>
				</form>
			</c:forEach>
		</div>

		<br>
		<ul class="pagination pagination-lg justify-content-between">
			<li class="page-item <c:if test="${postList.first }">disabled</c:if>">
			<a class="page-link" href="?page=${postList.number - 1 }">이전 페이지</a></li>
			<li class="page-item <c:if test="${postList.last }">disabled</c:if>">
			<a class="page-link" href="?page=${postList.number + 1 }">다음 페이지</a></li>
		</ul>

	</c:if>
</div>

<%@ include file="./layout/footer.jsp"%>