<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
<style type="text/css">
body { /* 컨트롤 + / - 자동주석, 태그선택! */
	background: lightyellow;
}

button {
	background: #18DE02;
}

.t1 { /* .은 클래스 선택!, 여러개선택!  */
	background: yellow;
	width: 150px;
	text-align: center;
}
</style>
</head>
<body>

   <jsp:include page="../common/menubar1.jsp"/>
    
    <div class="content">
        <br><br>
        <div class="innerOuter"><h3>전체 게임 count: ${count}</h3>
<hr color="red">
<%
	int pages = (int)request.getAttribute("page");
	for(int p = 1; p <= pages; p++){
%>
	<a href=gameAll?page=<%= p %>>
		<button style="width: 50px;display: inline-block;"><%= p %></button>
	</a>  
<%		
	}
%>
	<hr color="red">
 <table>
   <tr>
      <td class="left">No.</td>
      <td class="left">게시글 번호</td>
      <td class="top"> 이름 </td>
	  <td class="top"> 개발자 </td>
	  <td class="top"> 점수 </td>
   </tr>
   <c:forEach items="${list}" var="one">
   <tr>
      <td class="right">${one.rownum}</td> 
      <td class="right">${one.id}</td> <!-- one.getId() -->
      <td class="right"><a href="One?id=${one.id}">${one.name}</a></td>
      <td class="right">${one.developer}</td>     
      <td class="right">${one.grade}</td>
   </tr>
   </c:forEach>
</table>
	
	 </div>
        <br><br>
    </div>
    
 
   
</body>
</html>