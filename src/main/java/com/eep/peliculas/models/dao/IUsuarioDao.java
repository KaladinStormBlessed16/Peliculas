package com.eep.peliculas.models.dao;

import java.util.List;

import com.eep.peliculas.models.entity.Usuario;

public interface IUsuarioDao {
	public List<Usuario> findAll();
	
	public void save(Usuario usuario);
	
	public Usuario findOne(String email);
	
	public void delete(String email);
}
