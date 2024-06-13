<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>


<jsp:include page="../common/menubar3.jsp"/>
	<div class="content"style="height: 600px" >

	
	
		
	
날씨 : <input id="weather" value="비"><br>
기온 : <input id="temperature" value="2000"><br>

	<button id="b">날씨 입력</button>
	<hr color="red">
	<div id="result">ajax통신 결과들어가는 곳.</div>
	
	<script type="text/javascript">
	$(function() { 
		$('#b').click(function() {
			$.ajax({
				url: "weatherList",
				data: {
					weather : $('#weather').val(),
					temperature : $('#temperature').val()
				},
				success: function(x) {
					alert("현재날씨")
					$("#result").html(x)
				} //success
			}) //ajax
		}) //b1
	}) //$
</script>


	</div>
</body>
</html>