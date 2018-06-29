package br.ufc.trabfinal.trabweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.trabfinal.trabweb.bean.Usuario;
import br.ufc.trabfinal.trabweb.repository.UsuarioRepositorio;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepositorio repo;
	
	public Usuario salvarUsuario(Usuario user) {
		
		repo.save(user);
		return user;
	}
	
	public List<Usuario> getUsuarios(){
		
		return repo.findAll();
	}
}
