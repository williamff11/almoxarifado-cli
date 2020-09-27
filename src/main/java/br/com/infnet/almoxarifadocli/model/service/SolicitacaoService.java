package br.com.infnet.almoxarifadocli.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.almoxarifadocli.clients.ISolicitacaoClient;
import br.com.infnet.almoxarifadocli.model.negocio.Solicitacao;

@Service
public class SolicitacaoService {

	@Autowired
	private ISolicitacaoClient client;

	public void incluir(Solicitacao solicitacao) {
		client.incluir(solicitacao);
	}

	public List<Solicitacao> obterLista() {
		return (List<Solicitacao>) client.obterLista();
	}

	public Solicitacao obterPorId(Integer id) {
		return client.obterPorId(id);
	}

	public void excluir(Integer id) {
		client.excluir(id);
	}
}
