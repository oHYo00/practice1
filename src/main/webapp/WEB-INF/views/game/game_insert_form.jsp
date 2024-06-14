<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

</head>
<body>
<jsp:include page="../common/menubar1.jsp" />

	<div class="content">
	<div id="total">
		<div id="center">
			<h3 style="text-align: center;">게임등록</h3>
			<hr color="grey">
			<form action="insert" id="form" method="post" enctype="multipart/form-data" >
				<span class="input-group-text">name</span>
				 <input type="text"
					class="form-control input-sm" name="name" placeholder="name"><br>
					
				<span class="input-group-text">IMG</span>
						파일 선택: <input type="file" name="singleFile" ><br>
					
				<span class="input-group-text">developer</span> 
				<input type="text"
					class="form-control" name="developer" placeholder="developer" value=${ sessionScope.loginUser.name } disabled><br>
					
				<span class="input-group-text">grade</span> 
				<input
					type="text" class="form-control" name="grade"
					placeholder="10"><br> 
			
				<button type="submit" class="btn btn-secondary">등록</button>
			</form>
		</div>
	</div>
	
	
	</div>
	
	</div>
</body>
</html>