<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js" lang="zxx">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>IPET - Pet Food eCommerce Bootstrap4 Template</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<style type="text/css" media="screen">
.button {
	background-color: lightgray;
	width: 70px;
	margin: 20px 0;
	justify-content: center;
	display: flex;
}

.text-field {
	background-color: lightgray;
	width: 150px;
	margin: 20px 0;
	justify-content: center;
	display: flex;
	background-color: white;
	font-weight: bolder;
	text-align: center;
}
#myForm{
/* 	border: 1px solid pink; */
	padding: 50px;
	background-color: pink;
	width: 750px;
	margin: 20px auto;
	justify-content: center;
	display: flex;
}
</style>

<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/static/frontstage/img/favicon.png">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/frontstage/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/frontstage/css/animate.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/frontstage/css/simple-line-icons.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/frontstage/css/themify-icons.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/frontstage/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/frontstage/css/slick.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/frontstage/css/meanmenu.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/frontstage/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/frontstage/css/responsive.css">
<script
	src="${pageContext.request.contextPath}/static/frontstage/js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body>
	<%@include file="/templates/frontstage/common/header.jsp"%>
	<div class="breadcrumb-area pt-95 pb-95 bg-img"
		style="background-image:url(${pageContext.request.contextPath}/static/frontstage/img/banner/banner-2.jpg);">
		<div class="container">
			<div class="breadcrumb-content text-center">
				<h2>IPET線上客服</h2>
				<ul>
					<li><a href="index.html">home</a></li>
					<li class="active">IPET CustomerService</li>
				</ul>
			</div>
		</div>
	</div>
	<div style="margin: 50px auto;">

				<h1 align="center" ">歡迎使用IPET線上客服</h1>
		<form id="myForm" action="<%=request.getContextPath()%>/chat.do"
			method="POST">
			<input id="userName" name="userName" class="text-field" type="text"
				readonly="readonly" 
				value="${member.getMemName() == null?'訪客':member.getMemName()}" />
			<input type="submit" id="send" class="button" value="進入" autofocus="autofocus" />
		</form>

	</div>
	<%@include file="/templates/frontstage/common/footer.jsp"%>

	<!-- all js here -->
	<script
		src="${pageContext.request.contextPath}/static/frontstage/js/vendor/jquery-1.12.0.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/frontstage/js/popper.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/frontstage/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/frontstage/js/jquery.counterup.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/frontstage/js/waypoints.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/frontstage/js/elevetezoom.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/frontstage/js/ajax-mail.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/frontstage/js/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/frontstage/js/plugins.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/frontstage/js/main.js"></script>

</body>
<script>
	var inputUserName = document.getElementById("userName");
	inputUserName.focus();

	function sendName() {
		var userName = inputUserName.value.trim();
		if (userName === "") {
			alert("Input a user name");
			inputUserName.focus();
			return;
		} else {
			document.getElementById("myForm").submit();
		}
	}
</script>

</html>