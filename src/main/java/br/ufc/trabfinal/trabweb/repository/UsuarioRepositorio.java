package br.ufc.trabfinal.trabweb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.trabfinal.trabweb.bean.Usuario;

@Repository @Transactional
public interface UsuarioRepositorio extends JpaRepository<Usuario, String>{
		
	Usuario findByLogin(String login);
}
