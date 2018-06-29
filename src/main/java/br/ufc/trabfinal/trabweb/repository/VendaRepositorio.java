package br.ufc.trabfinal.trabweb.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.trabfinal.trabweb.bean.Venda;

@Repository @Transactional
public interface VendaRepositorio extends JpaRepository<Venda, Integer> {
	
	Venda findByloginCliente(String login);
}
