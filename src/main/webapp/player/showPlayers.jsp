<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet'
	href="../webjars/bootstrap/3.2.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Team</title>
<script>
	/* 	$(document).ready(function() {
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
	 }); */
	$(document)
			.ready(
					function() {
						$
								.ajax({
									url : '${pageContext.request.contextPath}/rest/playerr/getAll',
									type : 'GET',
									success : function(data) {
										var people = [];
										var d = data.length;
										for (var i = 0; i < d; i++) {
											var tblRow = "<tr>" + "<td>"
													+ data[i].firstname + "</td>"
													+ "<td>" + data[i].lastname
													+ "</td>" + "<td>"
													+ data[i].age + "</td>"
													+ "<td>" +
														"<a href='${pageContext.request.contextPath}/updatePlayer/"+data[i].id+"' class='btn btn-xs btn-primary' role='button'>Edit</a> "+
														"<button id="+data[i].id+" onClick='deletePlayer("+data[i].id+")' type='submit' class='btn btn-xs btn-danger'>Delete</button>"
													+ "</td>"
													+ "</tr>"
											$(tblRow).appendTo(
													"#userdata tbody");
										}
									}
								});
					});
</script>
	<script>
		function deletePlayer(id)
				{	
					$.ajax
					(
						{
							url: '${pageContext.request.contextPath}/rest/playerr/delete/'+id,
							type: 'DELETE',
							success: function() { document.location.reload(true);}
						}	
					);
				}
	</script>

<link rel='stylesheet'
	href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<body>

	<div class="container">
		<div class="row">
			<h1 class="text-center">Players</h1>
			<br />

			<table id="userdata" class="table table-striped">
				<thead>
						<th>First name</th>
						<th>Last name</th>
						<th>Age</th>
						<th>Action</th>
				</thead>
				<tbody>
				
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
