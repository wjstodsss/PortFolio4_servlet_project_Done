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
