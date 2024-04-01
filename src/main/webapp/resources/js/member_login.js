function checkLoginState() {
    var token = sessionStorage.getItem("token");
    console.log(token+"ffffffffff")
    if (token) {
        console.log("ok")
        document.getElementById("loginButton").value = "로그아웃";
        document.getElementById("loginButton").setAttribute("onclick", "logout()");
        
    } else {
        console.log("false")
        document.getElementById("loginButton").value = "로그인";

	console.log("dsdfsdfasdfsadfs")
    window.location.href = "banchan?command=register_form";
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
        } else if (xhr.readyState === 4 && xhr.status !== 200) {
            // 로그아웃에 실패한 경우에 대한 처리를 수행할 수 있습니다.
            console.error("Logout failed");
        }
    };
    xhr.send();
    
    // 로그인 상태를 확인하고 화면을 업데이트할 수 있도록 호출합니다.
    checkLoginState();
}