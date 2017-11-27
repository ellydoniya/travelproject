<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ include file="top.jsp"%>

<div align="center">
	<table border="1" width="400">
		<caption>여행 지역 카테고리목록</caption>
		<tr bgcolor="yellow">
			<th width="10%">번호</th>
			<th width="30%">카테고리코드</th>
			<th width="50%">카테고리이름</th>
			<th width="10%">수정 | 삭제</th>
		</tr>
		<tr>
		<c:if test="${empty travelCategory}">
			<td colspan="4">등록된 카테고리목록이 없습니다.</td>
		</c:if>
		</tr>	
		<tr>
			<c:forEach var="dto" items="${travelCategory}">
			<td align="right">${dto.travel_cate_num}</td>
			<td align="center">${dto.travel_cate_state}</td>
			<td align="center">${dto.travel_cate_city}</td>
			<td><a href="shop_category_edit?no=${dto.travel_cate_num}">수정</a> | 
				<a href="shop_category_delete?no=${dto.travel_cate_num}">삭제</a>
			</td>
			</c:forEach>
		</tr>	
	</table>
</div>
<%@ include file="bottom.jsp"%>