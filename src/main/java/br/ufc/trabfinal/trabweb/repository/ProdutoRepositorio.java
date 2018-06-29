package br.ufc.trabfinal.trabweb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.trabfinal.trabweb.bean.Produto;

@Repository @Transactional
public interface ProdutoRepositorio extends JpaRepository<Produto, Integer>{
	
	Produto findByTitulo(String titulo);
	
	Produto findById(int id);
}
