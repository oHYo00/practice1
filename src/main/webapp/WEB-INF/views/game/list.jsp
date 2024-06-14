<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
button {
	background: pink;
}

.t1 { /* .은 클래스 선택!, 여러개선택!  */
	background: yellow;
	width: 150px;
	text-align: center;
}

#b1 { /* #은 아이디 선택!, 특정한 것 한 개만 선택! */
	color: red;
}

#b2 {
	color: blue;
}
</style>
</head>
<body>


	<!-- 이쪽에 메뉴바 포함 할꺼임 -->
	<jsp:include page="../common/menubar1.jsp" />

	<div class="content">
		<br>
		<br>
		<div class="innerOuter">
			<a href="main">
				<button id="b1">첫페이지로</button>
			</a> 회원검색 처리 요청이 완료되었습니다.<br>
<table>
		<tr>
			<td class="top"> 순위 </td>
			<td class="top"> 이름 </td>
			<td class="top"> 개발자 </td>
			<td class="top"> 점수 </td>
		</tr>
			<c:forEach items="${list}" var="bag" varStatus="status">
			<tr>
			    <td class="down"> ${status.count} </td>
				<td class="down"> ${bag.name} </td> 
				<td class="down"> ${bag.developer} </td>
				<td class="down"> ${bag.grade} </td>
				</tr>
			</c:forEach>


		</div>
		<br>
		<br>
	</div>


	
</body>
</html>




