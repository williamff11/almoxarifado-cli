package br.com.infnet.almoxarifadocli.model.negocio;

import java.time.LocalDate;
import java.util.List;

public class Solicitacao {

	private Integer id;
	private Integer quantidade;
	private LocalDate data;
	private List<Produto> produtos;

	private Usuario usuario;

	@Override
	public String toString() {
		return "Solicitacao [id=" + id + ", quantidade=" + quantidade + ", data=" + data + ", produtos=" + produtos
				+ ", usuario=" + usuario + "]";
	}

	public Solicitacao() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
