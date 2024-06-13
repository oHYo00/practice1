<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body ><jsp:include page="../common/menubar2.jsp" />
<div class="content">
	 업로드된 이미지<img src="${ pageContext.servletContext.contextPath }/resources/uploadFiles/${savedName}" width=300 height=300> <br> <br>
	<hr color="red">
	등록된 게시판 타이틀은 ${bbsDTO.title} <br>
	등록된 게시판 내용 ${bbsDTO.content} <br>
	등록된 게시판 자가 ${bbsDTO.writer} <br>
</div>
</body>
</html>