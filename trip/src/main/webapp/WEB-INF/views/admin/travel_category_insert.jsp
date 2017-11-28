<%@ page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="top.jsp"%> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function categoryChange(e) {
		var city_0 = [ "강남구", "종로구", "마포구", "중구" ,"용산구"];
		var city_1 = [ "평창", "춘천", "강릉", "횡성" ,"양양"];
		var city_2 = [ "용인", "파주", "의정부시", "수원시", "인천시" ];
		var city_3 = [ "부산", "거제", "통영", "남해", "대구", "울산"  ];
		var city_4 = ["광주", "춘천", "여수", "전주", "남원"];
		var city_5 = ["제주", "서귀포" ];
		var city_6 = [ "대전","보령", "천안", "청주" ];
		var target = document.getElementById("city");

		if (e.value == "0")
			var d = city_0;
		else if (e.value == "1")
			var d = city_1;
		else if (e.value == "2")
			var d = city_2;
		else if (e.value == "3")
			var d = city_3;
		else if (e.value == "4")
			var d = city_4;
		else if (e.value == "5")
			var d = city_5;
		else if (e.value == "6")
			var d = city_6;

		target.options.length = 0;

		for (x in d) {
			var opt = document.createElement("option");
			opt.value = d[x];
			opt.innerHTML = d[x];
			target.appendChild(opt);
		}
	}
</script>
<div align="center">
	<form name="f" action="travel_category_insert" method="post">
		<table border="1" width="300">
			<caption>여행 지역 카테고리 등록</caption>
			<tr>
				<th bgcolor="yellow">카테고리 도</th>
				<td>
				<select onchange="categoryChange(this)" name="state">
						<option>등록할 도를 선택해주세요.</option>
						<option value="0">서울특별시</option>
						<option value="1">강원도</option>
						<option value="2">경기도</option>
						<option value="3">경상도</option>
						<option value="4">전라도</option>
						<option value="5">제주도</option>
						<option value="6">충청도</option>
				</select> </td>
			</tr>
			<tr>
				<th bgcolor="yellow">카테고리 시</th>
				<td>
				<select id="city" name="city">
						<option>둥록할 시를 선택해주세요.</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2" align="center" class="m2"><input type="submit"
					value="등록"> <input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="bottom.jsp"%>