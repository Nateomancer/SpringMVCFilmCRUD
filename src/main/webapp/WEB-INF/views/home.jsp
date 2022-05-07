<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC Film Site</title>
</head>
<body>

<h1> SDvid Database</h1>
<!-- Find film by id -->
<div>
	<h3>Search for film with film ID</h3>
	<form action="filmID.do" method="get">
	<label for="id">Enter film ID:</label>
	<input type="number" name="id" id="id" min="1" max="4000">
	<input type="submit" value="Search">
	</form>
</div>
<!-- Find by keyword -->
<div>
	<h3>Search for film by keyword</h3>
	<form action="filmList.do" method="get">
	<label for="keyword">Enter keyword:</label>
	<input type="text" name="keyword" id="keyword">
	<input type="submit" value="Search">
	</form>
</div>

<br>
<a href="newFilm.do">Create a New Film</a>
<!-- <input action="createFilm.do" method="get" type="submit" name="addNewFilm" id="addNewFilm" value="Create New Film" /> -->

</body>
</html>