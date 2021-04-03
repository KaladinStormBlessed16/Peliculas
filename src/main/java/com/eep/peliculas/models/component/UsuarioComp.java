package com.eep.peliculas.models.component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.eep.peliculas.models.entity.Pelicula;
import com.eep.peliculas.models.entity.Usuario;

@Component
@SessionScope
public class UsuarioComp implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String email;

	private String nombre;	
	
	private int anioNacimiento;
	
	private String pass;
	
	private List<Pelicula> peliculas;
	
	public UsuarioComp() {
		this.peliculas = new ArrayList<Pelicula>();
	}

	public String getEmail() {
		return email;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getPass() {
		return pass;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getAnioNacimiento() {
		return anioNacimiento;
	}

	public void setAnioNacimiento(int anioNacimiento) {
		this.anioNacimiento = anioNacimiento;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(ArrayList<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	
	public boolean findPelicula(String title) {
		boolean founded=false;
		
		if(peliculas.size()==0 || peliculas==null) {
			System.out.println("\nEl usuario no tiene Peliculas");
			return false;
		}
		
		for (Pelicula pelicula : peliculas) {
			if(pelicula.getTitle().equalsIgnoreCase(title))
				founded = true;
		}
		
		return founded;
	}
	
	public Pelicula getPelicula(String title) {
		
		if(peliculas.size()==0 || peliculas==null) {
			System.out.println("\nEl usuario no tiene Peliculas");
			return null;
		}
		
		for (Pelicula pelicula : peliculas) {
			if(pelicula.getTitle().equalsIgnoreCase(title))
				return pelicula;
		}
		
		return null;
	}
	
	public void copia(Usuario u) {
		this.nombre = u.getNombre();
		this.email = u.getEmail();
		this.anioNacimiento = u.getAnioNacimiento();
		this.pass = u.getPass();
		this.peliculas = u.getPeliculas();
	}
	
	
	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nombre=" + nombre + ", anioNacimiento=" + anioNacimiento + ", pass="
				+ pass + ", peliculas=" + peliculas + "]";
	}

	public boolean actualizarPuntuacionPelicula(String title, int puntuacion) {
		if(peliculas.size()==0 || peliculas==null) {
			System.out.println("\nEl usuario no tiene Peliculas");
			return false;
		}
		
		for (Pelicula pelicula : peliculas) {
			if(pelicula.getTitle().equalsIgnoreCase(title)) {
				pelicula.setPuntuacion(puntuacion);
				return true;
			}	
		}
		return false;
	}
}