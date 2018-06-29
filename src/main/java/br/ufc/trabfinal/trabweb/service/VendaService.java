package br.ufc.trabfinal.trabweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.trabfinal.trabweb.bean.Produto;
import br.ufc.trabfinal.trabweb.bean.Sessao;
import br.ufc.trabfinal.trabweb.bean.Venda;
import br.ufc.trabfinal.trabweb.repository.VendaRepositorio;

@Service
public class VendaService {
	
	@Autowired
	VendaRepositorio repo;
	
	@Autowired
	ProdutoService prodService;
	
	List<Produto> carrinho = new ArrayList<Produto>();
	
	public void destroyCarrinho() {
		carrinho.clear();
	}
	
	public void addAoCarrinho(int prodId) {
		
		Produto prod = prodService.getProduto(prodId);
		
		if(prod != null)
			carrinho.add(prod);
	}
	
	public List<Produto> getCarrinho(){
		
		return this.carrinho;
	}
	
	public String fecharVenda() {
		if(carrinho.isEmpty()) {
			return "vazio";
		}
		
		Sessao gambi = new Sessao();
		String loginUsuario = gambi.getUsuario().getLogin();
		
		for(Produto p : carrinho) {
			Venda v = new Venda();
			v.setLoginCliente(loginUsuario);
			v.setTitulo(p.getTitulo());
			v.setPreco(p.getPreco());
			v.setCaminhoImagem(p.getCaminhoImagem());
			
			repo.save(v);
		}
		
		destroyCarrinho();
		return "ok";
	}
	
	public String getNomeDoUsuario() {
		
		Sessao gambi = new Sessao();
		return gambi.getUsuario().getNome();
	}
	
	
	public List<Venda> getProdutosComprados(){
		
		String login = new Sessao().getUsuario().getLogin();
		
		List<Venda> vendas = repo.findAll();
		List<Venda> vendasDoCliente = new ArrayList<Venda>();
		for(Venda v : vendas) {
			if(v.loginCliente.equals(login))
				vendasDoCliente.add(v);
		}
		
		return vendasDoCliente;
	}
}
