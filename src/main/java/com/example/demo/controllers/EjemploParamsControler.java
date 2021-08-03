package com.example.demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsControler {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(name = "texto", required = false, defaultValue = "Algun valor") String texto ,Model model) {
		model.addAttribute("resultado","El texto enviado es: "+ texto);
		return "params/ver";
	}
	
	//recibir mas de un parametro en la url se pasan con @Request y el tipo de dato 
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer numero ,Model model) {
		
		model.addAttribute("resultado","El saludo enviado es: '" +saludo +"' y el numero es: " +numero);
		return "params/ver";
	}
	
	//Utilizando el servlet http
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request ,Model model) {
		Integer numero = null;
		String saludo = request.getParameter("saludo");
		try {			
			numero = Integer.parseInt(request.getParameter("numero"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			numero = 0;
		}
		model.addAttribute("resultado","El saludo enviado es: '" +saludo +"' y el numero es: " +numero);
		return "params/ver";
	}
}
