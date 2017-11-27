<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<html>
<head>
	<title>회원수정</title>
	<script type="text/javascript">
		function check(){
			if (f.passwd.value==""){
				alert("비밀번호를 입력하세요")
				f.passwd.focus()
				return
			}
			document.f.submit()
		}
	</script>
</head>

	<body onload="f.name.focus()">
		<form name="f" method="POST" action="travel_member_edit">
			<input type="hidden" name="no" value="${getMember.member_num}">
			<table width="550" align="center" class="outline">
  				<tr>
					<td colspan="2" align=center class="m2">회원수정</td>
 				</tr>
				<tr>
					<td width="150" class="m3">이름</td>
					<td class="m3">
						<input type="text" name="name" class="box"
							value="${getMember.member_name}" disabled>
						<input type="hidden" name="name" value="${getMember.member_name}"/>	
					</td>
					<td width="150" class="m3">닉네임</td>
					<td class="m3">
						<input type="text" name="name" class="box"
							value="${getMember.member_nickname}">
					</td>
				</tr>
				<tr>
					<td width="150" class="m3">아이디</td>
					<td class="m3">
						<input type="text" name="id" class="box"
							value="${getMember.id}" readOnly>
					</td>
  				</tr>
  				<tr>
					<td width="150" class="m3">비밀번호</td>
					<td class="m3">
						<input type="password" name="passwd" 
							value="${getMember.member_passwd }" class="box">
					</td>
  				</tr>
  				<!-- 이미지 수정 하게 만들어주기????????? -->
  				<tr>
					<td width="150" class="m3">이메일</td>
					<td class="m3">
						<input type="text" name="email" class="box"
							value="${getMember.member_email}">
					</td>
  				</tr>
  				<tr>
					<td width="150" class="m3">연락처</td>
					<td class="m3">
						<input type="text" name="hp1" class="box" 
							size="3" maxlength="3" value="${getMember.member_hp1}"> -
						<input type="text" name="hp2" class="box" 
							size="4" maxlength="4" value="${getMember.member_hp2}"> -
						<input type="text" name="hp3" class="box" 
							size="4" maxlength="4" value="${getMember.member_hp3}">
					</td>
  				</tr>
  				<tr>
					<td colspan="2" align="center">
						<a href="javascript:check()">[수정]</a>
						<a href="#">[취소]</a>
					</td>
  				</tr>
  			</table>
		</form>
	</body>
</html>