package br.com.infnet.almoxarifadocli.model.negocio;

public class Setor {

	private Integer id;
	private String nome;
	private String descricao;

	public Setor() {
	}

	public Setor(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Setor [id=" + id + ", nome=" + nome + ", descricao=" + descricao + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
