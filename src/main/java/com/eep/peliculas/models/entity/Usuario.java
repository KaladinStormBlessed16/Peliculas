package com.eep.peliculas.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.eep.peliculas.models.component.UsuarioComp;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String email;

	private String nombre;	
	
	private int anioNacimiento;
	
	private String pass;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Pelicula> peliculas;
	
	public Usuario() {
		this.peliculas= new ArrayList<Pelicula>();
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
	
	public void copia(UsuarioComp u) {
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
		
}
