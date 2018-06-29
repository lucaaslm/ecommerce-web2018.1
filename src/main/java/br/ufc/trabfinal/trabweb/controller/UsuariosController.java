package br.ufc.trabfinal.trabweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.trabfinal.trabweb.bean.Usuario;
import br.ufc.trabfinal.trabweb.service.UsuarioService;

@Controller
@RequestMapping(path="/usuarios")
public class UsuariosController {
	
	@Autowired
	UsuarioService service;
	
	
	@RequestMapping("/logar")
	public ModelAndView logar() {
		
		ModelAndView mv = new ModelAndView("login");
		return mv;
		
	}
	
	
	@RequestMapping(path="/salvar", method=RequestMethod.POST)
	public String salvarTime(@RequestParam String nome, @RequestParam String cpf,
			@RequestParam String endr, @RequestParam String login, @RequestParam String senha) {
		
		Usuario user = new Usuario();
		user.setNome(nome);
		user.setCpf(cpf);
		//cliente.setDataNasc(dataNasc);
		user.setEndereco(endr);
		user.setLogin(login);
		user.setSenha(new BCryptPasswordEncoder().encode(senha));
		
		service.salvarUsuario(user);
		
		return "redirect:/usuarios/logar";
	}
}
