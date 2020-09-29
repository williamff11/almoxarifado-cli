package br.com.infnet.almoxarifadocli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.com.infnet.almoxarifadocli.model.negocio.Usuario;
import br.com.infnet.almoxarifadocli.model.service.LoginService;

@Controller
@SessionAttributes("user")
public class LoginController {

	@Autowired
	private LoginService service;

	@PostMapping(value = "/login")
	public String autenticacao(Model model, @RequestParam String login, @RequestParam String senha) {

		Usuario usuario = service.autenticacao(login, senha);

		if (usuario == null) {
			model.addAttribute("mensagem", "Credenciais inválidas: " + login);
			return "login";
		} else {
			model.addAttribute("user", usuario);
			return "home";
		}
	}
	
	@GetMapping(value = "/sair")
	public String sair(SessionStatus session) {
		session.setComplete();
		
		return "login";
	}
}
