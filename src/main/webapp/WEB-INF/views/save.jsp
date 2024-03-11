<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="/member/save" method="post">
		<p>아 이 디 : <input type="text" name ="memberEmail" placeholder="이메일" id="memberEmail" onblur="emailCheck()"/></p>
		<p id="check-result"></p>
		<p>비밀번호 : <input type="text" name ="memberPassword" placeholder="비밀번호" /></p>
		<p>이   름 : <input type="text" name ="memberName" placeholder="이름" /></p>
		<p>나   이 : <input type="text" name ="memberAge" placeholder="나이" /></p>
		<p>전화번호 : <input type="text" name ="memberMobile" placeholder="전화번호" /></p>
		<input type="submit" value="전화번호" />
	</form>
</body>
<script>
// 이메일 입력값을 가져오고,
// 입력값을 서버로 전송하고 똑같은 이메일이 있는지 체크한 후
// 사용 가능 여부를 이메일 입력창 아래에 표시
       const emailCheck = () => {
        const email = document.getElementById("memberEmail").value;
        const checkResult = document.getElementById("check-result");
        console.log("입력한 이메일", email);
        $.ajax({
            // 요청방식: post, url: "email-check", 데이터: 이메일
            type: "post",
            url: "/member/email-check",
            data: {
                "memberEmail": email
            },
            success: function(res) {
                console.log("요청성공", res);
                console.log(res);
                if (res == "ok") {
                    console.log("사용가능한 이메일");
                    checkResult.style.color = "green";
                    checkResult.innerHTML = "사용가능한 이메일";
                } else {
                    console.log("이미 사용중인 이메일");
                    checkResult.style.color = "red";
                    checkResult.innerHTML = "이미 사용중인 이메일";
                }
            },
            error: function(err) {
                console.log("에러발생", err);
            }
        });
    }
</script>
</html>