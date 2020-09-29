package br.com.infnet.almoxarifadocli.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.infnet.almoxarifadocli.model.negocio.Produto;
import br.com.infnet.almoxarifadocli.model.negocio.Solicitacao;
import br.com.infnet.almoxarifadocli.model.negocio.Usuario;
import br.com.infnet.almoxarifadocli.model.service.ProdutoService;
import br.com.infnet.almoxarifadocli.model.service.SolicitacaoService;
import br.com.infnet.almoxarifadocli.model.service.UsuarioService;

@Controller
public class SolicitacaoController {

	@Autowired
	private SolicitacaoService service;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value = "/solicitacoes")
	public String obterLista(Model model) {

		model.addAttribute("solicitacoes", service.obterLista());

		return "solicitacao/lista";
	}

	@GetMapping(value = "/solicitacao")
	public String novo(Model model) {
		model.addAttribute("produtos", produtoService.obterProdutos());
		model.addAttribute("operacao", "inclusao");

		return "solicitacao/create";
	}

	@PostMapping(value = "/solicitacao")
	public String incluir(
			Model model,
			@RequestParam Optional<String[]> produtos,
			@RequestParam String data,
			@RequestParam Integer usuario) {


		if(produtos.isPresent()) {
			Solicitacao solicitacao = new Solicitacao();
			Usuario user = usuarioService.obterPorId(usuario);
			solicitacao.setUsuario(user);

			List<Produto> lista = new ArrayList<Produto>();
			
			for(String id : produtos.get()) {
				lista.add(produtoService.obterPorId(Integer.valueOf(id)));
			}
			LocalDate newdata = LocalDate.parse(data);  
			
			solicitacao.setData(newdata);
			
			solicitacao.setProdutos(lista);
			
			service.incluir(solicitacao);

			return "redirect:/solicitacoes";
		}
		model.addAttribute("msgError", "Selecione pelo menos um produto");

		return this.novo(model);
	}
	
	@GetMapping(value = "/solicitacao/{id}")
	public String alterar(Model model, @PathVariable Integer id) {

		model.addAttribute("solicitacao", service.obterPorId(id));
		model.addAttribute("operacao", "consulta");
		
		return "solicitacao/create";
	}
}
