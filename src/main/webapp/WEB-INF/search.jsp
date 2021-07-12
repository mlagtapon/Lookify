<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>A Song</title>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<style>
	#nav {
		padding: 20px;
		margin-left: 90%;
	}
	a {
		margin-left: 39%;
	}
</style>
<body>
	<div id="wrapper">
	
	<h1><c:out value="${keyword.title}"/></h1>
	<h1><c:out value="${search.title}"/></h1>
		<div id="nav">
			<a href="/dashboard">Dashboard</a>
		</div>
		
		<div id="main">
			<table class="table table-borderless w-25 p-3 mx-auto">
    			<tr>
      				<th scope="row">Title</th>
      				<td><c:out value="${asong.title}"/></td>
    			</tr>
    			    			<tr>
      				<th scope="row">Artist</th>
      				<td><c:out value="${asong.artist}"/></td>
    			</tr>
    			    			<tr>
      				<th scope="row">Rating</th>
      				<td><c:out value="${asong.rating}"/></td>
    			</tr>
			</table>
			<a href="/songs/delete/${asong.id}">Delete</a>
		</div>

	</div>

</body>
</html>