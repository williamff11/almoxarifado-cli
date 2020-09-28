package br.com.infnet.almoxarifadocli.model.negocio;

public class Manutencao extends Produto {

	private String utilidade;
	private boolean toxico;
	
	public Manutencao() {
		this.setTipoProduto("MAN");
	}
	
	@Override
	public String toString() {
		return "Manutencao [utilidade=" + utilidade + ", toxico=" + toxico + "]";
	}
	
	public String getUtilidade() {
		return utilidade;
	}
	public void setUtilidade(String utilidade) {
		this.utilidade = utilidade;
	}
	public boolean isToxico() {
		return toxico;
	}
	public void setToxico(boolean toxico) {
		this.toxico = toxico;
	}
}
