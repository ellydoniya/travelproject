<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function booking() {
			alert("예약하기")
		}

		function addCart() {
			alert("장바구니")
		}
	</script>
	<div align="center">
		<form name="f" method="post">
			<table border="1">
				<tr>
					<td rowspan="6">사진</td>
					<td colspan="2">이름</td>
				</tr>
				<tr>
					<td colspan="2">설며ㅑ</td>
				</tr>
				<tr>
					<td>지역</td>
					<td>전화번호</td>
				</tr>
				<tr>
					<td>여행기간</td>
					<td>이메일</td>
				</tr>
				<tr>
					<td colspan="2">가격</td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="예약하기"
						onclick="booking()"><input type="button" value="장바구니"
						onclick="addCart()"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>