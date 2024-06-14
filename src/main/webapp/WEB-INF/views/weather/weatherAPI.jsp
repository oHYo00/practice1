<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Insert title here</title>
<meta
	content='width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no'
	name='viewport'>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>
<jsp:include page="../common/menubar3.jsp"/>
<div class="content"style="height: 600px" >
	
	<hr color="red">
	
	
	<button id="b1">날씨 알아오기!</button>
	<button id="b3">날씨 사진!</button>
	<hr>
<form action="insert" method = "post">
	<br>
	날씨   : <input id="weather" name="weather" disabled><br>
	풍속   : <input id="wind" name="wind" disabled><br>
	기온   : <input id="temperature" name="temperature" disabled><br>
	체감온도: <input id="bodytemperature" name="bodytemperature"disabled><br>
	구름   : <input id="cloud" name="cloud" disabled><br>
	<button id="b2">날씨 데이터 전송</button>
	</form>
	<div id="result"></div>
	</div>
	<script type="text/javascript">
lat = '';
lon = '';
if (navigator.geolocation) {
	  navigator.geolocation.getCurrentPosition(showPosition);
	} else {
	  console.log("Geolocation is not supported by this browser.");
	}

	function showPosition(position) {
	  console.log("Latitude: " + position.coords.latitude);
	  lat = position.coords.latitude;
	  console.log("Longitude: " + position.coords.longitude);
	  lon =position.coords.longitude;
	}

	$(function() {
		$('#b1').click(function() {
			$.ajax({
				url:'https://api.openweathermap.org/data/2.8/onecall?lat='+ lat +'&lon='+lon+'&exclude=hourly,daily,minutely&appid=9026791acfb08fa57f5ed1821b719aa0',
				dataType : 'json',
				success: function(x){
					console.log(x);
				
							
					$('#weather').val(x.current.weather[0].description);
	                $('#wind').val(x.current.wind_speed);
	                $('#temperature').val(x.current.temp);
	                $('#bodytemperature').val(x.current.feels_like);
	                $('#cloud').val(x.current.clouds);
				}
				
			})		
			
		})
		$('#b3').click(function() {
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
		})
	})
					
</script>
</body>
</html> 