package br.ufc.trabfinal.trabweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.trabfinal.trabweb.bean.Produto;
import br.ufc.trabfinal.trabweb.bean.Venda;
import br.ufc.trabfinal.trabweb.service.VendaService;

@Controller
@RequestMapping(path="/venda")
public class VendaController {
	
	@Autowired
	VendaService service;
	
	@RequestMapping("/logout")
	public String logout() {
		service.destroyCarrinho();
		
		return "redirect:/logout";
	}
	
	@RequestMapping("/finalizar")
	public String finalizarCompra() {
		
		String retorno = service.fecharVenda();
		if(retorno.equals("ok"))
			return "venda_finalizada";
			
		return "redirect:/produtos/";
	}
	
	@RequestMapping("/historico")
	public ModelAndView historico() {
		
		List<Venda> meusProdutos = service.getProdutosComprados();
		
		ModelAndView mv = new ModelAndView("historico");
		mv.addObject("produtos", meusProdutos);
		
		return mv;
	}
	
	@RequestMapping("/addcarrinho/{id}")
	public ModelAndView addAoCarrinho(@PathVariable int id) {
		
		service.addAoCarrinho(id);
		
		ModelAndView mv = new ModelAndView("redirect:/produtos/");
		
		return mv;
	}
	
	@RequestMapping("/carrinho")
	public ModelAndView compras() {
		
		String nomeUser = service.getNomeDoUsuario();
		List<Produto> meuCarrinho = service.getCarrinho();
		
		ModelAndView mv = new ModelAndView("carrinho");
		
		mv.addObject("produtos", meuCarrinho);
		mv.addObject("nomeusuario", nomeUser);
		
		return mv;
	}
}
