<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<div class="container mt-5 col-8" id="task">
	<c:forEach items="${list}" var="one">
		<%-- <input name="taskId" type="hidden" value="${one.taskId}"> --%>
		<div id="${one.taskId}" class=" mb-1" style="display: flex;">
			<c:choose>
				<c:when test="${one.complete == 'N'}">
					<input class="form-control " type="text" value="${one.content}"
						readonly style="margin-right: 5px; background-color: white;" >
					<div class="col-auto">
						<button name="${one.taskId}" class="btn btn-primary"
							style="margin-right: 5px; background-color: green;">완료</button>
				</c:when>
				<c:otherwise>
					<input class="form-control " type="text" value="${one.content}"
						readonly style="margin-right: 5px; background-color: lightgray;">
					<div class="col-auto">
						<button name="${one.taskId}" class="btn btn-primary"
							style="margin-right: 5px; background-color: gray;">취소</button>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="col-auto">
			<button name="${one.taskId}" class="btn btn-primary"
				style="background-color: red;">삭제</button>

		</div>
</div>
</c:forEach>
</div>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
<script type="text/javascript">
	$(function() {
		$("button").click(function() {

			let btn = $(this).text();
			let taskId = $(this).attr("name");
			console.log(taskId);
			console.log(btn);

			if (btn == "완료" || btn == "취소") {
				$.ajax({

					url : "taskComplete",
					type : "post",
					contentType : 'application/json',
					data : JSON.stringify({
						btn : btn,
						taskId : taskId
					}),
					success : function(result) {
						$("#taskArea").html(result);
					},
					error : function() {
						alert("일정 불러오기 실패!");
					}

				})
			} else if (btn == "삭제") {
				$.ajax({

					url : "taskDelete",
					type : "post",
					contentType : 'application/json',
					data : JSON.stringify({
						btn : btn,
						taskId : taskId
					}),
					success : function(result) {
						$("#taskArea").html(result);
					},
					error : function() {
						alert("일정 불러오기 실패!");
					}

				})
			}

			

		})

	})
</script>
