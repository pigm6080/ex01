<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	
	<form action="/member/login" method="post">
		<p>아 이 디 : <input type="text" name ="memberEmail" placeholder="이메일" /></p>
		<p>비밀번호 : <input type="text" name ="memberPassword" placeholder="비밀번호" /></p>
		<input type="submit" value="로그인" />
	</form>
	
</body>
</html>