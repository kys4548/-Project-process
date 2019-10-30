<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
<script>
$(function(){
	$("#accountLogin").click(function(){
		location.href="${path}/account/login";
		});
	$("#accountJoin").click(function(){
		location.href="${path}/account/beforeJoin";
	});
	$("#writePhotoBoard").click(function(){
		var id = "${sessionScope.role}";

		if (id != "recruiter") {
			alert("recruiter만 글을 쓸 수 있습니다.");
			return;
		}
		location.href = "${path}/photo_board/write";
	});
});

</script>
</head>
<body class="w3-light-grey">
	<%@ include file="../include/side_menu.jsp"%>
	<div class="w3-light-grey" id="main_content">
		<!-- Header -->
		<header>
			<div class="w3-container">
				<h1>
					<b><i class="fas fa-drum w3-xxlarge"></i> Concert</b>
				</h1>
				<div class="w3-section w3-bottombar w3-padding-16">
					<div>
					<c:choose>
						<c:when test="${sessionScope.id==null}">
								<button class="w3-button w3-white" id="accountLogin">Login</button>
								<button class="w3-button w3-white" id="accountJoin">Register</button>
						</c:when>
					</c:choose>
						<div style="text-align: right;">
						<input type="button" value="등록하기" id="writePhotoBoard">
						</div>
					</div>
				</div>
			</div>
		</header>
		<div class="w3-center w3-padding-32">
			<div class="w3-bar">
				<c:forEach var="row" items="${list}">
					<div class="w3-row-padding">
						<div class="w3-third w3-container w3-margin-bottom">
							<img src="resources/images/horse01.jpg" alt="ProductImage"
								style="width: 100%" class="w3-hover-opacity">
							<div class="w3-container w3-white">
								<p>
									<b>${row.title}</b>
								</p>
								<p>
									${row.id}<br /> ${row.writer_id}<br /> <a
										href="${path}/photo_board/content/${row.id}">${row.title}</a><br />
									${row.datetime}<br /> ${row.timestamp}<br />
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>



				
		First Photo Grid
		<div class="w3-row-padding">
			<div class="w3-third w3-container w3-margin-bottom">
				<img src="resources/images/title_01.jpg" alt="ProductImage" style="width:100%" class="w3-hover-opacity">
				<div class="w3-container w3-white">
					<p><b>제목</b></p>
					<p>글씨 가눅하.</p>
				</div>
			</div>
			<div class="w3-third w3-container w3-margin-bottom">
				<img src="resources/images/title_02.jpg" alt="ProductImage" style="width:100%" class="w3-hover-opacity">
				<div class="w3-container w3-white">
					<p><b>ㅇㅇㅅ</b></p>
					<p>바이올린을 하고잇어요.</p>
				</div>
			</div>
			<div class="w3-third w3-container">
				<img src="resources/images/title_00.jpg" alt="ProductImage" style="width:100%" class="w3-hover-opacity">
				<div class="w3-container w3-white">
					<p><b>구합니다</b></p>
					<p>피아노.</p>
				</div>
			</div>
		</div>
		<!-- 
		Second Photo Grid
		<div class="w3-row-padding">
			<div class="w3-third w3-container w3-margin-bottom">
				<img src="resources/images/horse04.jpg" alt="ProductImage" style="width:100%" class="w3-hover-opacity">
				<div class="w3-container w3-white">
					<p><b>Lorem Ipsum</b></p>
					<p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>
				</div>
			</div>
			<div class="w3-third w3-container w3-margin-bottom">
				<img src="resources/images/horse05.jpg" alt="ProductImage" style="width:100%" class="w3-hover-opacity">
				<div class="w3-container w3-white">
					<p><b>Lorem Ipsum</b></p>
					<p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>
				</div>
			</div>
			<div class="w3-third w3-container">
				<img src="resources/images/horse05.jpg" alt="ProductImage" style="width:100%" class="w3-hover-opacity">
				<div class="w3-container w3-white">
					<p><b>Lorem Ipsum</b></p>
					<p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>
				</div>
			</div>
		</div>
-->
		<!-- Pagination -->
		<div class="w3-center w3-padding-32">
			<div class="w3-bar">
				<a href="#" class="w3-bar-item w3-button w3-hover-black">≪</a> <a
					href="#" class="w3-bar-item w3-black w3-button">1</a> <a href="#"
					class="w3-bar-item w3-button w3-hover-black">2</a> <a href="#"
					class="w3-bar-item w3-button w3-hover-black">3</a> <a href="#"
					class="w3-bar-item w3-button w3-hover-black">4</a> <a href="#"
					class="w3-bar-item w3-button w3-hover-black">≫</a>
			</div>
		</div>

		<footer>
			<div class="w3-black w3-center w3-padding-24">
				Created by <a href="" class="w3-hover-opacity">angryduck</a>
			</div>
		</footer>
	</div>
</body>
</html>