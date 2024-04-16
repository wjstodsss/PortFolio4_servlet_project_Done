<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@include file="../includes/head_set.jsp"%>
<%@include file="../includes/body_init.jsp"%>
<%@include file="../includes/header.jsp"%>

	<div class="board-back">
		<div class="board-wrap">
			<!-- 네비게이션 사이드바 -->
			<div class="main-content" id="boardListContainer">
				<div class="row">
					<div class="col">
						<ul class="nav flex-column nav-side">
							<li class="nav-item"><input type="button" class="side-nav"
								onclick="fetchBoardList('notice')" value='공지사항'></li>
							<li class="nav-item"><input type="button" class="side-nav"
								onclick="fetchBoardList('qna')" value='Q&A'></li>
							<li class="nav-item"><input type="button" class="side-nav"
								onclick="fetchBoardList('faq')" value='자주하는 질문'></li>
							<li class="nav-item"><input type="button" class="side-nav"
								onclick="fetchBoardList('review')" value='상품후기'></li>
						</ul>
					</div>

					<input type="hidden" id="navTitle" value="notice">

					<!-- 게시판 컨텐츠 -->
					<div class="col-9">
						<div class="col text-right">

							<button onclick="goToModalForm()" class="btn btn-primary"
								id="newPostBtn">게시물 등록</button>
						</div>
						<h2 class="my-4" id="boardTitle"></h2>

						<div class="row">
							<div class="col">
								<table class="table table-striped" id="postTable">
									<thead>
										<tr>
											<th scope="col">번호</th>
											<th scope="col">제목</th>
											<th scope="col">작성자</th>
											<th scope="col">작성일</th>
										</tr>
									</thead>
									<tbody id="postListBody">
										<!-- 여기에 서버에서 받아온 게시물이 동적으로 추가됩니다 -->
									</tbody>
								</table>
								<div class="pageContainer" id="pagination"></div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- 게시물 등록 모달창 -->
	<div class="modal fade" id="formModal" tabindex="-1" role="dialog"
		aria-labelledby="cartModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="cartModalLabel">자주하는 질문</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form name="frm" enctype="multipart/form-data" method="post">


						<div class="form-group">
							<label for="title">제목 *</label> <input type="text"
								class="form-control" id="title" name="title" required>
						</div>

						<div class="form-group">
							<label for="username">작성자 *</label> <input type="text"
								class="form-control" id="username" name="author" required>
						</div>

						<div class="form-group">
							<label for="pass">비밀번호 *</label> <input type="password"
								class="form-control" id="pass" name="password" required>
							<small class="form-text text-muted">게시물 수정 삭제시 필요합니다.</small>
						</div>

						<div class="form-group" id="upload">
							<label for="imageUrl" id="picture">사진</label> <input type="file"
								class="form-control" id="imageUrl" name="imageUrl"
								onchange="previewImage(event)" accept="image/*"> <img
								id="imagePreview" class="img-fluid" style="display: none;">
						</div>


						<div class="form-group">
							<label for="content">내용</label>
							<textarea class="form-control" id="content" name="content"
								rows="5"></textarea>
						</div>
						<button type="submit" class="btn btn-primary"
							onclick="goToWriteAction()">등록</button>
						<button type="reset" class="btn btn-secondary">다시 작성</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">닫기</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- 게시물 수정 X 삭제 모달창 -->
	<div class="modal fade" id="detailFormModal" tabindex="-1"
		role="dialog" aria-labelledby="cartModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="cartModalLabel">자주하는 질문</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form name="updateFrm" enctype="multipart/form-data" method="post"
						onsubmit="doAction()">
						<input type="hidden" id="detailId" value="" name="detailId">
						<input type="hidden" id="detailPassword" value=""
							name="detailPassword"> <input type="hidden"
							name="nonmakeImg" id="nonmakeImg">

						<div class="form-group">
							<label for="title">제목 *</label> <input type="text"
								class="form-control" id="detailTitle" name="detailTitle"
								required>
						</div>

						<div class="form-group">
							<label for="username">작성자 *</label> <input type="text"
								class="form-control" id="detailAuthor" name="detailAuthor"
								required>
						</div>

						<div class="form-group" id="detailUpload">
							<label for="updateImage" id="updateImageLabel">사진</label> <input
								type="file" class="form-control" id="updateImage"
								name="detailImageUrl" onchange="previewImage(event)"
								accept="image/*" src=""> <img id="detailImageUrl">
						</div>


						<div class="form-group">
							<label for="content">내용</label>
							<textarea class="form-control" id="detailContent"
								name="detailContent" rows="5"></textarea>
						</div>

						<div class="form-group">
							<label for="pass">비밀번호</label> <input type="password"
								class="form-control" id="checkPasswordRef"
								name="checkPasswordRef"> <small
								class="form-text text-muted">수정이나 삭제를 원하시면 비밀번호를 입력해 주세요</small>
						</div>

						<button type="button" class="btn btn-primary"
							onclick="doAction('update')">수정하기</button>
						<button type="button" class="btn btn-primary"
							onclick="doAction('delete')">삭제하기</button>
						<button type="reset" class="btn btn-secondary">다시 작성</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">닫기</button>
					</form>
				</div>
			</div>
		</div>
	</div>


<%@include file="../includes/cart.jsp"%>
<%@include file="../includes/footer.jsp"%>