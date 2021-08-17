package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRuta {
	
	@GetMapping("/")
	public String index(Model model) {
		return "variables/index";
	}
	
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto, Model model) {
		model.addAttribute("titulo", "Resibir parametros de la ruta(@pathvariable)");
		model.addAttribute("resultado","El texto enviado en la ruta es: " + texto);
		return "variables/ver";
	}
	
	// Dos varibales de la ruta 
	@GetMapping("/string/{texto}/{numero}")
	public String dosVariables(@PathVariable String texto, @PathVariable Integer numero, Model model) {
		
		model.addAttribute("titulo", "Resibir parametros de la ruta(@pathvariable)");
		model.addAttribute("resultado","El texto enviado en la ruta es: " + texto + " y el numero es: "+ numero);
		return "variables/ver";
	}
}
