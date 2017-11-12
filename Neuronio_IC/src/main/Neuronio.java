package main;

public class Neuronio {

	private double[] peso; // Peso para cada entrada
	private double valorInicial;
	private double taxaAprendiz;

	public Neuronio(double[] peso, double valorInicial, double taxaAprendiz) {
		super();
		this.peso = peso;
		this.valorInicial = valorInicial;
		this.taxaAprendiz = taxaAprendiz;
	}

	public double[] getPeso() {
		return peso;
	}

	public void setPeso(double[] peso) {
		this.peso = peso;
	}

	public double getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(double valorInicial) {
		this.valorInicial = valorInicial;
	}

	public double getTaxaAprendiz() {
		return taxaAprendiz;
	}

	public void setTaxaAprendiz(double taxaAprendiz) {
		this.taxaAprendiz = taxaAprendiz;
	}

}
