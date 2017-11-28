<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function direction() {
		if (f.book_insurance_tou.value == 1) {
			alert("동의")
		} else if (f.book_insurance_tou.value == 0) {
			alert("비동의")
		}
	}
</script>
<body>
	<form name="f">
		<div align="center">
			<table>
				<tr>
					<td colspan="2">약관</td>
				</tr>
				<tr>
					<td><input type="radio" name="book_insurance_tou" value="1"
						checked="checked">동의</td>
					<td><input type="radio" name="book_insurance_tou" value="0">비동의</td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="계속"
						onclick="direction()"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>