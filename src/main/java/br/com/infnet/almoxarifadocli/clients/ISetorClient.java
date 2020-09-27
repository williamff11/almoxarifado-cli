package br.com.infnet.almoxarifadocli.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.infnet.almoxarifadocli.model.negocio.Setor;

@FeignClient(url = "http://localhost:8081/api/setores", name = "setoresClient")
public interface ISetorClient {

	@GetMapping
	public List<Setor> obterLista();
	
	@PostMapping
	public void incluir(@RequestBody Setor setor);
	
	@GetMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
	@GetMapping(value = "/{id}")
	public Setor obterPorId(@PathVariable Integer id);
}
