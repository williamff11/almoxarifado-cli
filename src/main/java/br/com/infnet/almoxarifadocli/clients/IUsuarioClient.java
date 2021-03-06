package br.com.infnet.almoxarifadocli.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.infnet.almoxarifadocli.model.negocio.Usuario;

@FeignClient(url = "http://localhost:8081/api/usuarios", name = "usuariosClient")
public interface IUsuarioClient {

	@GetMapping
	public List<Usuario> obterLista();
	
	@PostMapping
	public void incluir(@RequestBody Usuario usuarios);
	
	@GetMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
	@GetMapping(value = "/{id}")
	public Usuario obterPorId(@PathVariable Integer id);	
}
