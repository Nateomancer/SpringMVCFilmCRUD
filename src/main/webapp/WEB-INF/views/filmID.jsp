<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=“stylesheet” href=“style.css”>
<title>Film Results</title>
</head>
<body>
	<p>
	<table>
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Title</th>
				<th scope="col">Description</th>
				<th scope="col">Language</th>
				<th scope="col">Category</th>
			</tr>
		</thead>
		<tr>
			<td>${film.id }</td>
			<td>${film.title }</td>
			<td>${film.description }</td>
			<td>${film.language }</td>
			<td>${film.category }</td>

			<td><form action="deleteFilm.do" method="POST">
				<input type="text" hidden="true" value="${film.id }" name="deleteId" /> 
				<input type="submit" value="Delete">
				</form></td>
		</tr>

	</table>
	</p>
</body>
</html>