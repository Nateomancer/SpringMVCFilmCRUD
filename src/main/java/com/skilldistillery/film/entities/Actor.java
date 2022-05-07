package com.skilldistillery.film.entities;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import com.skilldistillery.film.dao.FilmDaoJdbcImpl;

//import com.skilldistillery.film.dao.DatabaseAccessorObject;

public class Actor {

	private int id;
	private String firstName;
	private String lastName;
	private List<Film> films;

	public Actor() {
		super();
	}

	public Actor(int actorId, String firstName, String lastName) throws SQLException {
		setId(actorId);
		setFirstName(firstName);
		setLastName(lastName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		String actor ="Actor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
		for (Film film : films) {
			actor += "\n\t-- " + film.getTitle();
		}
		return actor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName);
	}

}
