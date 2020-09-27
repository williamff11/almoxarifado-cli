package br.com.infnet.almoxarifadocli.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.almoxarifadocli.clients.IUsuarioClient;
import br.com.infnet.almoxarifadocli.model.negocio.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioClient client;

	public void incluir(Usuario solicitante) {
		client.incluir(solicitante);
	}
	
	public List<Usuario> obterLista() {
		return (List<Usuario>)client.obterLista();
	}

	public void excluir(Integer id) {
		client.excluir(id);		
	}

	public Usuario obterPorId(Integer id) {
		return client.obterPorId(id);
	}
}
