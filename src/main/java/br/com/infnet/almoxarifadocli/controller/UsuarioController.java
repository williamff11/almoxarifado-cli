package br.com.infnet.almoxarifadocli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.infnet.almoxarifadocli.model.negocio.Usuario;
import br.com.infnet.almoxarifadocli.model.service.SetorService;
import br.com.infnet.almoxarifadocli.model.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private SetorService setorService;
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public String obterLista(Model model) {

		model.addAttribute("usuarios", usuarioService.obterLista());

		return "usuario/lista";
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public String novo(Model model) {
		model.addAttribute("listaSetor", setorService.obterLista());
		model.addAttribute("operacao", "Inclusão");

		return "usuario/create";
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public String incluir(Model model, Usuario usuario) {
		usuarioService.incluir(usuario);

		return "redirect:/usuarios";
	}

	@RequestMapping(value = "/usuario/{id}/excluir", method = RequestMethod.GET)
	public String excluir(Model model, @PathVariable Integer id) {
		usuarioService.excluir(id);

		return "redirect:/usuarios";
	}
	
	@GetMapping(value = "/usuario/{id}/alterar")
	public String alterar(Model model, @PathVariable Integer id) {

		model.addAttribute("usuario", usuarioService.obterPorId(id));
		model.addAttribute("listaSetor", setorService.obterLista());
		model.addAttribute("operacao", "Edição");

		return "usuario/create";
	}
}
