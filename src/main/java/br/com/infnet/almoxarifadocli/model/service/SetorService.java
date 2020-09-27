package br.com.infnet.almoxarifadocli.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.almoxarifadocli.clients.ISetorClient;
import br.com.infnet.almoxarifadocli.model.negocio.Setor;

@Service
public class SetorService {

	@Autowired
	private ISetorClient client;

	public List<Setor> obterLista() {
		return (List<Setor>)client.obterLista();
	}

	public void incluir(Setor setor) {
		client.incluir(setor);
	}
	
	public Setor obterPorId(Integer id) {
		return client.obterPorId(id);
	}

	public void excluir(Integer id) {
		client.excluir(id);
	}
}
