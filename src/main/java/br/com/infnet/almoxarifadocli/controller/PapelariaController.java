package br.com.infnet.almoxarifadocli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.infnet.almoxarifadocli.model.negocio.Papelaria;
import br.com.infnet.almoxarifadocli.model.service.PapelariaService;

@Controller
public class PapelariaController {

	@Autowired
	private PapelariaService papelariaService;

	@GetMapping(value = "/papelaria")
	public String novo(Model model) {
		model.addAttribute("operacao", "Inclusão");

		return "papelaria/create";
	}

	@GetMapping(value = "/lista-papelaria")
	public String lista(Model model) {
		model.addAttribute("listaPapelaria", papelariaService.obterLista());

		return "papelaria/lista";
	}

	@PostMapping(value = "/papelaria")
	public String incluir(Papelaria papelaria) {
		papelariaService.incluir(papelaria);

		return "redirect:/lista-papelaria";
	}

	@GetMapping(value = "/papelaria/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {

		try {
			papelariaService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão: este item está sendo utilizado!!");
			return this.lista(model);
		}

		return "redirect:/lista-papelaria";
	}

	@GetMapping(value = "/papelaria/{id}/alterar")
	public String alterar(Model model, @PathVariable Integer id) {

		model.addAttribute("papelaria", papelariaService.obterPorId(id));
		model.addAttribute("operacao", "Edição");

		return "papelaria/create";
	}
}
