function goToBoard() {
	localStorage.setItem("pagekey", "notice");
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
				document.getElementById('navTitle').value = boardType;
				displayCreateBtn(boardType)
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
                    <td>${post.id}</td>
                    <td><button onclick="goToDetailModalForm(this)" class="btn btn-primary"
								id=${post.id}>${post.title}</button></td>
                    <td>${post.author}</td>
                    <td>${post.datePosted}</td>
                </tr>
            `;
		postListBody.insertAdjacentHTML('beforeend', row);
	});
}

// 초기 페이지 로드 시 게시물 데이터를 받아와서 테이블에 추가합니다.
window.onload = function() {
	fetchBoardList('notice');
};

function goToDetailModalForm(element) {

	let valueToSend = element.id;

	$.ajax({
		url: 'banchan?command=detail_review', // 서버의 URL
		type: 'post', // GET 또는 POST 요청
		data: { id: valueToSend }, // post.id를 서버로 전달
		success: function(response) {
			document.getElementById('detailId').value = response.id;
			document.getElementById('detailPassword').value = response.password;
			document.getElementById('detailTitle').value = response.title;
			document.getElementById('detailAuthor').value = response.author;
			document.getElementById('detailContent').value = response.content;
			document.getElementById('detailImageUrl').src = "upload/" + response.imageUrl;
			document.getElementById('nonmakeImg').value = response.imageUrl;
			$('#detailFormModal').modal('show');
			console.log('서버 응답:', response);
		},
		error: function(xhr, status, error) {
			// 요청 실패 시 처리
			console.error('AJAX 요청 실패:', error);
		}
	});
}

function isNotNull(value) {
	return value !== null && value !== undefined;
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

let actionType = "";
function checkPassword(actionType) {
	if (detailPassword.value == checkPasswordRef.value) {
		actionType = actionType;
		return true;
	}
	alert("비밀번호를 입력하세요");
	return false;
}

function doUpdate() {
	checkPassword();
}

function doAction() {
	if (actionType == 'update') {
		localStorage.setItem("pagekey", navTitle.value);
		document.forms["updateFrm"].action = "banchan?command=update_review";
	} else {
		localStorage.setItem("pagekey", navTitle.value);
		alert("fsadfsadfsfad")
		document.forms["updateFrm"].action = "banchan?command=delete_review";
	}
		
}


function goToModalForm() {
	$('#imagePreview').hide();
	var navTitleValue = document.getElementById("navTitle").value;
	if (navTitleValue == "qna" || navTitleValue == "review") {
		$("#cartModalLabel").text(navTitleValue);
		$('#formModal').modal('show');
	}

	if (navTitleValue == "qna") {
		$('#upload').hide();

	} else {
		$('#upload').show();

	}
}


function previewImage(event) {
	var input = event.target;
	var reader = new FileReader();
	reader.onload = function() {
		var img = document.getElementById('imagePreview');
		img.src = reader.result;
		img.style.display = 'block'; // 이미지 미리보기 표시
	};
	reader.readAsDataURL(input.files[0]);
}


function displayCreateBtn(boardType) {
	if (boardType == "notice" || boardType == "faq") {
		document.getElementById("newPostBtn").style.opacity = "0";
	} else {
		document.getElementById("newPostBtn").style.opacity = "100";
	}
}

function goToWriteAction() {

	localStorage.setItem("pagekey", navTitle.value);
	console.log(imageUrl + "ffffffff")
	document.forms["frm"].action = "banchan?command=write_" + navTitle.value;
}

function getByType() {
	console.log(navTitle.value)

	let type = localStorage.getItem("pagekey");

	console.log(type)

	if (type == null) {
		return 'notice';
	}
	return type;


}