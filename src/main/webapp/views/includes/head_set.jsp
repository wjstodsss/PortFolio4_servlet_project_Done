<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>꼴뚜기의 첫번째 프로젝트</title>
<link href="../resources/css/reset.css" rel="stylesheet">
<link href="../resources/css/main.css" rel="stylesheet">
<link href="../resources/css/member_login.css" rel="stylesheet">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
<script src="../resources/js/member_login4.js"></script>
<script src="../resources/js/board_util4.js"></script>
<script src="../resources/js/product2.js"></script>
<script src="../resources/js/member_join2.js"></script>

<style>
/* 컨테이너의 최대 크기 설정 */
.container {
	max-width: 980px;
	margin-top: 20px;
}

/* 상품 카드 간격 설정 */
.mb-3 {
	margin-bottom: 15px;
}

.card-body {
	font-size: 0.8rem;
}

.text-muted {
	overflow: hidden;
	font-size: small;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.centered-images {
	display: flex;
	justify-content: center;
	overflow-x: hidden; /* 가로 스크롤 막기 */
}

.centered-images img {
	max-width: 100%; /* 이미지가 부모 요소의 너비를 초과하지 않도록 */
	height: auto; /* 이미지의 세로 비율 유지 */
}

.overflow-auto {
    overflow: auto !important;
    margin-bottom: 20px;
}


</style>
</head>
<body>