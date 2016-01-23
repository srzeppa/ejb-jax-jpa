<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href="../webjars/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Team</title>
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
														url : '${pageContext.request.contextPath}/rest/playerr/add',
														type : 'POST',
														data : {
															firstName : document
																	.getElementById('firstname').value,
															lastName : document
																	.getElementById('lastname').value,
															phoneNumber : document
																	.getElementById('age').value

														},
														success : function() {
															document.location
																	.replace("${pageContext.request.contextPath}/player");
														},
														error : function() {
															alert("Nieprawidłowo wprowadzono dane!");
														}
													});
										});
					});
</script>
</head>

<body>

	<div class="container">
		<div class="row">
			<h1 class="text-center">Add player</h1>

			<form action="${pageContext.request.contextPath}/rest/playerr/add"
				data-toggle="validator" method="post" class="form-horizontal">

				<div class="form-group">
					<label for="firstname" class="col-sm-2 control-label">First
						name: </label>

					<div class="col-sm-10">
						<input type="text" name="firstname" id="firstname"
							class="form-control" data-minlength="2" required>
					</div>
				</div>

				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">Last
						name: </label>

					<div class="col-sm-10">
						<input type="text" name="lastname" id="lastname"
							class="form-control" required>
					</div>
				</div>

				<div class="form-group">
					<label for="age" class="col-sm-2 control-label">Age:</label>

					<div class="col-sm-10">
						<input type="text" name="age" id="age" class="form-control"
							placeholder="0" required>
					</div>
				</div>
				<div class="form-group text-center">
					<button id="add" type="submit" class="btn btn-success">Dodaj</button>
					<a href="${pageContext.request.contextPath}/player"
						class="btn btn-default" role="button"><button>Wróć</button></a>
				</div>
		</div>

		</form>
	</div>

</body>
</html>
