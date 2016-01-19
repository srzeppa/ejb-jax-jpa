<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pl">
<head>
<jsp:include page="../elements/head.jsp" />
<script>
	$(document)
			.ready(
					function() {
						$("#add")
								.on(
										'click',
										function(e) {
											e.preventDefault();
											$
													.ajax({
														url : '${pageContext.request.contextPath}/playerRest/playeradd',
														type : 'POST',
														data : {
															firstname : document
																	.getElementById('firstname').value,
															lastname : document
																	.getElementById('lastname').value,
															age : document
																	.getElementById('age').value,

														},
														success : function() {
															document.location
																	.replace("${pageContext.request.contextPath}/playerRest");
														},
														error : function() {
															alert("ERROR!");
														}
													});
										});
					});
</script>
</head>

<body>
<%-- 	<jsp:include page="../views/main/menu.xhtml" /> --%>

	<div class="container">
		<div class="row">
			<h1 class="text-center">Add player</h1>
			<form data-toggle="validator" method="post" class="form-horizontal">


				<div class="form-group">
		           	<label for="firstname" class="col-sm-2 control-label">Firstname:</label>

		            	<div>
		                	<input type="text" name="firstname" min="2" id="firstname" class="form-control"/>
		            	</div>
		        </div>

				<div class="form-group">
		           	<label for="lastname" class="col-sm-2 control-label">Lastname:</label>

		            	<div>
		                	<input type="text" name="opis" min="2" id="lastname" class="form-control"/>
		            	</div>
		        </div>

				<div class="form-group">
					<label for="age">Age:</label>

					<div>
						<input type="text" pattern="[0-9]"
							name="cena" id="cena" class="form-control" placeholder="0.0"
							required>
					</div>
				</div>
				<div>
					<button id="dodaj" type="submit" class="btn btn-success">Add</button>
					<a href="${pageContext.request.contextPath}/playerRest" role="button">Back</a>
				</div>

			</form>

			<jsp:include page="../elements/footer.jsp" />
		</div>
</body>
</html>