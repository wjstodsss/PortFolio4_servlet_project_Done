<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>
    function changeColorOnHover(element) {
        element.style.backgroundColor = "red";
        element.style.color = "white";
    }

    function changeColorOnLeave(element) {
        element.style.backgroundColor = "white";
        element.style.color = "black";
    }
</script>
	<!-- /* header */ -->
	<header>
		<div id="topHeader">
		
			<nav>
				<ul>
					<li><input type="button" id="loginButton"
						onclick="goToLoginForm()" class="header-nav" value='로그인'></li>
					<li>|</li>
					<li><input type="button" class="header-nav"
						onclick="goToRegisterForm()" value='회원가입'></li>
					<li>|</li>
					<li><input type="button" class="header-nav"
						onclick="goToBoard()" value='고객센터'></li>
					<li>|</li>
					<li><a href="#" id="cart" class="header-nav"
						onclick="showCart()">장바구니</a></li>
					<li>|</li>
					<li><input type="button" id="loginButton"
						onclick="goToAdminLoginForm()" class="header-nav" value='관리자'></li>
				</ul>
			</nav>
		</div>

		<div id="middleHeader">
			<nav>
				<ul>
					<li><a href="#" onclick="handleCustomClick()">시그니처</a></li>
					<li>|</li>
					<li><a href="#" onclick="goToReview()">반찬후기</a></li>
					<li>|</li>
					<li><a href="banchan?command=info">배송안내</a></li>
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
					<li><a href="#" class="jingaTitle" id="9" onmouseover="changeColorOnHover(this)" onmouseout="changeColorOnLeave(this)" onclick="handleClick(this)">진가네 시그니처</a></li>
					 <li><a href="#" class="jingaTitle" onmouseover="changeColorOnHover(this)" onmouseout="changeColorOnLeave(this)" onclick="handleClick(this)" id="1">진가네 명품김치</a></li>
        <li><a href="#" class="jingaTitle" onmouseover="changeColorOnHover(this)" onmouseout="changeColorOnLeave(this)" onclick="handleClick(this)" id="2">밑반찬</a></li>
        <li><a href="#" class="jingaTitle" onmouseover="changeColorOnHover(this)" onmouseout="changeColorOnLeave(this)" onclick="handleClick(this)" id="3">국·찌개</a></li>
        <li><a href="#" class="jingaTitle" onmouseover="changeColorOnHover(this)" onmouseout="changeColorOnLeave(this)" onclick="handleClick(this)" id="4">메인반찬</a></li>
        <li><a href="#" class="jingaTitle" onmouseover="changeColorOnHover(this)" onmouseout="changeColorOnLeave(this)" onclick="handleClick(this)" id="5">전</a></li>
        <li><a href="#" class="jingaTitle" onmouseover="changeColorOnHover(this)" onmouseout="changeColorOnLeave(this)" onclick="handleClick(this)" id="6">나물반찬</a></li>
        <li><a href="#" class="jingaTitle" onmouseover="changeColorOnHover(this)" onmouseout="changeColorOnLeave(this)" onclick="handleClick(this)" id="7">장아찌</a></li>
        <li><a href="#" class="jingaTitle" onmouseover="changeColorOnHover(this)" onmouseout="changeColorOnLeave(this)" onclick="handleClick(this)" id="8">대용량</a></li>
				</ul>
			</nav>

		</div>
	</header>