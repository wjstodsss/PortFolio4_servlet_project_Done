function goToBoard() {
	window.location.href = "banchan?command=board";
}


function fetchBoardList(boardType) {
	console.log(boardType)
	var xhr = new XMLHttpRequest();

	xhr.open("GET", "banchan?command=" + boardType, true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				// 성공적으로 응답을 받았을 때 처리할 내용
				var response = JSON.parse(xhr.responseText);
				console.log(response);
				displayBoardList(response);
			} else {
				// 오류가 발생했을 때 처리할 내용
				console.error("AJAX 요청 오류:", xhr.status, xhr.statusText);
				// 오류 발생 시 사용자에게 메시지 표시 또는 다른 처리를 추가할 수 있습니다.
			}
		}
	};
	xhr.send();
}
function displayBoardList(boardList) {
	var boardListContainer = $("#boardListContainer");

	// 기존에 표시된 목록을 지우고 새로운 목록을 추가
	boardListContainer.empty();

	// 각 게시물에 대한 반복문
	boardList.forEach(function(board) {
		// 게시물을 나타내는 HTML 요소 생성
		var boardItem = $("<div>").addClass("board-item row border p-3 mb-3");

		// 게시물 번호 요소 생성 및 추가
		var numSpan = $("<span>").addClass("board-num col-1").text(board.num);
		boardItem.append(numSpan);

		// 게시물 작성자 요소 생성 및 추가
		var usernameSpan = $("<span>").addClass("board-username col-2").text(board.username);
		boardItem.append(usernameSpan);

		// 게시물 이메일 요소 생성 및 추가
		var emailSpan = $("<span>").addClass("board-email col-3").text(board.email);
		boardItem.append(emailSpan);

		// 게시물 제목 요소 생성 및 추가
		var titleSpan = $("<span>").addClass("board-title col-6").text(board.title);
		boardItem.append(titleSpan);

		// 제목줄 추가
		var titleRow = $("<div>").addClass("title-row row");
		var titleCol = $("<div>").addClass("col-12");
		var titleHeading = $("<h5>").addClass("board-title-heading").text("게시물 목록");
		titleCol.append(titleHeading);
		titleRow.append(titleCol);
		boardItem.prepend(titleRow); // 게시물 요소의 맨 위에 추가

		// 생성한 HTML 요소를 목록 영역에 추가
		boardListContainer.append(boardItem);
	});
}




function goToNotice() {
	window.location.href = "banchan?command=notice";
}

function goToQnA() {
	window.location.href = "banchan?command=qna";
}

function goToFaq() {
	window.location.href = "banchan?command=faq";
}




