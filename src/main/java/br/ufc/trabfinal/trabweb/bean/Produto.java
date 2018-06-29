package br.ufc.trabfinal.trabweb.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	
	public String titulo;
	public Double preco;
	public String caminhoImagem;
	
	public String getCaminhoImagem() {
		return caminhoImagem;
	}
	
	public void setCaminhoImagem(String caminho) {
		this.caminhoImagem = caminho;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
