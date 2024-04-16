<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<img src="/resources/img/footer/footer002.png" alt="배송" class="icon"
					onclick="goToDelivery()">
				<p>배송안내</p>
			</div>
			<div>
				<img src="/resources/img/footer/footer003.png" alt="혜택" class="icon"
					onclick="goToBuyInfo()">
				<p>첫구매혜택</p>
			</div>
			<div>
				<img src="/resources/img/footer/footer004.png" alt="고객센터"
					class="icon" onclick="goToBoard()">
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

	<script>
	document.getElementById("inputWord").addEventListener("keypress", handleEnterKey);
	document.getElementById("searchButton").addEventListener("click", handleClickKey);
	document.getElementById("topClose").addEventListener("click", topBannerDisplayNone);

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
</body>

</html>