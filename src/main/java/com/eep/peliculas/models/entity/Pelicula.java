package com.eep.peliculas.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.eep.peliculas.models.component.Movie;
import com.eep.peliculas.models.component.UsuarioComp;

@Entity
@Table(name = "peliculas")
public class Pelicula {
	
	@Id
	@Column(name = "id")
	private String imdbID;
	
	@Column(name = "titulo")
	private String Title;
	
	@Column(name = "director")
	private String Director;
	
	@Column(name = "anio")
	private String Year;
	
	@Column(name = "duracion")
	private String Runtime;
 
	@Column(name = "poster")
	private String Poster;
	
	@Column(name = "puntuacion")
	private Integer Puntuacion;
	
	public Pelicula() {}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		Director = director;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}

	public String getRuntime() {
		return Runtime;
	}

	public void setRuntime(String runtime) {
		Runtime = runtime;
	}

	public String getImdbId() {
		return imdbID;
	}

	public void setImdbId(String imdbId) {
		imdbID = imdbId;
	}

	public String getPoster() {
		return Poster;
	}

	public void setPoster(String poster) {
		Poster = poster;
	}
	
	public Integer getPuntuacion() {
		return Puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		Puntuacion = puntuacion;
	}

	public void copiaMovie(Movie m) {
		this.Title = m.getTitle();
		this.Director = m.getDirector();
		this.Year = m.getYear();
		this.Runtime = m.getRuntime();
		this.imdbID = m.getImdbId();
		this.Poster = m.getPoster();
		this.Puntuacion = m.getPuntuacion();
	}

	public Pelicula(String title, String director, String year, String runtime, String imdbId, String poster) {
		super();
		Title = title;
		Director = director;
		Year = year;
		Runtime = runtime;
		imdbID = imdbId;
		Poster = poster;
	}

	@Override
	public String toString() {
		return "Pelicula [ImdbId=" + imdbID + ", Title=" + Title + ", Director=" + Director + ", Year=" + Year
				+ ", Runtime=" + Runtime + ", Puntuacion=" + Puntuacion + ", Poster=" + Poster + "]";
	}
  
}