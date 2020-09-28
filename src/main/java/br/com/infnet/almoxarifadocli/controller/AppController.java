package br.com.infnet.almoxarifadocli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.com.infnet.almoxarifadocli.model.negocio.Usuario;
import br.com.infnet.almoxarifadocli.model.service.UsuarioService;

@Controller
@SessionAttributes("usuario")
public class AppController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/")
	public String showInit() {
		return "login";
	}

	@GetMapping(value = "/home")
	public String showHome() {
		return "home";
	}

	@GetMapping(value = "/login")
	public String showLogin() {
		return "login";
	}

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String showHome(Model model, @RequestParam String login, @RequestParam String senha) {
//
//		Usuario usuario = usuarioService.userExist(login);
//
//		if (usuario == null) {
//			return "usuario/detalhe";
//
//		} else if (!usuarioService.isValid(login, senha)) {
//			model.addAttribute("mensagem", "Credenciais inválidas: " + login);
//			return "login";
//
//		} else {
//			model.addAttribute("user", usuario);
//			return "home";
//		}
//	}
}
