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
		<div>
			<h1>Add new film</h1>
<form action="createFilm.do" method="POST">
<fieldset>
				<label for="title">Enter film title:</label>
				 <input type="text" name="title" id="title" min="1" max="50"> 
			<br>	 
				<label for="description">Enter film description:</label>
				 <input type="text" name="description" id="description" min="1" max="500"> 
		<br>
				<label for="releaseYear">Enter film release year:</label>		
<input type="number" name="releaseYear" id="releaseYear" min="1960" max="2022">

<br>
<label for="length">Enter film length:</label>		
<input type="number" name="length" id="length" min="80" max="240">
<br>

<label for="rate">Enter rental rate:</label>		
<input type="number" name="rate" id="rate" step="0.01" value="4.99">
<br>

<label for="replacementCost">Enter disc replacement cost:</label>		
<input type="number" name="replacementCost" id="replacementCost" step="0.01" value="19.99">
<br>

<label for="rentalDuration">Enter rental duration:</label>		
<input type="number" name="rentalDuration" id="rentalDuration" value="3" min="1" max="7">
<br>
				<label for="rating">Film rating:</label>

<select name="rating" id="rating">
    <option value="">--Please choose an option--</option>
    <option value="G">G</option>
    <option value="PG">PG</option>
    <option value="PG13">PG-13</option>
    <option value="R">R</option>
    <option value="NC17">NC-17</option>
</select> 
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
<label for="category">Choose a film category:</label>

<select name="category" id="category">
    <option value="">--Please choose an option--</option>
    <option value="action">Action</option>
    <option value="animation">Animation</option>
    <option value="children">Children</option>
    <option value="classics">Classics</option>
    <option value="comedy">Comedy</option>
    <option value="documentary">Documentary</option>
    <option value="drama">Drama</option>
    <option value="family">Family</option>
    <option value="foreign">Foreign</option>
    <option value="games">Games</option>
    <option value="horror">Horror</option>
    <option value="music">Music</option>
    <option value="new">New</option>
    <option value="sci-fi">Sci-Fi</option>
    <option value="travel">Travel</option>
</select> 
<br>
    <label for="features">Choose your special features:</label>>
      <label for="features">Choose your special features:</label>>
      <input type="checkbox" id="trailers" name="features" value="Trailers">
      <label for="trailers">Trailers</label>
      <input type="checkbox" id="commentaries" name="features" value="Commentaries">
      <label for="commentaries">Commentaries</label>
      <input type="checkbox" id="deleted_scenes" name="features" value="Deleted Scenes">
      <label for="deleted_scenes">Deleted scenes</label>
      <input type="checkbox" id="behind_the_scenes" name="features" value="Behind the Scenes">
      <label for="behind_the_scenes">Behind the Scenes</label>
      <br>
      <input type="submit" value="Submit">
      </fieldset>
			</form>
	</p>
	<br>
	<a href="home.do">Return to main page</a>
</body>
</html>