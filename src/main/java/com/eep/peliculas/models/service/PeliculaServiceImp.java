package com.eep.peliculas.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eep.peliculas.models.dao.IPeliculaDao;
import com.eep.peliculas.models.entity.Pelicula;

@Service
public class PeliculaServiceImp implements IPeliculaService{
	@Autowired
	private IPeliculaDao peliculaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Pelicula> findAll() {
		// TODO Auto-generated method stub
		return peliculaDao.findAll();
	}
	
	@Override
	@Transactional
	public void save(Pelicula pelicula) {
		peliculaDao.save(pelicula);
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public Pelicula findOne(String titulo) {
		return peliculaDao.findOne(titulo);
	}

	@Override
	@Transactional
	public void delete(String titulo) {
		peliculaDao.delete(titulo);
	}
}
