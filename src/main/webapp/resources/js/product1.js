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


var cartItems = JSON.parse(sessionStorage.getItem('cartItems')) || {};

function addToCart(product) {
    var quantity = parseInt(document.getElementById("quantity" + product).value);
    var productImageUrl = document.getElementById("image" + product).getAttribute("src");
    var productName = document.getElementById("name" + product).innerText;

    // 장바구니에 해당 상품이 이미 있는지 확인
    if (cartItems.hasOwnProperty(product)) {
        // 이미 장바구니에 있는 경우 수량과 나머지 정보 모두 업데이트
        cartItems[product]['quantity'] += quantity;
        cartItems[product]['imageUrl'] = productImageUrl;
        cartItems[product]['productName'] = productName;
    } else {
        // 장바구니에 없는 경우 새로운 상품으로 추가
        cartItems[product] = {
            id: product,  // 상품의 고유 ID
            imageUrl: productImageUrl,
            productName: productName,
            quantity: quantity  // 새로운 상품의 수량 설정
        };
    }

    // 장바구니 업데이트
    updateCart();
}


function showCart() {
	updateCart();
}


function updateCart() {
    var cartList = document.getElementById("cartList");
    cartList.innerHTML = ""; // 기존 목록 초기화

    // 장바구니 테이블 생성
    var table = document.createElement("table");
    table.className = "table"; // 부트스트랩 테이블 클래스 추가

    // 테이블 헤더 생성
    var headerRow = document.createElement("tr");

    // 전체 선택 체크박스 헤더 열
    var selectAllHeader = document.createElement("th");
    var selectAllCheckbox = document.createElement("input");
    selectAllCheckbox.type = "checkbox";
    selectAllCheckbox.id = "selectAllCheckbox";
    selectAllCheckbox.addEventListener("change", function() {
        var checkboxes = document.querySelectorAll("#cartList input[type='checkbox']");
        checkboxes.forEach(function(checkbox) {
            checkbox.checked = selectAllCheckbox.checked;
        });
    });
    selectAllHeader.appendChild(selectAllCheckbox);
    headerRow.appendChild(selectAllHeader);

    // 상품명 헤더 열
    var productHeader = document.createElement("th");
    productHeader.textContent = "상품명";
    headerRow.appendChild(productHeader);

    // 이미지 열
    var imageHeader = document.createElement("th");
    imageHeader.textContent = "이미지";
    headerRow.appendChild(imageHeader);

    // 수량 헤더 열
    var quantityHeader = document.createElement("th");
    quantityHeader.textContent = "수량";
    headerRow.appendChild(quantityHeader);

    // 테이블 헤더 추가
    table.appendChild(headerRow);

    // 장바구니 목록 갱신
    for (var item in cartItems) {
        var row = document.createElement("tr");

        // 체크박스 열
        var checkboxCell = document.createElement("td");
        var checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        checkbox.value = item;
        checkboxCell.appendChild(checkbox);
        row.appendChild(checkboxCell);

        // 상품명 열
        var productCell = document.createElement("td");
        productCell.textContent = cartItems[item]["productName"];
        row.appendChild(productCell);

        // 이미지 열
        var imageCell = document.createElement("td");
        var img = document.createElement("img");
        img.src = cartItems[item]["imageUrl"];
        img.style.maxWidth = "60px";
        img.style.maxHeight = "60px";
        imageCell.appendChild(img);
        row.appendChild(imageCell);

        // 수량 입력 열
        var quantityCell = document.createElement("td");
        var input = document.createElement("input");
        input.type = "number";
        input.min = 0;
        input.value = cartItems[item]["quantity"];
        input.style.maxWidth = "60px";
        input.style.maxHeight = "60px";
        input.onchange = (function(item) {
            return function() {
                changeQuantity(cartItems[item]["id"], parseInt(this.value));
            };
        })(item);
        quantityCell.appendChild(input);
        row.appendChild(quantityCell);

        table.appendChild(row);
    }

    // 테이블을 cartList에 추가
    cartList.appendChild(table);

    // 장바구니 모달 열기
    $('#cartModal').modal('show');
}



// 상품 수량 변경 함수
function changeQuantity(product, quantity) {
    // 장바구니의 해당 상품의 수량을 변경합니다.
    cartItems[product]["quantity"] = quantity;

    // 세션 스토리지에 장바구니 정보 저장
    sessionStorage.setItem('cartItems', JSON.stringify(cartItems));

    // 장바구니 업데이트
    updateCart();
}

// 선택된 상품 삭제 함수
function deleteSelectedItems() {
	var checkboxes = document.querySelectorAll("#cartList input[type='checkbox']");
	checkboxes.forEach(function(checkbox) {
		if (checkbox.checked) {
			var product = checkbox.value;
			delete cartItems[product];
		}
	});

	// 세션 스토리지에 장바구니 정보 저장
	sessionStorage.setItem('cartItems', JSON.stringify(cartItems));

	// 장바구니 업데이트
	updateCart();
}

// 선택된 상품 구매 함수 (삭제와 동일한 로직으로 작성)
function buySelectedItems() {
	deleteSelectedItems();
}
