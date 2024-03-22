<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Test</title>
<script>
    function login() {
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        
        // AJAX를 사용하여 서버에 로그인 요청을 보냄
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "login", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                var token = xhr.responseText;
                if (token === "logged_out") {
                    // 로그아웃 상태인 경우 로그인 버튼으로 변경
                    document.getElementById("loginButton").innerText = "Login";
                } else {
                    // 로그인 상태인 경우 로그아웃 버튼으로 변경
                    document.getElementById("loginButton").innerText = "Logout";
                }
            }
        };
        xhr.send("username=" + username + "&password=" + password);
    }
</script>
</head>
<body>

<h1>Login Test</h1>

<%-- 로그인 폼 --%>
<form>
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br>
    <input type="button" value="Login" id="loginButton" onclick="login()">
</form>

</body>
</html>
