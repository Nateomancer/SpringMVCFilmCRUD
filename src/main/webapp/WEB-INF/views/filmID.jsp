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
				<th scope="col">Release Year</th>
				<th scope="col">Rental Duration</th>
				<th scope="col">Rental Rate</th>
				<th scope="col">Length</th>
				<th scope="col">Replacement Cost</th>
				<th scope="col">Rating</th>
				<th scope="col">Special Features</th>
				<th scope="col">Category</th>
			</tr>
		</thead>
		<tr>
			<td>${film.id }</td>
			<td>${film.title }</td>
			<td>${film.description }</td>
			<td>${film.releaseYear }</td>
			<td>${film.rentalDuration }</td>
			<td>${film.rate }</td>
			<td>${film.length }</td>
			<td>${film.replacementCost }</td>
			<td>${film.rating }</td>
			<td>${film.features }</td>
			<td>${category }</td>
			

			<td><form action="deleteFilm.do" method="POST">
				<input type="text" hidden="true" value="${film.id }" name="deleteId" /> 
				<input type="submit" value="Delete">
				</form></td>
				<td><form action="startEditFilm.do" method="POST">
				<input type="text" hidden="true" value="${film.id }" name="editId" /> 
				<input type="submit" value="Edit">
				</form></td>
		</tr>

	</table>
	</p>
	<h3>Cast</h3>
	   <ul>
		    	<c:forEach var="actor" items="${cast }">
		    	<li>${actor.firstName } ${actor.lastName }</li>
		    	</c:forEach>
		    </ul>
		    <br>
	<a href="home.do">Return to main page</a>
</body>
</html>