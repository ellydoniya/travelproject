<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!-- memberAll.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<html>
<head>
	<title>mvc멤버</title>
</head>
<body>	
	<div align="center">
		<hr color="green" width="300">
		<h2>회 원 목 록 보 기</h2>
		<hr color="green" width="300">
		<table width="100%" class="outline">
			<tr>
				<th class="m3">번호</th>
				<th class="m3">아이디</th>
				<th class="m3">이름</th>
				<th class="m3">닉네임</th>
				<th class="m3">이메일</th>
				<th class="m3">전화번호</th>
				<th class="m3">자기소개</th>
				<th class="m3">가입일</th>
				<th class="m3">수정 | 삭제</th>
			</tr>
			<c:if test="${empty listMember}">
			<tr>
				<td colspan="7">등록된 회원이 없습니다.</td>
			</tr>
			</c:if>
			<c:forEach var="dto" items="memberList">
			<tr>
				<td>${dto.member_num}</td>
				<td>${dto.member_ id}</td>
				<td>${dto.member_name}</td>
				<td>${dto.member_nickname}</td>
				<td>${dto.member_email}</td>
				<td>${dto.allHp}</td>
				<td>${dto.member_content}</td>
				<td>
				<a href="travel_member_edit?no=${dto.member_num}">수정</a> | 
				<a href="travel_member_delete?no=${dto.member_num}">삭제</a></td>
			</tr>
			</c:forEach>	
		</table>
		<br>
		<a href="admin_index">회원관리페이지로 이동</a>
	</div>
</body>
</html>


