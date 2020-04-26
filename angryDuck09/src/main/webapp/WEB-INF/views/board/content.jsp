<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<%@ include file="../include/header.jsp" %>
</head>
<body class="w3-light-grey">
	<%@ include file="../include/side_menu.jsp" %>
	<div class="w3-light-grey" id="main_content">
		<!-- Header -->
		<header>
			<div class="w3-container">
				<h1><b><i class="fas fa-list-alt w3-xxlarge"></i> content</b></h1>
				<div class="w3-section w3-bottombar"></div>
			</div>
		</header>

		<!-- First Photo Grid-->
		<div class="w3-row-padding">
			<div class="w3-container w3-margin-bottom">
				<div class="w3-container w3-white">
			<!--		<div class="w3-half">
						<img src="resources/images/horse01.jpg" alt="Norway" style="width:100%" class="w3-hover-opacity w3-padding-16">
					</div>   -->
					<div class="w3-container w3-white w3-margin">
						<div style="margin-left:16px">
							<p><b><h1>${map.dto.title}</h1></b></p>
							<div>작성자 : ${map.dto.name}</div>
							<p>${map.dto.content}</p>
							<div>${map.dto.timestamp}</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Pagination -->
		<div class="w3-center w3-padding-32">
			<div class="w3-bar">
				<a href="${path}/board" class="w3-bar-item w3-button w3-black w3-hover-grey"> Back </a>
			</div>
		</div>

		<footer>
			<div class="w3-black w3-center w3-padding-24">Created by <a href="" class="w3-hover-opacity">angryduck</a></div>
		</footer>
	</div>
</body>
</html>