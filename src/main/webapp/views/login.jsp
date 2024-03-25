<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Test</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/member_login.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="../resources/js/member_login.js"></script>
</head>
<body>

<div class="container mt-5" >
    <h1>Login</h1>
    <form>
        <div class="form-group">
            <label for="userID">Username:</label>
            <input type="text" class="form-control" id="userId" name="userId" required>
        </div>
        <div class="form-group">
            <label for="userPassword">Password:</label>
            <input type="password" class="form-control" id="userPassword" name="userPassword" required autocomplete="current-userPassword">
        </div>
        <input type="button" class="btn btn-danger mb-2" value="Login" id="loginButton" onclick="login()">
    </form>
</div>

</body>
</html>
