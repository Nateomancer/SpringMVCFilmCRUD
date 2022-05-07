package com.skilldistillery.film.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Component
public class FilmDaoJdbcImpl implements FilmDAO {

	private static final String url = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String user = "student";
	private static final String pass = "student";

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static String getUrl() {
		return url;
	}

	public static String getDriver() {
		return driver;
	}

	public static String getUser() {
		return user;
	}

	public static String getPass() {
		return pass;
	}

	@Override
	public Film getFilmById(int filmId) {
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(FilmDaoJdbcImpl.getUrl(), FilmDaoJdbcImpl.getUser(),
					FilmDaoJdbcImpl.getPass());
			String sql = "SELECT film.id, title, description, release_year, language_id, language.name, rental_duration, ";
			sql += " rental_rate, length, replacement_cost, rating, special_features " + " FROM film"
					+ " JOIN film_actor ON film.id = film_actor.film_id "
					+ " JOIN language ON film.language_id = language.id " + " WHERE film.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet filmResult = stmt.executeQuery();
			if (filmResult.next()) {
				film = new Film(); // Create the object
				// Here is our mapping of query columns to our object fields:

				film.setId(filmResult.getInt("id"));
				film.setTitle(filmResult.getString("title"));
				film.setDescription(filmResult.getString("description"));
				film.setReleaseYear(filmResult.getShort("release_year"));
				film.setLanguageId(filmResult.getInt("language_id"));
				film.setLanguage(filmResult.getString("name"));
				film.setRentalDuration(filmResult.getInt("rental_duration"));
				film.setRate(filmResult.getDouble("rental_rate"));
				film.setLength(filmResult.getInt("length"));
				film.setReplacementCost(filmResult.getDouble("replacement_cost"));
				film.setRating(filmResult.getString("rating"));
				film.setFeatures(filmResult.getString("special_features"));
				film.setCast(getActorsByFilmId(filmId));
				film.setCategory(getCategoryByFilmId(filmId));
			}

			filmResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;

	}

	// TODO: This method was added by Matt @ 0920 on 7MAY to support User Story #6
	@Override
	public List<Actor> getActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(FilmDaoJdbcImpl.getUrl(), FilmDaoJdbcImpl.getUser(),
					FilmDaoJdbcImpl.getPass());
			String sql = "SELECT id, first_name, last_name"
					+ " FROM actor JOIN film_actor ON actor.id = film_actor.actor_id " + " WHERE film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int actorId = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Actor actor = new Actor(actorId, firstName, lastName);
				actors.add(actor);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

	// TODO: This method was added by Matt @ 0935 on 7MAY to support User Story #6
	@Override
	public String getCategoryByFilmId(int filmId) {
		String category = "";
		try {
			Connection conn = DriverManager.getConnection(FilmDaoJdbcImpl.getUrl(), FilmDaoJdbcImpl.getUser(),
					FilmDaoJdbcImpl.getPass());
			String sql = "SELECT id, name FROM category " +
					     "JOIN film_category ON category.id = film_category.category_id WHERE film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				category += rs.getString("name");
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public List<Film> getFilmsByKeyword(String keyword) throws SQLException {
//			Film matchedFilm = null;
			List<Film> filmResults = new ArrayList<>();
//			List<Actor> filmCast = new ArrayList<>();
			Film film = null;
			int counter = 0;
			String search = keyword;

			// Makes connection to database
			String sql = "SELECT *\n"
					+ "FROM film JOIN language ON film.language_id = language.id\n"
					+ "JOIN film_category ON film.id = film_category.film_id\n"
					+ "JOIN category ON film_category.category_id = category.id\n"
					+ "WHERE film.title LIKE ? OR film.description LIKE ?";

			Connection conn = DriverManager.getConnection(url, user, pass);

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, "%" + search + "%");
			stmt.setString(2, "%" + search + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				counter++;
				// get film and all attributes by filmId
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				Integer releaseYear = rs.getInt("release_year");
				int languageId = rs.getInt("language_id");
				String language = rs.getString("language.name");
				int rentalDuration = rs.getInt("rental_duration");
				double rentalRate = rs.getDouble("rental_rate");
				Integer length = rs.getInt("length");
				double replacementCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String specialfeatures = rs.getString("special_features");
				String category = rs.getString("category.name");
				// create list of actors for each film
				List<Actor> filmCast = new ArrayList<>();
				filmCast.addAll((getActorsByFilmId(id)));

//				// get the language for each film
//				getLanguage(id);

				film = new Film(id, title, description, releaseYear, languageId, language, rentalDuration, rentalRate, length,
						replacementCost, rating, specialfeatures, filmCast, category);
//				this.id = id;
//				this.title = title;
//				this.description = description;
//				this.releaseYear = releaseYear;
//				this.languageId = languageId;
//				this.language = language;
//				this.rentalDuration = rentalDuration;
//				this.rate = rate;
//				this.length = length;
//				this.replacementCost = replacementCost;
//				this.rating = rating;
//				this.features = features;
//				this.cast = cast;
				filmResults.add(film);
			}

			rs.close();
			stmt.close();
			conn.close();

			return filmResults;
		}
//		return null;
//	}

	@Override
	public Film createFilm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFilm() {
		// TODO Auto-generated method stub

	}

	@Override
	public void editFilm() {
		// TODO Auto-generated method stub

	}

}
