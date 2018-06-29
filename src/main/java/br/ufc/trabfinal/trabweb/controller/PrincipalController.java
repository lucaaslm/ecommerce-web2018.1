package br.ufc.trabfinal.trabweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrincipalController {
	
	@RequestMapping(path="/logar")
	public String logar() {
		return "login";
	}
	
	@RequestMapping(path="/")
	public String index() {
		return "produtos";
	}

	@RequestMapping(path="/cadastro")
	public String cadastro() {
		return "cadastro";
	}
	
	@RequestMapping(path="/addprod")
	public String addprod() {
		return "editar-produtos";
	}
}
