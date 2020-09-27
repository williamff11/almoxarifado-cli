package br.com.infnet.almoxarifadocli.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.infnet.almoxarifadocli.model.negocio.Informatica;

@FeignClient(url = "http://localhost:8081/api/produtos/informatica", name = "informaticaClient")
public interface IInformaticaClient {

	@GetMapping
	public List<Informatica> obterLista();
	
	@GetMapping(value = "/{id}")
	public Informatica obterPorId(@PathVariable Integer id);
	
}
