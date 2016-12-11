package org.casadocodigo.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	private String index() {

		System.out.println("Entrando na home! porra!!!");
		
		return "home";
	}
	
}
