<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Grid Layout</title>
<link href="/resources/css/test.css" rel="stylesheet" />
<link href="/resources/css/main.css" rel="stylesheet" />
<link href="/resources/css/reset.css" rel="stylesheet" />
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> develop

<!-- 부트스트랩 CSS 링크 -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery 스크립트 링크 -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<style>
    /* 컨테이너의 최대 크기 설정 */
    .container {
        max-width: 980px;
    }

    /* 상품 카드 간격 설정 */
    .mb-3 {
        margin-bottom: 15px;
    }
</style>
<<<<<<< HEAD
=======
=======
>>>>>>> develop
>>>>>>> develop
</head>
<body>

	<!-- /* top banner */ -->
	<div id="topBanner">
		<a> <img src="/resources/img/top_banner/top_banner.jpg">
		</a>
		<button id="topClose"></button>
	</div>

	<!-- /* header */ -->
	<header>
		<div id="topHeader">
			<div id="appDown">
				<button>진가네 앱 다운로드 ▼</button>
			</div>
			<nav>
				<ul>
					<li><a href="#">로그인</a></li>
					<li>|</li>
					<li><a href="#">회원가입</a></li>
					<li>|</li>
					<li><a href="#">고객센터</a></li>
					<li>|</li>
					<li><a href="#">주문조회</a></li>
					<li>|</li>
					<li><a href="#" id="cartBold">장바구니</a></li>
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
<<<<<<< HEAD
			<button onclick="handleClick(this)" id="0">하루반찬세트</button>
=======
<<<<<<< HEAD
			<button onclick="handleClick(this)" id="0">하루반찬세트</button>
=======
			<button onclick="createSubPage(this.id)" id="0">하루반찬세트</button>
>>>>>>> develop
>>>>>>> develop
			<nav>
				<ul>
					<li><a href="#" class="jingaTitle"
						onclick="printCategoryManager (InformationExtractor.productList, SIGNBANCHAN, 'subPages')">진가네
							시그니처</a></li>
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> develop
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
<<<<<<< HEAD
=======
=======
					<li><a href="#" class="jingaTitle"
						onclick="handleClick(this)" id="1">진가네 명품김치</a></li>
					<li><a href="#" class="jingaTitle"
						onclick="handleClick(this)" id="2">밑반찬</a></li>
					<li><a href="#" class="jingaTitle"
						onclick="handleClick(this)" id="3">국·찌개 </a></li>
					<li><a href="#" class="jingaTitle"
						onclick="handleClick(this)" id="4">메인반찬</a></li>
					<li><a href="#" class="jingaTitle"
						onclick="handleClick(this)" id="5">전</a></li>
					<li><a href="#" class="jingaTitle"
						onclick="handleClick(this)" id="6">나물반찬</a></li>
					<li><a href="#" class="jingaTitle"
						onclick="handleClick(this)" id="7">장아찌</a></li>
					<li><a href="#" class="jingaTitle"
						onclick="handleClick(this)" id="8">대용량</a></li>
>>>>>>> develop
>>>>>>> develop
				</ul>
			</nav>
			<p>
				|<span><a href="#" class="jingaTitle"
					onclick="createSubPage(this.id)" id="9">반찬도매</a></span>
			</p>
		</div>
	</header>
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> develop
	<!-- 상품 목록 -->
	<div class="container mt-3">
		<div class="row">
			<!-- 상품 카드를 반복하여 표시 -->
			<c:forEach var="product" items="${productList}">
				<div class="col-md-4 mb-3">
					<div class="card">
						<img src="upload/${product.pictureUrl}" class="card-img-top"
							alt="Product Image">
						<div class="card-body">
							<!-- 상품명 -->
							<h5 class="card-title">${product.productName}</h5>
							<!-- 상품 가격 -->
							<p class="card-text">가격: ${product.price}원</p>
							<!-- 장바구니 버튼 -->
							<button class="btn btn-primary"
								onclick="addToCart(${product.code})">장바구니에 추가</button>
							<!-- 구매 버튼 -->
							<button class="btn btn-success"
								onclick="purchase(${product.code})">구매</button>
						</div>
						<!-- 상품 요약 -->
						<div class="card-footer">
							<small class="text-muted">상품 요약: ${product.description}</small>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>


	<script>

<<<<<<< HEAD
=======
=======
	<section class="section-content">
		<div class="container">
		
				
					
			<c:forEach var="product" items="${productList}">
				<div class="item-container">
					
					
					<div>${product.code}</div>
					<div>${product.productName}</div>
					<div>${product.price}</div>
					<div>${product.category}</div>
					<img src="upload/${product.pictureUrl}">
					<div>${product.description}</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
<script>
>>>>>>> develop
>>>>>>> develop
	function handleClick(element) {
		console.log("ll");
		let valueToSend = element.id;
		let formDTO = document.createElement("form");
		formDTO.setAttribute("method", "post");
		formDTO.setAttribute("action", "banchan?command=test");
		var input = document.createElement("input");
		input.setAttribute("type", "hidden");
		input.setAttribute("name", "category");
		input.setAttribute("value", valueToSend);
		formDTO.appendChild(input);
		document.body.appendChild(formDTO);
		formDTO.submit();
	}
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> develop
    // 장바구니에 상품을 추가하는 함수
    function addToCart(productId) {
        // 여기에 해당 상품을 장바구니에 추가하는 로직을 구현
        alert("상품을 장바구니에 추가합니다. 상품 ID: " + productId);
    }

    // 상품을 구매하는 함수
    function purchase(productId) {
        // 여기에 해당 상품을 구매하는 로직을 구현
        alert("상품을 구매합니다. 상품 ID: " + productId);
    }
</script>
</body>
</html>
<<<<<<< HEAD
=======
=======
</script>

</html>
>>>>>>> develop
>>>>>>> develop
