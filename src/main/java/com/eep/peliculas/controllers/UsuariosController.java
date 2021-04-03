package com.eep.peliculas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eep.peliculas.models.component.UsuarioComp;
import com.eep.peliculas.models.entity.Usuario;
import com.eep.peliculas.models.service.IUsuarioService;

@Controller
@RequestMapping("/peliculas")
public class UsuariosController {
	private String VISTA_FORMULARIO = "registroUsuario";
	private String VISTA_LOGIN = "loginUsuario";
	boolean loginError=false;
	
	@Autowired
	UsuarioComp usuarioComp;
	
	@Autowired
	private IUsuarioService usuariosService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String formBuscar(Model model) {
		model.addAttribute("usuario", usuarioComp);
		model.addAttribute("titulo", "Login");
		model.addAttribute("loginError", loginError);
		return VISTA_LOGIN;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String buscar(@ModelAttribute("usuario") UsuarioComp user) {	
		loginError=false;
		Usuario usuarioDB = usuariosService.findOne(user.getEmail());			
		
		if(usuarioDB != null && usuarioDB.getPass().equals(user.getPass())) {
			usuarioComp.copia(usuarioDB);
			return "redirect:buscarPelicula";
		}
		else if(usuarioDB != null && !usuarioDB.getPass().equals(user.getPass())){
			loginError=true;
			return "redirect:login";
		}
		return "redirect:register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String crear(Model model) {
		model.addAttribute("usuario", usuarioComp);
		model.addAttribute("titulo", "Registro de Usuario");
		return VISTA_FORMULARIO; 
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String guardar(@ModelAttribute("usuario") UsuarioComp user) {	
		if(usuariosService.findOne(user.getEmail())==null) {
			Usuario usuario = new Usuario();
			usuario.copia(user);			
			usuariosService.save(usuario);
		}
			
		return "redirect:login";
	}
}
