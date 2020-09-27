package br.com.infnet.almoxarifadocli.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.almoxarifadocli.clients.IInformaticaClient;
import br.com.infnet.almoxarifadocli.model.negocio.Informatica;

@Service
public class InformaticaService extends ProdutoService {

	@Autowired
	private IInformaticaClient client;

	public List<Informatica> obterLista() {
		return (List<Informatica>) client.obterLista();
	}

	public Informatica obterPorId(Integer id) {
		return client.obterPorId(id);
	}
}
