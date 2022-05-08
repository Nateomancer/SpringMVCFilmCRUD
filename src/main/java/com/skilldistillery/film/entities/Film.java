package com.skilldistillery.film.entities;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.RequestParam;

public class Film {
	private int id;
	private String title;
	private String description;
	private int releaseYear;
	private int languageId;
//	private String language;
	private int rentalDuration;
	private double rate;
	private int length;
	private double replacementCost;
	private String rating;
	private String features;
//	private List<Actor> cast;
//	private String category;

	public Film() {
		super();
	}

	public Film(int id, String title, String description, int releaseYear, int languageId, /*String language,*/
			int rentalDuration, double rate, int length, double replacementCost, String rating, String features
			/*List<Actor> cast, String category*/) throws SQLException {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
//		this.language = language;
		this.rentalDuration = rentalDuration;
		this.rate = rate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.features = features;
//		this.cast = cast;
//		this.category = category;
	}

	public Film(String title, String description, int releaseYear, int length, int languageId, String rating/*, String category*/) {
		super();
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rating = rating;
		this.length = length;
		// this.features = features;
//		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(short releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

//	public String getLanguage() {
//		return language;
//	}
//
//	public void setLanguage(String language) {
//		this.language = language;
//	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

//	public List<Actor> getCast() {
//		return cast;
//	}
//
//	public void setCast(List<Actor> cast) {
//		this.cast = cast;
//	}
//
//	public String getCategory() {
//		return category;
//	}
//
//	public void setCategory(String category) {
//		this.category = category;
//	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", description=" + description + ", releaseYear=" + releaseYear
				+ ", languageId=" + languageId + ", rentalDuration=" + rentalDuration + ", rate=" + rate + ", length="
				+ length + ", replacementCost=" + replacementCost + ", rating=" + rating + ", features=" + features
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, features, id, languageId, length, rate, rating, releaseYear, rentalDuration,
				replacementCost, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(description, other.description) && Objects.equals(features, other.features)
				&& id == other.id && languageId == other.languageId && length == other.length
				&& Double.doubleToLongBits(rate) == Double.doubleToLongBits(other.rate)
				&& Objects.equals(rating, other.rating) && releaseYear == other.releaseYear
				&& rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(title, other.title);
	}
	
}
