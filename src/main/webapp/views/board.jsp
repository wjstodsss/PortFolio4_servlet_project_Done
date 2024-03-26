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
<script src="../resources/js/product.js"></script>
<script src="../resources/js/member_join2.js"></script>
<style>
/* 네비게이션 바 스타일 */
.main-content {
	
}

.board-content {
	width: 980px;
	margin: 0 auto;
}

.board-back {
	justify-content: center;;
}

.board-wrap {
	width: 980px;
	margin: 0 auto;
}
.nav-side {
	height: 100%;
	background-color: #eee;
}

.side-nav {
    font-size: 1rem;
    font-family: "Noto Sans KR", dotum, 돋움, gulim, 굴림, sans-serif;
    color: rgb(0, 0, 0);
    background-color: #eeeeee;
    margin: 10px 5px;
    font-weight: 600;
    board-bottom: 1px solid white;
}

.nav-item {
	text-align: center;
}

</style>
</head>
<body onload="checkLoginState();">

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

			<div onclick="goToIndex()" id="logo">
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
			<button onclick="handleClick(this)" id="0">하루반찬세트</button>
			<nav>
				<ul>
					<li><a href="#" class="jingaTitle"
						>진가네
							시그니처</a></li>
					<li><a href="#" class="jingaTitle" onclick="handleClick(this)"
						id="1">진가네 명품김치</a></li>
					<li><a href="#" class="jingaTitle" onclick="handleClick(this)"
						id="2">밑반찬</a></li>
					<li><a href="#" class="jingaTitle" onclick="handleClick(this)"
						id="3">국·찌개 </a></li>
					<li><a href="#" class="jingaTitle" onclick="handleClick(this)"
						id="4">메인반찬</a></li>
					<li><a href="#" class="jingaTitle" onclick="handleClick(this)"
						id="5">전</a></li>
					<li><a href="#" class="jingaTitle" onclick="handleClick(this)"
						id="6">나물반찬</a></li>
					<li><a href="#" class="jingaTitle" onclick="handleClick(this)"
						id="7">장아찌</a></li>
					<li><a href="#" class="jingaTitle" onclick="handleClick(this)"
						id="8">대용량</a></li>
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



					<!-- 게시판 컨텐츠 -->
					<div class="col-9">
						<div class="col text-right">
							<a href="#" class="btn btn-primary" id="newPostBtn">게시물 등록</a>
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
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<footer id="footer">
		<div id="info01">
			<img src="/resources/img/footer/footer001.png" alt="배송안내">
		</div>

		<div id="info02">
			<p>공지사항</p>
			<div id="footerSlider"></div>
		</div>
		<div id="info03">
			<p>가이드</p>
			<div>
				<img src="/resources/img/footer/footer002.png" alt="배송" class="icon">
				<p>배송안내</p>
			</div>
			<div>
				<img src="/resources/img/footer/footer003.png" alt="혜택" class="icon">
				<p>첫구매혜택</p>
			</div>
			<div>
				<img src="/resources/img/footer/footer004.png" alt="고객센터"
					class="icon">
				<p>고객센터</p>
			</div>
		</div>
		<div id="footerBottom">
			<p id="top">
				<a href="#">이용약관</a> <a href="#">개인정보처리방침</a>
			</p>


			<p id="middle1">
				주식회사진가네| 대표이사 : 진성엽| 사업자등록번호 : 611-87-00645 [사업자 정보확인]| 통신판매업신고 :
				2018-대구동구-0813호<br> 주소 : 대구광역시 동구 반야월북로2길16-6|
				대표번호:1899-7143|개인정보담당자 : 우윤화|이메일 : wooyouna@naver.com<br> 고객님의
				안전거래를 위해 현금 등으로 결제 시 kg이니시스의 구매안전 서비스를 이용하실 수 있습니다.
			</p>
			<img src="/resources/img/footer/footer005.png" alt="관련업체">
			<p id="right">
				<span>고객센터 & 단체구매문의</span><br> <span id="tel">1899-7143</span><br>
				평일 09:00~16:00<br> 점심시간 11:30~12:30<br> 토·일요일/공휴일 휴무
			</p>
		</div>
	</footer>
</body>
<script>
/* 공지사항 
v0.01: 240110 setInterval함수를 활용하여 추가한 기능, 정해진 공지사항이 시간 마다 변경 
*/
let news = ["아이스팩 변경 공지드립니다.     2022-03-21", "진가네반찬 등급별안내     2019-07-02", "진가네반찬 배송안내     2018-12-19"]
let index = 0;
function newsBoard() {

    document.getElementById("footerSlider").innerHTML = news[index];
    index++;
    if (index >= news.length) index = 0;
}

let boardSetInterval;
function startBoardInterval() {
    let boardSetInterval = setInterval(newsBoard, 2000);
}

function stopBoardInterval() {
    clearInterval(boardSetInterval, 2000);
}
</script>
</html>