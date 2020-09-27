package br.com.infnet.almoxarifadocli.model.negocio;

public class Informatica extends Produto {

	private String marca;
	private boolean hardware;
	
	@Override
	public String toString() {
		return "Informatica [marca=" + marca + ", hardware=" + hardware + "]";
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public boolean isHardware() {
		return hardware;
	}

	public void setHardware(boolean hardware) {
		this.hardware = hardware;
	}
}
