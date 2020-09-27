package br.com.infnet.almoxarifadocli.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.infnet.almoxarifadocli.model.negocio.Solicitacao;

@FeignClient(url = "http://localhost:8081/api/solicitacoes", name = "solicitacoesClient")
public interface ISolicitacaoClient {

	@GetMapping
	public List<Solicitacao> obterLista();
	
	@PostMapping
	public void incluir(@RequestBody Solicitacao solicitacao);
	
	@GetMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
	@GetMapping(value = "/{id}")
	public Solicitacao obterPorId(@PathVariable Integer id);	
}
