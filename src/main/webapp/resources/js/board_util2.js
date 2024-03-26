function goToBoard() {
	window.location.href = "banchan?command=board";
}


function fetchBoardList(boardType) {
	document.getElementById('boardTitle').innerText = boardType.toUpperCase();
	
	console.log(document.getElementById('boardTitle').value + "dd")
	var xhr = new XMLHttpRequest();

	xhr.open("GET", "banchan?command=" + boardType, true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				// 성공적으로 응답을 받았을 때 처리할 내용
				var response = JSON.parse(xhr.responseText);
				console.log(response);
				fetchPosts(response);
			} else {
				// 오류가 발생했을 때 처리할 내용
				console.error("AJAX 요청 오류:", xhr.status, xhr.statusText);
				// 오류 발생 시 사용자에게 메시지 표시 또는 다른 처리를 추가할 수 있습니다.
			}
		}
	};
	xhr.send();
}

function fetchPosts(posts) {
	
	
	const postListBody = document.getElementById('postListBody');
    postListBody.innerHTML = ''; // 기존 목록 삭제
	
	
	postListBody.innerHTML = ''; // 기존 목록 삭제
	posts.forEach(post => {
		const row = `
                <tr>
                    <td>${post.num}</td>
                    <td><a href="#">${post.title}</a></td>
                    <td>${post.username}</td>
                    <td>${post.email}</td>
                </tr>
            `;
		postListBody.insertAdjacentHTML('beforeend', row);
	});
}

// 초기 페이지 로드 시 게시물 데이터를 받아와서 테이블에 추가합니다.
window.onload = function() {
fetchBoardList('notice');
};



function goToNotice() {
	window.location.href = "banchan?command=notice";
}

function goToQnA() {
	window.location.href = "banchan?command=qna";
}

function goToFaq() {
	window.location.href = "banchan?command=faq";
}




