function checkLoginState() {
    var token = sessionStorage.getItem("token");
    if (token) {
        document.getElementById("loginButton").value = "로그아웃";
        document.getElementById("loginButton").setAttribute("onclick", "logout()");
        
    } else {
        console.log("false")
        document.getElementById("loginButton").value = "로그인";
        document.getElementById("loginButton").setAttribute("onclick", "goToLoginForm()");
    }
}


function goToLoginForm() {
    window.location.href = "banchan?command=login_form";
     loginTitle.innerHTML = "사용자 로그인"
}

function goToAdminPage() {

    window.location.href = "banchan?command=admin_page";
}

function goToAdminLoginForm() {
    window.location.href = "banchan?command=admin_login_form";
    loginTitle.innerHTML = "관리자 로그인"
}


function goToRegisterForm() {
	console.log("dsdfsdfasdfsadfs")
    window.location.href = "banchan?command=register_form";
}

function goToTestForm() {
    window.location.href = "banchan?command=test_page";
}



function login() {
    
    var userId = document.getElementById("userId").value;
    var userPassword = document.getElementById("userPassword").value;
  
    // AJAX를 사용하여 서버에 로그인 요청을 보냄
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "banchan?command=member_login", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var token = xhr.responseText;
            sessionStorage.setItem("token", token);
            window.location.href = "banchan?command=index";
        } else if (xhr.readyState === 4 && xhr.status === 401) {
            alert("Invalid username or password.");
        }
    };
    xhr.send("userId=" + userId + "&userPassword=" + userPassword);
    
}


function logout() {
    // sessionStorage에서 토큰을 삭제합니다.
    sessionStorage.removeItem("token");
    
    // 서버에 로그아웃 요청을 보내도록 구현할 수 있습니다.
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/logout", true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // 로그아웃이 성공했을 때 추가적인 작업을 수행할 수 있습니다.
            console.log("Logout successful");
            // 로그아웃에 실패한 경우에 대한 처리를 수행할 수 있습니다.
            console.error("Logout failed");
        }
    };
    xhr.send();
    
    // 로그인 상태를 확인하고 화면을 업데이트할 수 있도록 호출합니다.
    checkLoginState();
}

function setTitle() {
    // 현재 URL을 가져옴
    var currentUrl = window.location.search;
    
    // URL에서 command 파라미터 값을 추출
    var urlParams = new URLSearchParams(currentUrl);
    var command = urlParams.get('command');
console.log(command)
    // command 값에 따라 타이틀 변경
    var loginTitle = document.getElementById("loginTitle");
    if (command === "login_form") {
        loginTitle.innerHTML = "사용자";
    } else if (command === "admin_login_form") {
        loginTitle.innerHTML = "관리자";
    }
}