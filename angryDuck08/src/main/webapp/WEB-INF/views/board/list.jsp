<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<%@ include file="../include/header.jsp" %>
<script>
function writeBoard(){
	var id= "${sessionScope.id}";
	if(id==""){
		alert("먼저 로그인을 해야합니다.");
		return;
	}
	location.href="${path}/photo_board/write";
}
function accountLogin(){
	location.href="${path}/account/login";
}
function accountJoin(){
	location.href="${path}/account/beforeJoin";
}
</script>
</head>
<body class="w3-light-grey">
	<%@ include file="../include/side_menu.jsp" %>
	<div id="main_content">
		<!-- Header -->
		<header>
			<div class="w3-container">
				<h1>
					<b><i class="fas fa-list-alt w3-xxlarge"></i> Board</b>
				</h1>
				<div class="w3-section w3-bottombar w3-padding-16">
					<div>
					<c:choose>
						<c:when test="${sessionScope.id==null}">
								<button class="w3-button w3-white" onclick="accountLogin()">Login</button>
								<button class="w3-button w3-white" onclick="accountJoin()">Register</button>
						</c:when>
					</c:choose>
						<div style="text-align: right;">
						<input type="button" value="등록하기" onclick="writeBoard()">
						</div>
					</div>
				</div>
			</div>
			
		</header>
		

		<!-- First Photo Grid-->
		<div class="w3-container w3-white w3-margin">
			<div class="w3-padding-16">
				<a href="" class="anchorNoDeco">
					<div class="w3-container">
						<div> <b> [0001] Title : </b><br/> </div>
						<div class="w3-quarter"> Date : 2018.09.23 </div>
						<div class="w3-quarter"> Hit : 13 </div>
						<div class="w3-quarter"> Hit : 13 </div>
						<div class="w3-quarter"> Writer : duckduck </div>
					</div>
				</a>
				<hr>
				<a href="" class="anchorNoDeco">
					<div class="w3-container">
						<div> <b> [0001] Title : </b><br/> </div>
						<div class="w3-quarter"> Date : 2018.09.23 </div>
						<div class="w3-quarter"> Hit : 13 </div>
						<div class="w3-quarter"> Hit : 13 </div>
						<div class="w3-quarter"> Writer : duckduck </div>
					</div>
				</a>
				<hr>
				<a href="" class="anchorNoDeco">
					<div class="w3-container">
						<div> <b> [0001] Title : </b><br/> </div>
						<div class="w3-quarter"> Date : 2018.09.23 </div>
						<div class="w3-quarter"> Hit : 13 </div>
						<div class="w3-quarter"> Hit : 13 </div>
						<div class="w3-quarter"> Writer : duckduck </div>
					</div>
				</a>
				<hr>
				<a href="" class="anchorNoDeco">
					<div class="w3-container">
						<div> <b> [0001] Title : </b><br/> </div>
						<div class="w3-quarter"> Date : 2018.09.23 </div>
						<div class="w3-quarter"> Hit : 13 </div>
						<div class="w3-quarter"> Hit : 13 </div>
						<div class="w3-quarter"> Writer : duckduck </div>
					</div>
				</a>
				<hr>
				<a href="" class="anchorNoDeco">
					<div class="w3-container">
						<div> <b> [0001] Title : </b><br/> </div>
						<div class="w3-quarter"> Date : 2018.09.23 </div>
						<div class="w3-quarter"> Hit : 13 </div>
						<div class="w3-quarter"> Hit : 13 </div>
						<div class="w3-quarter"> Writer : duckduck </div>
					</div>
				</a>
			</div>
		</div>
	</div>
</body>
</html>