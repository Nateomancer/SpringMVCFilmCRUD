package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
			@RequestParam("rentalDuration") int rentalDuration, @RequestParam("rate") double rentalRate,
			@RequestParam("length") int length, @RequestParam("replacementCost") double replacementCost,
			@RequestParam("releaseYear") int releaseYear, @RequestParam("rating") String rating,

			RedirectAttributes redir, @RequestParam("features") String... features) {
		Film film = new Film();
		ModelAndView mv = new ModelAndView();

		film.setTitle(title);
		film.setDescription(description);
		film.setReleaseYear(releaseYear);
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

		Film filmForWeb = dao.createFilm(film);
		if (filmForWeb != null) {
			redir.addFlashAttribute("film", filmForWeb);
			mv.setViewName("redirect:displayFilm.do");
		} else {
			mv.setViewName("WEB-INF/views/deleteDenied.jsp");
		}

		return mv;
	}

	@RequestMapping(path = "displayFilm.do")
	public ModelAndView displayFilm() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("WEB-INF/views/filmID.jsp");
		return mv;
	}

	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.POST)
	public ModelAndView deleteFilm(@RequestParam("deleteId") String id) {
		ModelAndView mv = new ModelAndView();
		int deleteId = Integer.parseInt(id);
		boolean success = dao.deleteFilm(deleteId);
		System.out.println(success);
		if (success == true) {
			mv.addObject("deletedId", deleteId);
			mv.setViewName("WEB-INF/views/deleteConfirmed.jsp");
		} else {
			mv.setViewName("WEB-INF/views/deleteDenied.jsp");
		}
		return mv;
	}

	@RequestMapping(path = "startEditFilm.do", method = RequestMethod.POST)
	public ModelAndView editFilm(@RequestParam("editId") String id) {
		ModelAndView mv = new ModelAndView();
		int editId = Integer.parseInt(id);
		Film film = dao.getFilmById(editId);
		if (film != null) {
			mv.addObject("film", film);
			mv.setViewName("WEB-INF/views/editFilm.jsp");
		} else {
			mv.setViewName("WEB-INF/views/deleteDenied.jsp");
		}
		return mv;
	}

	@RequestMapping(path = "editFilm.do", method = RequestMethod.POST)
	public ModelAndView editFilm(@RequestParam("id") int id, @RequestParam("title") String title,
			@RequestParam("description") String description,
			// @RequestParam("language") int language,
			@RequestParam("releaseYear") int releaseYear, // @RequestParam("rating") String rating,
//			@RequestParam("category") String category,

			RedirectAttributes redir) // @RequestParam("features") String... features)
	{
		Film film = dao.getFilmById(id);
		ModelAndView mv = new ModelAndView();

		film.setTitle(title);
		film.setDescription(description);
		film.setReleaseYear(releaseYear);
//		film.setLanguageId(language);
//		film.setCategory(category);
//		film.setRating(rating);

//		StringBuilder sb = new StringBuilder();
//		if (features != null && features.length > 0) {
//			for (int i = 0; i < features.length; i++) {
//
//				if (i < features.length - 1) {
//					sb.append(features[i] + ",");
//				} else {
//					sb.append(features[i]);
//				}
//			}
//		}
//		film.setFeatures(sb.toString());

		Film filmForWeb = dao.editFilm(film);

		redir.addFlashAttribute("film", filmForWeb);
		mv.setViewName("redirect:displayFilm.do");

		return mv;
	}

	@RequestMapping(path = "filmID.do", params = "id", method = RequestMethod.GET)
	public ModelAndView getFilmById(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		Film film = dao.getFilmById(id);
		if(film != null) {
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/views/filmID.jsp");
		}else {mv.setViewName("WEB-INF/views/filmNotFound.jsp");
		}
		return mv;
	}

	@RequestMapping(path = "filmList.do", params = "keyword", method = RequestMethod.GET)
	public ModelAndView getFilmsByKeyword(@RequestParam("keyword") String keyword) throws SQLException {
		ModelAndView mv = new ModelAndView();
		List<Film> filmResults = dao.getFilmsByKeyword(keyword);
		if(!filmResults.isEmpty()) {
			mv.addObject("filmResults", filmResults);
			mv.setViewName("WEB-INF/views/filmList.jsp");
			}else {mv.setViewName("WEB-INF/views/filmNotFound.jsp");
			}
		return mv;
	}
//		return "WEB-INF/views/home.jsp";
}