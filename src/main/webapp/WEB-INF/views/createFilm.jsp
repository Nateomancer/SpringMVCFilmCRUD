<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=“stylesheet” href=“style.css”>
<title>Create Film</title>
</head>
<body>
	<p>
	<table>
		<thead>
		</thead>
		<div>
			<h1>Add new film</h1>
			<form action="newFilm.do" method="get">
<fieldset>
				<label for="title">Enter film title:</label>
				 <input type="text" name="title" id="title" min="1" max="50"> 
			<br>	 
				<label for="description">Enter film description:</label>
				 <input type="text" name="description" id="description" min="1" max="500"> 
		<br>
				<label for="language">Choose a language:</label>

<select name="language" id="language">
    <option value="">--Please choose an option--</option>
    <option value="1">English</option>
    <option value="2">Italian</option>
    <option value="3">Japanese</option>
    <option value="4">Mandarin</option>
    <option value="5">French</option>
    <option value="6">German</option>
</select> 
<br>
    <legend>Choose your special features:</legend>
    <div>
      <input type="checkbox" id="trailers" name="features"
             checked>
      <label for="trailers">Trailers</label>
    </div>

    <div>
      <input type="checkbox" id="commentaries" name="features">
      <label for="commentaries">Commentaries</label>
    </div>
    <div>
      <input type="checkbox" id="deleted_scenes" name="features">
      <label for="deleted_scenes">Deleted scenes</label>
    </div>
    <div>
      <input type="checkbox" id="behind_the_scenes" name="features">
      <label for="behind_the_scenes">Behind the Scenes</label>
    </div>
</fieldset>
			</form>
			
		</div>

			<input type="submit" value="Submit">
	</table>
	</p>
</body>
</html>