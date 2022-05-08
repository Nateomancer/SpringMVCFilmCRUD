package com.skilldistillery.film.dao;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.*;

public interface FilmDAO {
	
/*
 * User Story 1
 * A user can enter a Film's ID and see the details of the film in a web page. 
 * If the film is not found, they see an appropriate message.
 */
	public Film getFilmById(int filmId);

	/*
	 * User Story 6
	 * When a film's details are displayed, its actors and categories are also listed.
	 */
//	public Actor findActorById(int actorId);

	public List<Actor> getActorsByFilmId(int filmId);
	
	public String getCategoryByFilmId(int filmId);

	/*
	 * User Story 5
	 * A user can search for films by keyword/pattern in title or description. 
	 * From the resulting list of films, the user can choose to update or delete a record.
	 */
	public List<Film> getFilmsByKeyword(String keyword) throws SQLException;
	
	/*
	 * User Story 2
	 * A user can choose to add a new film. 
	 * They can enter all the properties of the film. 
	 * Their input will be used to create Film object, 
	 * which the DAO implementation will save in the database. 
	 * If the insert fails, the user is informed of this.
	 */
	public Film createFilm();
	
	/*
	 * User Story 3
	 * When a user retrieves a film, they have the option of deleting it. 
	 * If they delete the film, it is removed from the database. 
	 * If the delete fails (such as, due to child records), the user is informed of this.
	 * Note: It is not necessary to be able to delete existing films, 
	 * which have child records in various tables. 
	 * Test your delete functionality using new films you've created via User Story 2.
	 */
	public boolean deleteFilm(int x);
	
	/*
	 * User Story 4
	 * When a user retrieves a film, they have the option of editing it. 
	 * If they choose this, all the film's current properties are displayed in a form, 
	 * allowing them to change any property except the film's ID. 
	 * When they submit the form, that film's record is updated in the database. 
	 * If the update fails, the user is informed of this.
	 */
	public void editFilm();

	Film createFilm(Film film);

}