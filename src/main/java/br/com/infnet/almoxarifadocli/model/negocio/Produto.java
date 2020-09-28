package br.com.infnet.almoxarifadocli.model.negocio;

import java.util.List;

public class Produto {

	private Integer id;
	private String descricao;
	private List<Solicitacao> solicitacoes;
	private String tipoProduto;

	@Override
	public String toString() {
		return String.format("%s", this.getDescricao());
	}
	
	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	
	public Produto() {
		super();
	}

	public Produto(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}
}
