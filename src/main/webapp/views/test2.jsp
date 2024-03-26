<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>꼴뚜기의 첫번째 프로젝트</title>
<link href="/resources/css/reset.css" rel="stylesheet">
<link href="/resources/css/main.css" rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="../resources/css/member_login.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="../resources/js/member_login.js"></script>
<script src="../resources/js/board_util2.js"></script>
<style>
/* 네비게이션 바 스타일 */
.sidebar {
	left: 0;
	width: 200px;
	background-color: #f5f5f5;
	border-right: 1px solid #ddd;
}

.main-content {
	
}

.board-content {
	width: 980px;
	margin: 0 auto;
}

.board-back {
    justify-content: center;
    background-color: antiquewhite;
}

.board-wrap {
    width: 980px;
    background: aquamarine;
    margin: 0 auto;
}


</style>
</head>
<body onload="checkLoginState(); fetchBoardList('notice');">

	<!-- /* header */ -->
	<header>
		<div id="topHeader">
			<div id="appDown">
				<button>진가네 앱 다운로드 ▼</button>
			</div>
			<nav>
				<ul>
					<li><input type="button" value="로그인" id="loginButton"
						class="header-nav"></li>
					<li>|</li>
					<li><input type="button" class="header-nav"
						onclick="goToRegisterForm()" value='회원가입'></li>
					<li>|</li>
					<li><input type="button" class="header-nav"
						onclick="goToBoard()" value='고객센터'></li>
					<li>|</li>
					<li><a href="#" class="header-nav">주문조회</a></li>
					<li>|</li>
					<li><a href="#" id="cartBold" class="header-nav">장바구니</a></li>
					<li>|</li>
					<li><input type="button" id="loginButton"
						onclick="goToAdminPage()" class="header-nav" value='관리자'></li>
				</ul>
			</nav>
		</div>

		<div id="middleHeader">
			<nav>
				<ul>
					<li><a href="#">시그니처</a></li>
					<li>|</li>
					<li><a href="#">반찬후기</a></li>
					<li>|</li>
					<li><a href="#">배송안내</a></li>
				</ul>
			</nav>

			<div onclick="mainPageReload()" id="logo">
				<a href="#"> <img src="/resources/img/header_middle/logo.png"
					alt="진가네로고">
				</a>
			</div>

			<div id="searchInput">
				<input id="inputWord">
				<button id="searchButton"></button>
			</div>
		</div>
		<div id="bottomHeader">
			<button onclick="createSubPage(this.id)" id="0">하루반찬세트</button>
			<nav>
				<ul>
					<li><a href="#" class="jingaTitle"
						onclick="printCategoryManager (InformationExtractor.productList, SIGNBANCHAN, 'subPages')">진가네
							시그니처</a></li>
					<li><a href="#" class="jingaTitle"
						onclick="createSubPage(this.id)" id="1">진가네 명품김치</a></li>
					<li><a href="#" class="jingaTitle"
						onclick="createSubPage(this.id)" id="2">밑반찬</a></li>
					<li><a href="#" class="jingaTitle"
						onclick="createSubPage(this.id)" id="3">국·찌개 </a></li>
					<li><a href="#" class="jingaTitle"
						onclick="createSubPage(this.id)" id="4">메인반찬</a></li>
					<li><a href="#" class="jingaTitle"
						onclick="createSubPage(this.id)" id="5">전</a></li>
					<li><a href="#" class="jingaTitle"
						onclick="createSubPage(this.id)" id="6">나물반찬</a></li>
					<li><a href="#" class="jingaTitle"
						onclick="createSubPage(this.id)" id="7">장아찌</a></li>
					<li><a href="#" class="jingaTitle"
						onclick="createSubPage(this.id)" id="8">대용량</a></li>
				</ul>
			</nav>
			<p>
				|<span><a href="#" class="jingaTitle"
					onclick="createSubPage(this.id)" id="9">반찬도매</a></span>
			</p>
		</div>
	</header>
<div class="board-back">
	<div class="board-wrap">
		<!-- 네비게이션 사이드바 -->
		<div class="main-content" id="boardListContainer">
			<div class="row mt-4">
		
			<ul class="nav flex-column">
				<li class="nav-item"><input type="button" class="header-nav"
					onclick="fetchBoardList('notice')" value='공지사항'></li>
				<li class="nav-item"><input type="button" class="header-nav"
					onclick="fetchBoardList('qna')" value='Q&A'></li>
				<li class="nav-item"><input type="button" class="header-nav"
					onclick="fetchBoardList('faq')" value='자주하는 질문'></li>
				<li class="nav-item"><input type="button" class="header-nav"
					onclick="fetchBoardList('review')" value='상품후기'></li>
			</ul>



		<!-- 게시판 컨텐츠 -->
		
				<div class="col text-right">
					<a href="#" class="btn btn-primary" id="newPostBtn">게시물 등록</a>
				</div>
				<h2 class="my-4">게시판 목록</h2>

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
					</div>
				</div>

			</div>
		</div>

	</div>
</div>
</body>
</html>
