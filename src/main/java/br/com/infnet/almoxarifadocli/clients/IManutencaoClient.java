package br.com.infnet.almoxarifadocli.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.infnet.almoxarifadocli.model.negocio.Manutencao;

@FeignClient(url = "http://localhost:8081/api/produtos/manutencao", name = "manutencaoClient")
public interface IManutencaoClient {

	@GetMapping
	public List<Manutencao> obterLista();
	
	@GetMapping(value = "/{id}")
	public Manutencao obterPorId(@PathVariable Integer id);
	
}
