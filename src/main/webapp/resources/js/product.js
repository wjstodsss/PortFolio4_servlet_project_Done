function productCheck() {
	if (document.frm.productname.value.length == 0) {
		alert("품명을 써주세요");
		frm.productname.focus();
		return false;
	}
	if (document.frm.price.value.length == 0) {
		alert("가격을 써주세요");
		frm.price.focus();
		return false;
	}
	if (isNaN(document.frm.price.value)) {
		alert("숫자를 입력해야 합니다");
		frm.price.focus();
		return false;
	}

	if (isNaN(document.frm.category.value)) {
		alert("숫자를 입력해야 합니다");
		frm.price.focus();
		return false;
	}
	return true;
}

function handleClick(element) {
	let valueToSend = element.id;
	let formDTO = document.createElement("form");
	formDTO.setAttribute("method", "post");
	formDTO.setAttribute("action", "banchan?command=product_set");
	var input = document.createElement("input");
	input.setAttribute("type", "hidden");
	input.setAttribute("name", "category");
	input.setAttribute("value", valueToSend);
	formDTO.appendChild(input);
	document.body.appendChild(formDTO);
	formDTO.submit();
}

function sliderHiddenAndStop() {
	document.getElementById("slider").style.display = "none";
	sliderStop();
}
