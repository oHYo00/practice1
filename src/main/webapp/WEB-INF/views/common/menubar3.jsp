<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
<style>
    div{box-sizing: border-box;}
    #header{
        width:80%;
        height:100px;
        padding-top: 20px;
        margin:auto;
    }
    #header>div{width:100%; margin-bottom:10px}
    #header_1{height:40%;}
    #header_2{height:60%;}

    #header_1>div{
        height:100%;
        float:left;
    }
    #header_1_left{width:30%;position:relative;}
    #header_1_center{width:20%;}
    #header_1_right{width:40%;}

    #header_1_left>img{height:80%;position:absolute;margin:auto;top:0;bottom:0;right: 0;left:0;}
    #header_1_right{text-align: center; line-height:35px; font-size: 12px; text-indent: 35px;}
    #header_1_right>a{margin: 5px;}
    #header_1_right>a:hover{cursor: pointer;}
    
    #header_2>ul{width:100%; height:100%; list-style-type: none; margin: auto; padding:0;}
    #header_2>ul>li{float:left; width:10%; height:100%; line-height: 55px; text-align:center;}
    #header_2>ul>li a{text-decoration: none; color:black; font-size: 18px; font-weight: 900;}

    #header_2{border-top:1px solid lightgray}

    #header a{text-decoration:none; color:black}
    
    /* 세부 페이지마다 공통적으로 유지할 style */
    .content{
        background-color:rgb(247, 245, 245);
        width:80%;
        margin:auto;
    }
    .innerOuter{
        border:1px solid lightgray;
        width:80%;
        margin:auto;
        padding:5% 10%;
        background:white;
    }

</style>
</head>
<body>
	<c:if test="${ !empty msg }">
		<script>
			alert("${msg}");
		</script>
		<c:remove var="msg" scope="session"/>
	</c:if>
	<div id="header">
        <div id="header_1">
            
        </div>
       
        <div id="header_2">
            <ul>
            <li><a href="${ pageContext.servletContext.contextPath }">HOME</a></li>
                <li><a href="${ pageContext.servletContext.contextPath }/weather/weather">날씨</a></li>
                <li><a href="${ pageContext.servletContext.contextPath }/weather/weatherSet">날씨사진</a></li>
              <li><a href="${ pageContext.servletContext.contextPath }/weather/weatherAPI">현재 날씨</a></li>
                
                
             <%--    <li><a href="${ pageContext.servletContext.contextPath }/product/product">상품</a></li>
                --%>
            </ul>
        </div>
    </div>

    

    <br clear="both">


</body>
</html>