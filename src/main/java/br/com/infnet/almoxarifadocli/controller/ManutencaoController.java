package br.com.infnet.almoxarifadocli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.infnet.almoxarifadocli.model.negocio.Manutencao;
import br.com.infnet.almoxarifadocli.model.service.ManutencaoService;

@Controller
public class ManutencaoController {

	@Autowired
	private ManutencaoService manutencaoService;

	@GetMapping(value = "/manutencao")
	public String novo(Model model) {
		model.addAttribute("operacao", "Inclusão");

		return "manutencao/create";
	}

	@GetMapping(value = "/lista-manutencao")
	public String lista(Model model) {
		model.addAttribute("listaManutencao", manutencaoService.obterLista());

		return "manutencao/lista";
	}

	@PostMapping(value = "/manutencao")
	public String incluir(Manutencao manutencao) {
		manutencaoService.incluir(manutencao);

		return "redirect:/lista-manutencao";
	}

	@GetMapping(value = "/manutencao/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {

		try {
			manutencaoService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão: este item está sendo utilizado!!");
			return this.lista(model);
		}

		return "redirect:/lista-manutencao";
	}

	@GetMapping(value = "/manutencao/{id}/alterar")
	public String alterar(Model model, @PathVariable Integer id) {

		model.addAttribute("manutencao", manutencaoService.obterPorId(id));
		model.addAttribute("operacao", "Edição");

		return "manutencao/create";
	}
}
