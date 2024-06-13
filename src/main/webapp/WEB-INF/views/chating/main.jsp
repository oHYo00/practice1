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
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>


</head>
<body>
<jsp:include page="../common/menubar.jsp"/>
	<script type="text/javascript">
		function realChat() {
		  
	        let uniqueName = "chatbot_" + Date.now();
	        window.open("realChat", uniqueName, "width=640,height=400");
		}

		function openChatBot() {
			window.open("myShopChatBot", "chatbot",
					"width=400,height=400,menubar=no");
		}
	</script>

	<div class="content" style="height: 400px">
		나의 첫 홈페이지.!!!
		<hr>
		<button class="btn btn-primary" onclick="realChat()">실시간채팅</button>
		<br> <br>
		<!-- 챗봇 버튼에 JavaScript 함수를 사용하여 새 창 옵션 적용 -->
		<button class="btn btn-primary" onclick="openChatBot()">챗봇</button>
	</div>

</body>
</html>