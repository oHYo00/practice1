<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {

		$.ajax({

			url : "taskList",
			type : "get",
			success : function(result) {
				$("#taskArea").html(result);
			},
			error : function() {
				alert("일정 불러오기 실패!");
			}

		})

	})
</script>

<body>
	<jsp:include page="/WEB-INF/views/common/menubar.jsp"></jsp:include>
	<h2 class="mt-5 container" style="text-align: center;">
		<label>To Do List</label>
	</h2>
	<div class="container mt-5">

		<form class="row g-3" action="insert" method="post">

			<div class="col-3" style="text-align: right;">
				<label for="staticEmail2" class="col-form-label">오늘의 할일</label>
			</div>
			<div class="col-6">
				<input type="text" class="form-control" name="content"
					placeholder="할일을 입력하세요.">
			</div>
			<div class="col-3">
				<button id="submitBtn" class="btn btn-primary mb-3">저장</button>
			</div>
		</form>

	</div>
	<div id="taskArea">
		<jsp:include page="../task/taskList.jsp"></jsp:include>
	</div>
</body>
</html>