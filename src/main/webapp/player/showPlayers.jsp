<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="../webjars/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Team</title>
<script>
	$(document).ready(function() {
		$.ajax({
			url : '${pageContext.request.contextPath}/rest/playerr/getAll',
			type : 'GET',
			success : function(data) {
				var d = data.length;
				var table = document.getElementById("table");
				for (var i = 0; i < d; i++) {

					tr = $('<tr/>');
					tr.append("<td>" + data[i].firstname + "</td>");
					tr.append("<td>" + data[i].lastname + "</td>");
					tr.append("<td>" + data[i].age + "</td>");
					td = $('<td/>');
					tr.append(td);
					$(table).append(tr);
				}
			}
		});
	});
</script>

        <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<body>

	<div class="container">
		<div class="row">
			<h1 class="text-center">Players</h1>
			<br />

			<table id="table" class="table table-striped">
				<tr>
					<td>First name</td>
					<td>Last name</td>
					<td>Age</td>
					<td>Action</td>
				</tr>
				<tr>
					<td id="pole1"></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
