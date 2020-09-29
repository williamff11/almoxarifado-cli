package br.com.infnet.almoxarifadocli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.infnet.almoxarifadocli.model.negocio.Setor;
import br.com.infnet.almoxarifadocli.model.service.SetorService;



@Controller
public class SetorController {
	
	@Autowired
	private SetorService setorService;
	
	@RequestMapping(value = "/setores", method = RequestMethod.GET)
	public String obterLista(Model model) {

		model.addAttribute("listaSetor", setorService.obterLista());

		return "setor/lista";
	}

	@RequestMapping(value = "/setor", method = RequestMethod.GET)
	public String novo(Model model) {
		model.addAttribute("operacao", "Inclusão");

		return "setor/create";
	}

	@RequestMapping(value = "/setor", method = RequestMethod.POST)
	public String incluir(Setor setor) {
		setorService.incluir(setor);

		return "redirect:/setores";
	}

	@RequestMapping(value = "/setor/{id}/excluir", method = RequestMethod.GET)
	public String excluir(@PathVariable Integer id) {
		setorService.excluir(id);

		return "redirect:/setores";
	}
	
	@GetMapping(value = "/setor/{id}/alterar")
	public String alterar(Model model, @PathVariable Integer id) {

		model.addAttribute("setor", setorService.obterPorId(id));
		model.addAttribute("operacao", "Edição");

		return "setor/create";
	}
}
