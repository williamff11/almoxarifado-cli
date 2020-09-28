package br.com.infnet.almoxarifadocli.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.almoxarifadocli.clients.IManutencaoClient;
import br.com.infnet.almoxarifadocli.model.negocio.Manutencao;

@Service
public class ManutencaoService extends ProdutoService {

	@Autowired
	private IManutencaoClient client;

	public List<Manutencao> obterLista() {
		return (List<Manutencao>) client.obterLista();
	}

	public Manutencao obterPorId(Integer id) {
		return client.obterPorId(id);
	}
}
