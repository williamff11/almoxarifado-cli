package br.com.infnet.almoxarifadocli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.infnet.almoxarifadocli.model.negocio.Informatica;
import br.com.infnet.almoxarifadocli.model.service.InformaticaService;

@Controller
public class InformaticaController {

	@Autowired
	private InformaticaService InformaticaService;

	@GetMapping(value = "/informatica")
	public String novo(Model model) {
		model.addAttribute("operacao", "inclusão");

		return "informatica/create";
	}

	@GetMapping(value = "/lista-informatica")
	public String lista(Model model) {
		model.addAttribute("listaInformatica", InformaticaService.obterLista());

		return "informatica/lista";
	}

	@PostMapping(value = "/informatica")
	public String incluir(Informatica informatica) {
		InformaticaService.incluir(informatica);

		return "redirect:/lista-informatica";
	}

	@GetMapping(value = "/informatica/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {

		try {
			InformaticaService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão: este item está sendo utilizado!!");
			return this.lista(model);
		}

		return "redirect:/lista-informatica";
	}

	@GetMapping(value = "/informatica/{id}/alterar")
	public String alterar(Model model, @PathVariable Integer id) {

		model.addAttribute("informatica", InformaticaService.obterPorId(id));
		model.addAttribute("operacao", "Edição");

		return "informatica/create";
	}
}
