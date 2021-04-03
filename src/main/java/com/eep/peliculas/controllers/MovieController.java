package com.eep.peliculas.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eep.peliculas.models.entity.Usuario;
import com.eep.peliculas.models.component.Movie;
import com.eep.peliculas.models.component.UsuarioComp;
import com.eep.peliculas.models.entity.Pelicula;
import com.eep.peliculas.models.service.IPeliculaService;
import com.eep.peliculas.models.service.IUsuarioService;
import com.eep.peliculas.models.service.OmdbGet;
import com.google.gson.Gson;

@Controller
@RequestMapping("/peliculas")
public class MovieController {
	private String BUSCAR_PELICULA = "buscarPelicula"; 
	private String LISTAR_PELICULAS = "listarPeliculas"; 
	private String DETALLE_PELICULA = "detallePelicula"; 
	boolean fav=false;
	boolean added=false;
	boolean rated=false;
	
	
	@Autowired
	UsuarioComp usuarioComp;
	
	@Autowired
	Movie movie;
	
	@Autowired
	private IUsuarioService usuariosService;
	
	@Autowired
	private Gson gson;
	
	@RequestMapping(value = "/verPelicula", method = RequestMethod.GET)
	public String buscarOMDB(Model model, @RequestParam(value = "Title") String titulo) throws IOException {
		String busqueda="http://www.omdbapi.com/?apikey=dcdf1c79";
		busqueda+="&t=" + titulo;
		
		//Utilizo el sendget para hacer una petición a una web externa
		String texto= OmdbGet.sendGET(busqueda);
		System.out.println(texto);
		
		//Una vez obtengo la respuesta en JSON lo transformo en un objeto de tipo MOVIE
		//GSON es una librería para transformar Json a objetos y al revés.
		//Para utilizarla hay que pasarle el texto(json) y el tipo de objeto al que queremos transformarlo
		
	    movie = gson.fromJson(texto, Movie.class);
	    System.out.println("\n\nMovie: " + movie);
		model.addAttribute("pelicula", movie);
		fav=false;
		added=false;
		model.addAttribute("fav", fav);
		model.addAttribute("added", added);
		return BUSCAR_PELICULA; 
	}
	
	@RequestMapping(value = "/guardarPelicula", method = RequestMethod.GET)
	public String guardarPelicula(Model model) {
		if(!usuarioComp.findPelicula(movie.getTitle())) {
			Pelicula pelicula = new Pelicula();
			pelicula.copiaMovie(movie);
			usuarioComp.getPeliculas().add(pelicula);
			Usuario user=new Usuario();
			user.copia(usuarioComp);
			usuariosService.save(user);
			fav=true;
		}
		else
			added=true;
		
		model.addAttribute("pelicula", movie);
		model.addAttribute("fav", fav);
		model.addAttribute("added", added);
		return BUSCAR_PELICULA; 
	}
	
	@RequestMapping(value = "/buscarPelicula", method = RequestMethod.GET)
	public String crearFormulario(Model model) {
		Movie movie = new Movie();
		model.addAttribute("pelicula", movie);
		return BUSCAR_PELICULA; 
	}
	
	@RequestMapping(value = "/listarPeliculas", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("peliculas", usuarioComp.getPeliculas());
		return LISTAR_PELICULAS;
	}
	
	@RequestMapping(value = "/peliculaDetalle", method = RequestMethod.GET)
	public String mostrarDetalle(@RequestParam(value = "title", required = false) String title, Model model) throws IOException {
		Pelicula peliculaDetalle = usuarioComp.getPelicula(title);
		rated=false;
		if(peliculaDetalle!=null) {
			String busqueda="http://www.omdbapi.com/?apikey=c0899a76";
			busqueda+="&i=" + peliculaDetalle.getImdbId();
			String texto= OmdbGet.sendGET(busqueda);
			
		    movie = gson.fromJson(texto, Movie.class);
			model.addAttribute("pelicula", movie);
			model.addAttribute("rated", rated);
		}

		return DETALLE_PELICULA;
	}
	
	@RequestMapping(value = "/rating", method = RequestMethod.POST)
	public String puntuar(Model model, @ModelAttribute("pelicula") Movie mov) {
		movie.setPuntuacion(mov.getPuntuacion());
		rated=true;
		usuarioComp.actualizarPuntuacionPelicula(movie.getTitle(), movie.getPuntuacion());
		Usuario user=new Usuario();
		user.copia(usuarioComp);
		usuariosService.save(user);		
		
		model.addAttribute("pelicula", movie);
		model.addAttribute("rated", rated);
		
		return DETALLE_PELICULA;
	}
}
