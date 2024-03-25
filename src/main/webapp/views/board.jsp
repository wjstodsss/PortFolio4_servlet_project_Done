<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>꼴뚜기의 첫번째 프로젝트</title>
    <link href="/resources/css/reset.css" rel="stylesheet">
    <link href="/resources/css/main.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="../resources/css/member_login.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="../resources/js/member_login.js"></script>
    <script src="../resources/js/board_util.js"></script>
    <style>
        /* 네비게이션 바 스타일 */
        .sidebar {
            left: 0;
            width: 200px;
            background-color: #f5f5f5;
            padding: 20px;
            border-right: 1px solid #ddd;
            height: calc(100% - 100px); /* 뷰포트 높이에서 헤더의 높이를 뺀 값만큼 높이 설정 */
            overflow-y: auto; /* 네비게이션 바가 넘치면 스크롤 표시 */
        }
        .main-content {
            margin-left: 200px; /* 네비게이션 바의 너비만큼 우측으로 이동 */
        }
        
        .board-content {
        	width: 980px;
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
					<li><input type="button" value="로그인" id="loginButton" class="header-nav"></li>
					<li>|</li>
					<li><input type="button" class="header-nav" onclick="goToRegisterForm()" value='회원가입'></li>
					<li>|</li>
					<li><input type="button" class="header-nav" onclick="goToBoard()" value='고객센터'></li>
					<li>|</li>
					<li><a href="#" class="header-nav">주문조회</a></li>
					<li>|</li>
					<li><a href="#" id="cartBold" class="header-nav">장바구니</a></li>
					<li>|</li>
					<li><input type="button"  id="loginButton"  onclick="goToAdminPage()" class="header-nav" value='관리자'></li>
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

<section class="board-content">
 <!-- 네비게이션 사이드바 -->
    <div class="sidebar">
        <ul class="nav flex-column">
            <li class="nav-item"><input type="button" class="header-nav" onclick="fetchBoardList('notice')" value='공지사항'></li>
            <li class="nav-item"><input type="button" class="header-nav" onclick="fetchBoardList('qna')" value='Q&A'></li>
            <li class="nav-item"><input type="button" class="header-nav" onclick="fetchBoardList('faq')" value='자주하는 질문'></li>
            <li class="nav-item"><input type="button" class="header-nav" onclick="fetchBoardList('review')" value='상품후기'></li>
        </ul>
    </div>

   

    <!-- 게시판 컨텐츠 -->
    <div class="main-content" id="boardListContainer">
  
    </div>
</section>

</body>
</html>
