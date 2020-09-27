package br.com.infnet.almoxarifadocli.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.infnet.almoxarifadocli.model.negocio.Papelaria;

@FeignClient(url = "http://localhost:8081/api/produtos/papelaria", name = "papelariaClient")
public interface IPapelariaClient {

	@GetMapping
	public List<Papelaria> obterLista();
	
	@GetMapping(value = "/{id}")
	public Papelaria obterPorId(@PathVariable Integer id);
}
