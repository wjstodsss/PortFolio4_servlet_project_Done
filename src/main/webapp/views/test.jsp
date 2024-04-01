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
			<button onclick="createSubPage(this.id)" id="0">하루반찬세트</button>
			<nav>
				<ul>
					<li><a href="#" class="jingaTitle"
						onclick="printCategoryManager (InformationExtractor.productList, SIGNBANCHAN, 'subPages')">진가네
							시그니처</a></li>
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
				</ul>
			</nav>
			<p>
				|<span><a href="#" class="jingaTitle"
					onclick="createSubPage(this.id)" id="9">반찬도매</a></span>
			</p>
		</div>
	</header>
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
</script>

</html>