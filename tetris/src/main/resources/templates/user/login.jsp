<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- JSTL 코어 태그 설정 -->
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Login</title>

<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<div>
		<h1>로그인</h1>
		<form action="login" method="post">
			<div class="mb-3 mt-3">
				<label for="userId" class="form-label">아이디:</label> <input type="text" class="form-control" id="userId" placeholder="아이디를 입력해주세요" name="userId">
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">비밀번호:</label> <input type="password" class="form-control" id="password" placeholder="비밀번호를 입력해주세요" name="password">
			</div>
			<button type="submit" class="btn btn-primary">로그인</button>
		</form>
		
		<!-- 빈칸유효성 검사 추가 -->

	</div>
</body>
</html>