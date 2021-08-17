package com.example.demo.controllers;

import java.util.Arrays;
import java.util.List;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	/*
	 * @Value("${texto.indexcontroller.index.titulo}") private String textoIndex;
	 * 
	 * @Value("${texto.indexcontroller.perfil.titulo}") private String textoPerfil;
	 * 
	 * @Value("${texto.indexcontroller.listar.titulo}") private String testoListar;
	 */
	
	/**
	 * Responde a una peticion get y devuelve el home
	 * @param model clase de spring para añadir atributos al html
	 * @return la vista que se emcuentra en templates
	 * @implNote Esta inyetando algo??
	 */
	@GetMapping({"/index","/","/home"})
	public String index(Model model) {
		
		model.addAttribute("titulo", "Hola Spring framework");
		return "variables/index";
	}
	
	/**
	 * metodo que responde a una peticion Get a una pagina llamada perfil
	 * en la carpeta templates del proyecto.
	 * crea una instancia del usuario donde se definen los atributos nombre apellido
	 * @param model
	 * @return el perfil.html
	 */
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Pedro");
		usuario.setApellido("Flores");
		usuario.setEmail("florescortespedro94@gmail.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo","Perfil del usuario: ".concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		/*
		 * List<Usuario> usuarios = new ArrayList<>(); usuarios.add( new
		 * Usuario("Sofia", "Leonor", "prueba@hotmail.com") ); usuarios.add( new
		 * Usuario("Leonor", "Flores", "prueba2@hotmail.com") ); usuarios.add( new
		 * Usuario("ElPedrin", "Cortes", "prueba3@hotmail.com") );
		 * model.addAttribute("titulo", "Listado de usuarios");
		 */
		//model.addAttribute("usuarios",usuarios);
		model.addAttribute("titulo", "Listado de usuarios");
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(
			new Usuario("Pedro","Flores","elpedrin@gmail.com"),
			new Usuario("Leonor","cachetes","leoor@gmail.com"),
			new Usuario("Sofia","Flores","sofia@gmail.com")
		);
		
		return usuarios;
	}
}
	