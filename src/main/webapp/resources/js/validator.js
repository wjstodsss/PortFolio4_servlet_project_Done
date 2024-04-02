function boardCheck() {
	if (document.frm.title.value.length == 0) {
		alert("제목을 작성해주세요");
		frm.title.focus();
		return false;
	}

	if (document.frm.author.value.length == 0) {
		alert("작성자를 작성해주세요");
		frm.author.focus();
		return false;
	}


	if (document.frm.content.value.length == 0) {
		alert("내용을 작성해주세요");
		frm.content.focus();
		return false;
	}

	return true;
}

function checkPassword() {
	if(password.value !== passwordRef.value) {
		alert (document.getElementById("kk").value);
		return false;
	}
	return true;
}
