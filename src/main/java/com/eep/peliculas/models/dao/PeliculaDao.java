package com.eep.peliculas.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eep.peliculas.models.entity.Pelicula;

@Repository
public class PeliculaDao implements IPeliculaDao{
	@PersistenceContext
	private EntityManager em;
	
	//@Transactional quiere decir que dentro del método se va a realizar una transaccion con la base de datos
	@Transactional(readOnly = true)
	@Override
	public List<Pelicula> findAll() {
		return em.createQuery("select p from Pelicula p").getResultList();
	}
	
	@Override
	@Transactional
	public void save(Pelicula pelicula) {
		if (pelicula.getTitle() != null && !pelicula.getTitle().equalsIgnoreCase("")) {
			em.merge(pelicula);
		} else {
			em.persist(pelicula);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public Pelicula findOne(String titulo) {
		return em.find(Pelicula.class, titulo);
	}

	@Override
	@Transactional
	public void delete(String titulo) {
		em.remove(findOne(titulo));
	}
}
