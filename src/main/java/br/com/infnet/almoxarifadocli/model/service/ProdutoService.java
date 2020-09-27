package br.com.infnet.almoxarifadocli.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.almoxarifadocli.clients.IProdutoClient;
import br.com.infnet.almoxarifadocli.model.negocio.Produto;


@Service
public class ProdutoService {


	@Autowired private IProdutoClient produtoClient;
	
	public void incluir(Produto produto) {
		produtoClient.incluir(produto);
	}

	public List<Produto> obterProdutos() {
		return produtoClient.obterLista();
	}

	public void excluir(Integer id) {
		produtoClient.excluir(id);
	}

	public Produto obterPorId(Integer id) {
		return produtoClient.obterPorId(id);
	}
}
