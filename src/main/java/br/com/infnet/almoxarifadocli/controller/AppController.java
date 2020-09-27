package br.com.infnet.almoxarifadocli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuario")
public class AppController {

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
}
