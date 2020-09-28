package br.com.infnet.almoxarifadocli.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.almoxarifadocli.clients.IPapelariaClient;
import br.com.infnet.almoxarifadocli.model.negocio.Papelaria;

@Service
public class PapelariaService extends ProdutoService {

	@Autowired
	private IPapelariaClient client;

	public List<Papelaria> obterLista() {
		return (List<Papelaria>) client.obterLista();
	}

	public Papelaria obterPorId(Integer id) {
		return client.obterPorId(id);
	}
}
