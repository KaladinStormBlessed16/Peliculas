package com.eep.peliculas.models.dao;

import java.util.List;

import com.eep.peliculas.models.entity.Pelicula;

public interface IPeliculaDao {
	public List<Pelicula> findAll();
	
	public void save(Pelicula pelicula);
	
	public Pelicula findOne(String titulo);
	
	public void delete(String titulo);
}
