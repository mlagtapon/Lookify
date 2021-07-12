<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Song</title>
<style>
	#nav {
		margin-left: 90%;
	}
	
	.done {
		margin-left: 75%;
	}
	#main {
		display: flex;
		justify-content: center;
	}
	
	form {
		padding: 20px;
		font-size:20px;
	}
	
	.spaces {
		display: flex;
		justify-content: space-between;
		padding:20px;
	}
	
</style>
</head>
<body>
	<div id="wrapper">
		<div id="nav">
			<a href="/dashboard">Dashboard</a>
		</div>
		<div id="main">
		<form:form action="/songs" method="post" modelAttribute="songs">
    		<div class="spaces">
        		<form:label path="title">Title:</form:label>
        		<form:errors path="title"/>
        		<form:input path="title"/>
    		</div>
    		<div class="spaces">
        		<form:label path="artist">Artist:</form:label>
        		<form:errors path="artist"/>
        		<form:input path="artist"/>
    		</div>
    		<div class="spaces">
    			<form:label path="rating">Rating (1-10):</form:label>
 				<form:select path="rating">
				<form:option value="1" label="1" />
				<form:option value="2" label="2" />
				<form:option value="3" label="3" />
				<form:option value="4" label="4" />
				<form:option value="5" label="5" />
				<form:option value="6" label="6" />
				<form:option value="7" label="7" />
				<form:option value="8" label="8" />
				<form:option value="9" label="9" />
				<form:option value="10" label="10" />
 				</form:select>
    		</div>
    			<input class="done" type="submit" value="Submit"/>
		</form:form> 
		</div>
	</div>
</body>
</html>