package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.FilmDAO;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO dao;

	public void setFilmDAO(FilmDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(path = { "/", "home.do" })
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("WEB-INF/views/home.jsp");
		return mv;

	}
	
	@RequestMapping(path = {"newFilm.do" })
	public ModelAndView newFilm () {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("WEB-INF/views/newFilm.jsp");
		return mv;

	}
	
	@RequestMapping(path = "createFilm.do", method = RequestMethod.POST)
	public void createFilm(
	  @RequestParam("title") String title, 
	  @RequestParam("description") String description, 
	  @RequestParam("language") int language,
	  @RequestParam("features") String features,
	  @RequestParam("releaseYear") int releaseYear,
	  @RequestParam("rating") String rating,
	  @RequestParam("category") String category) {
	    Film film = new Film();
	    film.setTitle(title);
		film.setDescription(description);
		film.setReleaseYear(releaseYear);
		film.setLanguageId(language);
		film.setRentalDuration(3);
		film.setRate(4.99);
		film.setLength(120);
		film.setReplacementCost(19.99);
		film.setFeatures(features);
		film.setCategory(category);	
		
		Film filmForWeb = dao.createFilm(film);
		
		getFilmById(filmForWeb.getId());
	}	
	
	@RequestMapping(path="filmID.do", params="id", method=RequestMethod.GET)
	  public ModelAndView getFilmById(@RequestParam("id")int id) {
	    ModelAndView mv = new ModelAndView();
	    Film film = dao.getFilmById(id);
	    mv.addObject("film", film);
	    mv.setViewName("WEB-INF/views/filmID.jsp");
	    return mv;
	  }
	

	@RequestMapping(path="filmList.do", params="keyword", method=RequestMethod.GET)
	  public ModelAndView getFilmsByKeyword(@RequestParam("keyword")String keyword) throws SQLException {
	    ModelAndView mv = new ModelAndView();
	    List<Film> filmResults = dao.getFilmsByKeyword(keyword);
	    	mv.addObject("filmResults", filmResults);
	    mv.setViewName("WEB-INF/views/filmList.jsp");
	    return mv;
	  }
//		return "WEB-INF/views/home.jsp";
}
