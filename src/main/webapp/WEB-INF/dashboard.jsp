<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Songs</title>
<style>
	#nav {
		display: flex;
		justify-content: space-evenly;
		padding: 20px;
	}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="nav">
			<a href="/songs/new">Add New</a>
			<a href="/songs/topten">Top Songs</a>
			<form action="/dashboard" method="get">
        		<input type="text" name="search" value="${search}"/>
        		<input class="done" type="submit" value="Search Title"/>
			</form>
		</div>
		<div id="songs">
			<table class="table table-hover w-75 p-3 mx-auto">
    			<thead>
        			<tr>
            			<th>Name</th>
            			<th>Rating</th>
            			<th>Actions</th>
        			</tr>
    			</thead>
    			<tbody>
        			<c:forEach items="${lookify}" var="one">
        			<tr>
            			<td><a href="/songs/${one.id}"><c:out value="${one.title}"/></a></td>
            			<td><c:out value="${one.rating}"/></td>
            			<td>
    					<a href="/songs/delete/${one.id}"><button>Delete</button></a>
    					</td>
        			</tr>
        			</c:forEach>
    			</tbody>
			</table>
		</div>
	</div>
	
</body>
</html>