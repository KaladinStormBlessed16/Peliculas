package com.eep.peliculas.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eep.peliculas.models.entity.Pelicula;
import com.eep.peliculas.models.service.IPeliculaService;
import com.eep.peliculas.models.entity.Usuario;

@Repository
public class UsuarioDao implements IUsuarioDao{
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	IPeliculaService peliculaService;
	
	//@Transactional quiere decir que dentro del método se va a realizar una transaccion con la base de datos
	@Transactional(readOnly = true)
	@Override
	public List<Usuario> findAll() {
		return em.createQuery("select u from Usuario u").getResultList();
	}
	
	@Override
	@Transactional
	public void save(Usuario usuario) {

		if (findOne(usuario.getEmail())!=null) {
			if(usuario.getPeliculas()!=null && usuario.getPeliculas().size()>0) {
				for(Pelicula p:usuario.getPeliculas()) {
					if(peliculaService.findOne(p.getTitle())==null)
						peliculaService.save(p);
				}
			}
			//Al ya existir el id del cliente se entiende que estoy modificando uno antiguo y hago una "union"
			em.merge(usuario);
		} else {
			em.persist(usuario);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public Usuario findOne(String email) {
		return em.find(Usuario.class, email);
	}

	@Override
	@Transactional
	public void delete(String email) {
		em.remove(findOne(email));
	}
}
