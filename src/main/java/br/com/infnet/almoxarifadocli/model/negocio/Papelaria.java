package br.com.infnet.almoxarifadocli.model.negocio;

public class Papelaria extends Produto {
	
	private String cor;
	private boolean reutilizavel;
	
	@Override
	public String toString() {
		return "Papelaria [cor=" + cor + ", reutilizavel=" + reutilizavel + "]";
	}
	
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public boolean isReutilizavel() {
		return reutilizavel;
	}
	public void setReutilizavel(boolean reutilizavel) {
		this.reutilizavel = reutilizavel;
	}
}
