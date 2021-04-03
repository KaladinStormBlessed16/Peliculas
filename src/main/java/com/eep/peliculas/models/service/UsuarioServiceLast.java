package com.eep.peliculas.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eep.peliculas.models.dao.IUsuarioDao;
import com.eep.peliculas.models.entity.Usuario;

@Service
public class UsuarioServiceLast implements IUsuarioService{
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioDao.findAll();
	}
	
	@Override
	@Transactional
	public void save(Usuario cliente) {
		usuarioDao.save(cliente);
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public Usuario findOne(String email) {
		return usuarioDao.findOne(email);
	}

	@Override
	@Transactional
	public void delete(String email) {
		usuarioDao.delete(email);
	}
}
