package com.listaeventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.listaeventos.models.Evento;
import com.listaeventos.repository.EventoRepository;

@Controller
public class EventoController {
	
	@Autowired
	private EventoRepository er;
	
	@RequestMapping (value = "/cadastrarEvento", method = RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}
	
	@RequestMapping (value = "/cadastrarEvento", method = RequestMethod.POST)
	public String form(Evento evento) {
		getEr().save(evento);
		return "redirect:/cadastrarEvento";
	}
	
	@RequestMapping(value="/listaEventos")
	@ResponseBody
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("listaEventos");
		Iterable<Evento> eventos = getEr().findAll();
		mv.addObject("eventos", eventos);
		return mv;
	}

	public EventoRepository getEr() {
		return er;
	}

	public void setEr(EventoRepository er) {
		this.er = er;
	}

	
}
