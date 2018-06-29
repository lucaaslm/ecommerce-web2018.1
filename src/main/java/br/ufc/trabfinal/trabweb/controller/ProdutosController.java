package br.ufc.trabfinal.trabweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.trabfinal.trabweb.bean.Produto;
import br.ufc.trabfinal.trabweb.service.ProdutoService;

@Controller
@RequestMapping(path="/produtos")
public class ProdutosController {
	
	@Autowired
	ProdutoService service;
	
	@RequestMapping(path="/")
	public ModelAndView index() {
		
		ModelAndView model = new ModelAndView("produtos");
		List<Produto> produtos = service.getProdutos();
		
		model.addObject("produtos", produtos);
		
		return model;
	}
	
	
	@PostMapping("/addproduto")
	public String addProduto(String titulo, Double preco, @RequestParam(value= "imagem") MultipartFile imagem) {
		
		Produto produto = new Produto();
		produto.setTitulo(titulo);
		produto.setPreco(preco);
		service.addProduto(produto, imagem);
		
		return "redirect:/produtos/";
	}
	
	@RequestMapping("/excluir/{id}")
	public ModelAndView excluirProduto(@PathVariable int id) {
		
		service.removerProduto(id);
		ModelAndView mv = new ModelAndView("redirect:/produtos/");
		
		return mv;
	}
}
