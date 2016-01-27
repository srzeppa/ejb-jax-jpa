<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pl">
<head>
<script src="${pageContext.request.contextPath}/webjars/jquery/2.1.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/jquery/2.1.4/jquery.js"></script>
	<script>
		$(document).ready(function(){
				$( "#add" ).on('click', function(e)
					{
						e.preventDefault();
						$.ajax
						(
						{
						    url: '${pageContext.request.contextPath}/rest/playerr/add',
						    /* url: '${pageContext.request.contextPath}/player/showPlayers.jsp', */
						    context: document.body,
						    type: 'POST',
						    data:
							{
						    	firstname: document.getElementById('firstname').value,
								lastname: document.getElementById('lastname').value,
								age: document.getElementById('age').value
								
							},
							success: function(){document.location.replace("${pageContext.request.contextPath}/player/showPlayers.jsp");},
							error: function(){alert("error");}
						}		
						).done(function() {
							  $( this ).addClass( "done" );
						});
					}
				);
			}
		);
	</script>
	<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css"  rel="stylesheet">
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" /></script> -->
</head>

<body>
<jsp:include page="../elements/menu.jsp" />
<div class="container">
    <div class="row">
        <h1 class="text-center">Add player</h1>

        	<form action="${pageContext.request.contextPath}/rest/playerr/add" data-toggle="validator" method="post" class="form-horizontal">
        	
		        <div class="form-group">
		            <label for="firstname" class="col-sm-2 control-label">First name: </label>

		            <div class="col-sm-10">
		                <input type="text" name="firstname" id="firstname" class="form-control" data-minlength="2" value="${editedPlayer.getFirstname()}" required >
		            </div>
		        </div>

		        <div class="form-group">
		            <label for="lastname" class="col-sm-2 control-label">Last name: </label>

		            <div class="col-sm-10">
		                <input type="text" name="lastname" id="lastname" class="form-control"  required>
		            </div>
		        </div>

		        <div class="form-group">
		            <label for="age" class="col-sm-2 control-label">Age: </label>

		            <div class="col-sm-10">
		                <input type="text" name="age" id="age" class="form-control" placeholder="0" required>
		            </div>
		        </div>
		        <div class="form-group text-center">
		                <button id="add" type="submit" class="btn btn-success">Add</button>
				<a href="${pageContext.request.contextPath}/player/showPlayers.jsp" class="btn btn-default" role="button">Back</a>
		 	    </div>
		        </div>
		        
          </form>
</div>

</body>
</html>