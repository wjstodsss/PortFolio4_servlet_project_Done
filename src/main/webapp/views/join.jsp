<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- 
    <script type="text/javascript" src="../resources/js/member_join.js"></script>
     -->

<style>
/* 추가한 CSS */
.container {
	max-width: 550px;
}

.required-label {
	color: red;
	margin-right: 5px;
}


</style>
</head>
<body>
	<div class="container">
		<h2 class="text-center">회원 가입</h2>
		<p>
			<span class="required-label">*</span> 표시 항목은 필수 입력 항목입니다.
		</p>
		<form action="banchan?command=register" method="post" name="frm"
			onsubmit="return joinCheck()">
			<table class="table">
				<tr>
					<td><span class="required-label">*</span>이름</td>
					<td><input type="text" name="userName" size="20" id="username"
						class="form-control"></td>
				</tr>
				<tr>
					<td><span class="required-label">*</span>아이디</td>
					<td>
						<div class="input-group">
							<input type="text" name="userId" size="20" id="userid"
								class="form-control"> <input type="hidden" name="reid"
								size="20">
							<div class="input-group-append">
								<button class="btn btn-primary" type="button"
									onclick="idCheck()">중복 체크</button>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td><span class="required-label">*</span>암호</td>
					<td><input type="password" name="userPassword" size="20"
						id="pwd" class="form-control"></td>
				</tr>
				<tr height="30">
					<td><span class="required-label">*</span>암호 확인</td>
					<td><input type="password" name="pwd_check" size="20"
						id="pwd_check" class="form-control"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="userEmail" size="20" id="email"
						class="form-control"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="userPhone" size="20" id="phone"
						class="form-control"></td>
				</tr>
				<tr>
					<td>등급</td>
					<td>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="admin"
								value="0" id="normal" checked> <label
								class="form-check-label" for="normal">일반회원</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="admin"
								value="1" id="admin"> <label class="form-check-label"
								for="admin">관리자</label>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="확인"
						class="btn btn-success"> <input type="reset" value="취소"
						class="btn btn-secondary"> <input type="button"
						onclick="goToIndex()" class="btn btn-primary" value="메인으로 가기">

					</td>
				</tr>
				<tr>
					<td colspan="2">${message}</td>
				</tr>
			</table>
		</form>
	</div>
</body>
<script>
function goToIndex() {
	window.location.href = "banchan?command=index";
}

function loginCheck() {
	if (document.frm.userid.value.length == 0) {
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	return true;
}

function idCheck() {
	if (document.frm.userid.value == "") {
		alert('아이디를 입력하여 주십시오.');
		document.frm.userId.focus();
		return;
	}
	
	let userId = document.frm.userid.value;
	let xhr = new XMLHttpRequest();
	xhr.open("POST", "banchan?command=idCheck", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.onload = function() {
		if (xhr.status === 200 && xhr.responseText === "available" && document.frm.userid.value.length > 3) {
			document.frm.reid.value = 1;
			alert("사용 가능한 아이디입니다.");
		} else if (document.frm.userid.value.length < 4) {
			alert("아이디는 4글자이상이어야 합니다.");
			frm.userid.focus();
		} else {
			alert("이미 사용 중인 아이디입니다. 다른 아이디를 선택해주세요.");
		}		
	}
	xhr.send("userId=" + userId);
}

function idok(userid) {
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	self.close();
}


function joinCheck() {
	if (document.frm.username.value.length == 0) {
		alert("이름을 써주세요.");
		frm.username.focus();
		return false;
	}
	if (document.frm.userid.value.length == 0) {
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	if (document.frm.userid.value.length < 4) {
		alert("아이디는 4글자이상이어야 합니다.");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.pwd.value != document.frm.pwd_check.value) {
		alert("암호가 일치하지 않습니다.");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.reid.value.length == 0) {
		alert("중복 체크를 하지 않았습니다.");
		frm.userid.focus();
		return false;
	}
	return true;
}
</script>
</html>
