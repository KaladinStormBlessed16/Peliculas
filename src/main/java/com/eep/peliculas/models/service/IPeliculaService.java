package com.eep.peliculas.models.service;

import java.util.List;

import com.eep.peliculas.models.entity.Pelicula;

public interface IPeliculaService {
	
	public List<Pelicula> findAll();
	
	public void save(Pelicula pelicula);
	
	public Pelicula findOne(String pelicula);
	
	public void delete(String titulo);
}
