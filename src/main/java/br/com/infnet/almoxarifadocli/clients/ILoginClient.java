package br.com.infnet.almoxarifadocli.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.infnet.almoxarifadocli.model.negocio.Usuario;

@FeignClient(url = "http://localhost:8081/api/login", name = "loginClient")
public interface ILoginClient {

	@PostMapping
	public Usuario autenticacao(@RequestParam String login, @RequestParam String senha);	
}
