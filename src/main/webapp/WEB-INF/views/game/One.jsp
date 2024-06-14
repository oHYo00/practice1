<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


 <style>
            img{
 
  display: block;
  margin-left: auto;
  margin-right: auto;
}
.content{ 
    	text-align:center;}
        </style>


</head>
<body ><jsp:include page="../common/menubar.jsp" />
<div class="content">
	<img src="${ pageContext.servletContext.contextPath }/resources/uploadFiles/${gameDTO.img}" width=300 height=300> <br> 
	타이틀  <br>${gameDTO.name}<br>
	<hr color="red">
	
	등록된 게시판 내용 ${gameDTO.id} ,${gameDTO.developer},${gameDTO.grade}}<br>
	
	
</div>
</body>
</html>