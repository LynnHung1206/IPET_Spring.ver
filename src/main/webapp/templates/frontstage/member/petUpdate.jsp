<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.web.pet.model.entity.*"%>

<%
Pet pet = (Pet) request.getAttribute("pet");
%>


<!doctype html>
<html class="no-js" lang="zxx">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>IPET - Pet Food eCommerce Bootstrap4 Template</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/static/frontstage/img/favicon.png">

<!-- all css here -->
<style type="text/css" media="screen">
table {
	width: 500px;
	height: 200px;
	margin: auto;
}


</style>
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
				<h2>??????????????????</h2>
				<ul>
					<li><a href="index.html">home</a></li>
					<li class="active">Pet Profile</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="login-register-area pt-95 pb-100">
		<div class="container">
			<div class="row">
				<div class="col-lg-7 col-md-12 ml-auto mr-auto">
					<div class="login-register-wrapper"
						style="margin: 0 auto; text-align: center;">

					<%-- ???????????? --%>
					<c:if test="${not empty errorMsgs}">
						<font style="color: red">?????????????????????:</font>
						<ul>
							<c:forEach var="message" items="${errorMsgs}">
								<li style="color: red">${message}</li>
							</c:forEach>
						</ul>
					</c:if>
					
						<form action="${pageContext.request.contextPath}/ipet-back/pet/edit" method="post">
						
							<table id="petdata">
								<tr>
									<td><label></label></td>
									<td><input type="hidden" name="memId"
										value="<%=pet.getMemId()%>" readonly required></td>
								</tr>
								
								<tr>
									<td><label>????????????:</label></td>
									<td><input type="text" name="petName"
										pattern="[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}"
										value="<%=pet.getPetName()%>"  required></td>
								</tr>
								
								<tr>
									<td></td>
									<td><span style="font-size: 10px;"><i>???????????????????????????????????????_
												, ??????????????????2???10??????</i></span></td>
								</tr>
			
								<tr>
									<td><label>??????:</label></td>
									<td><input type="text" name="petVarId" pattern="[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}"
										value="<%=pet.getPetVarId()%>" required></td>
								</tr>
								
								<tr>
									<td><label>????????????:</label></td>
									<td><select name="petSize" style="background-color: #eceff8; height: 45px;">
											<option value="?????????" ${pet.getPetSize() == "?????????" ?'selected':''}>?????????(??????10????????????)</option>
											<option value="?????????" ${pet.getPetSize() == "?????????" ?'selected':''}>?????????(??????11~25??????)</option>
											<option value="?????????" ${pet.getPetSize() == "?????????" ?'selected':''}>?????????(??????26????????????)</option>
									</select></td>
								</tr>
								
								<tr>
									<td>??????:</td>
									<td><label for="girl"><input type="radio"
											name="petGen" value="<%=pet.getPetGen()%>" checked><%=pet.getPetGen()%></label></td>
								</tr>
								<tr>
									<td><label>????????????:</label></td>
									<td><input type="date" name="petBirth"
										value="<%=pet.getPetBirth()%>"  required></td>
								</tr>
								<tr>
									<td><label>??????:</label></td>
									<td><select name="petStatus" style="background-color: #eceff8; height: 45px;">
											<option value="0" ${pet.getPetStatus() == 0 ?'selected':''}>??????</option>
											<option value="1" ${pet.getPetStatus() == 1 ?'selected':''}>??????</option>
									</select></td>
								</tr>
								
								<tr>
									<td><input type="hidden" name="action" value="update">
										<input type="hidden" name="petId"
										value="<%=pet.getPetId()%> "></td>
									<td><input type="submit" value="????????????" onclick="enter()"></td>
								</tr>


							</table>

			
						</form>
					</div>
				</div>
			</div>
		</div>
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
	<script>
		// 	const account = document.querySelector('#memAc');
		// 	const password = document.querySelector('#memPw');
		// 	const btnLogin = document.querySelector('#btnLogin');

		// 	btnLogin.addEventListener('click',function(){
		// 		fetch('${pageContext.request.contextPath}/ipet-back/member/login', {
		// 			method: 'POST',
		// 			header: {
		// 				'Content-Type': 'application/json' //?????????????????????????????????
		// 			},
		// 			body: JSON.stringify({ 
		// 				memAc: account.value,
		// 				memPw: password.value
		// 			})
		// 		})
		// 		.then(resp => resp.json())
		// 		.then(body => {
		// // 			alert(body.result);
		// 			if(body.result){
		// 				location = '${pageContext.request.contextPath}/templates/frontstage/index.jsp';
		// 			}
		// 		});
		// 	});
	</script>
</body>

</html>