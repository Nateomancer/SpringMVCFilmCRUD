package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.FilmDAO;
import com.skilldistillery.film.entities.Film;
import com.skilldistillery.president.data.President;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO dao;
	
	
	@RequestMapping(path = {"/", "home.do"})
	public String home() {
		
		//needs path
		//needs params
		//needs method
		
		//needs model and view
		
//		mv.setViewName("WEB-INF/film.jsp");
//		mv.addObject("presidents", presidents);
//		return mv;

//inputs jsps
		
//output, single page
		
		
		@RequestMapping(path = "filmInfo.do", params = "id", method = RequestMethod.GET)
		public ModelAndView getFilmById(@RequestParam("id") String party) {
			
			Film film = dao.getFilmById(party);
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("WEB-INF/presidents.jsp");
			mv.addObject("presidents", presidents);
			
			return mv;
		}
		
		
		
		
		return "WEB-INF/views/home.jsp";
	}
}
