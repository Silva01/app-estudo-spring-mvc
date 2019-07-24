package br.com.daniel.silva.estudo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.daniel.silva.estudo.dao.UsuarioDao;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioDao dao;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ModelAndView listarTodos(ModelMap map) {
		map.addAttribute("usuarios", dao.getTodos());
		return new ModelAndView("/user/list", map);
	}
}
