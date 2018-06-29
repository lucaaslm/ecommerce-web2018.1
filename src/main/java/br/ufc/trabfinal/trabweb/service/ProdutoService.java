package br.ufc.trabfinal.trabweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.trabfinal.trabweb.bean.Produto;
import br.ufc.trabfinal.trabweb.repository.ProdutoRepositorio;
import br.ufc.trabfinal.trabweb.util.UsingFileUtils;


@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepositorio repo;
	
	public List<Produto> getProdutos(){
		
		return repo.findAll();
	}
	
	public Produto getProduto(int id) {
		return repo.findById(id);
	}
	
	/*public List<Produto> getProdutosDeUmCliente(List<Venda> vendasDoCliente){
		
		List<Produto> produtos =  repo.findAll();
		List<Produto> produtosDoCliente = new ArrayList<Produto>();
		
		for(Produto p : produtos) {
			for(Venda v : vendasDoCliente) {
				if(v.id_produto == p.getId()) {
					produtosDoCliente.add(p);
					vendasDoCliente.remove(v);
				}
			}
		}
		
		return produtosDoCliente;
	}*/
	
	public void addProduto(Produto produto, MultipartFile imagem) {
		String caminho = "images/" + produto.getTitulo().replaceAll(" ", "") + ".jpg";
		produto.caminhoImagem = caminho;
		UsingFileUtils.salvarImagem(caminho, imagem);
		
		repo.save(produto);
	}
	
	public void removerProduto(int id) {
		repo.deleteById(id);
	}
}
