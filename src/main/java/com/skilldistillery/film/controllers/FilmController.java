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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.dao.FilmDAO;
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

	@RequestMapping(path = { "newFilm.do" })
	public ModelAndView newFilm() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("WEB-INF/views/newFilm.jsp");
		return mv;

	}

	@RequestMapping(path = "createFilm.do", method = RequestMethod.POST)
	public ModelAndView createFilm(@RequestParam("title") String title, @RequestParam("description") String description,
			@RequestParam("language") int language,

			@RequestParam("releaseYear") int releaseYear, @RequestParam("rating") String rating,
			@RequestParam("category") String category,

			RedirectAttributes redir, @RequestParam("features") String... features) {
		Film film = new Film();
		ModelAndView mv = new ModelAndView();

		film.setTitle(title);
		film.setDescription(description);
		film.setReleaseYear(releaseYear);
		film.setLanguageId(language);
		// film.setFeatures(features);
		film.setCategory(category);
		film.setRating(rating);

		StringBuilder sb = new StringBuilder();
		if (features != null && features.length > 0) {
			for (int i = 0; i < features.length; i++) {

				if (i < features.length - 1) {
					sb.append(features[i] + ",");
				} else {
					sb.append(features[i]);
				}

			}

		}

		film.setFeatures(sb.toString());

	//	System.out.println(film.getFeatures());

//		 
//	    stmt.setString(1, film.getTitle());
//	    stmt.setString(2, film.getDescription());
//	    stmt.setInt(3, film.getReleaseYear());
//	    stmt.setInt(4, film.getLanguageId());
//	    stmt.setString(5, film.getRating());
//	    stmt.setString(6, film.getFeatures());

		Film filmForWeb = dao.createFilm(film);
//		System.out.println("FilmForWeb Id = " + filmForWeb.getId());
//		System.out.println(film.toString());

		redir.addFlashAttribute("film", filmForWeb);
		mv.setViewName("redirect:displayFilm.do");

		return mv;
	}

	@RequestMapping(path = "displayFilm.do")
	public ModelAndView displayFilm() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("WEB-INF/views/filmID.jsp");
		return mv;

	}

	@RequestMapping(path = "filmID.do", params = "id", method = RequestMethod.GET)
	public ModelAndView getFilmById(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		Film film = dao.getFilmById(id);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/views/filmID.jsp");
		return mv;
	}

	@RequestMapping(path = "filmList.do", params = "keyword", method = RequestMethod.GET)
	public ModelAndView getFilmsByKeyword(@RequestParam("keyword") String keyword) throws SQLException {
		ModelAndView mv = new ModelAndView();
		List<Film> filmResults = dao.getFilmsByKeyword(keyword);
		mv.addObject("filmResults", filmResults);
		mv.setViewName("WEB-INF/views/filmList.jsp");
		return mv;
	}
//		return "WEB-INF/views/home.jsp";
}
