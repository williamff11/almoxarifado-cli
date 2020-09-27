package br.com.infnet.almoxarifadocli.clients;

import java.util.List;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.infnet.almoxarifadocli.model.negocio.Produto;

@EnableFeignClients
@FeignClient(url = "http://localhost:8081/api/produtos", name = "produtosClient")
public interface IProdutoClient {

	@GetMapping
	public List<Produto> obterLista();
	
	@PostMapping
	public void incluir(@RequestBody Produto produto);
	
	@GetMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
	@GetMapping(value = "/{id}")
	public Produto obterPorId(@PathVariable Integer id);	
}
