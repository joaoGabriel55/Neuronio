package main;

import java.util.Random;

/**
 * Um neurorio é capaz de aprender coisas pela rede neural Com isso essa
 * classe torna-se padrão para qualquer que seja a problemática
 * 
 **/
public class Neuronio {

	private double[] peso; // Peso para cada entrada
	private double erro; // Taxa de erro para aprendizagem;
	private final static double taxaAprendiz = 0.25;
	private Random rand = new Random();
	// Vetor entrada
	// Recebe os dados da classe rede
	private int[] entry;

	// 0 ou 1
	private int saida;

	public Neuronio(int qtdEntradas) {

		this.entry = new int[qtdEntradas];
		this.peso = new double[qtdEntradas];

		iniciarPeso();
	}

	public void iniciarPeso() {
		for (int i = 0; i < peso.length; i++) {
			peso[i] = rand.nextDouble();
		}
	}

	public void calculaSaida() {

		double somatorio = 0;

		for (int i = 0; i < entry.length; i++) {
			somatorio += entry[i] * peso[i];
		}

		if (somatorio > 0)
			saida = 1;
		else
			saida = 0;
	}
	
	/**
	 * Corrige o erro, redefinindo os pesos
	 * */
	public void refresh() {
		// Wi_novo = Wi_atual + n*e*Xi
		for (int i = 0; i < entry.length; i++) {
			peso[i] = peso[i] + taxaAprendiz * erro * entry[i];
		}
	}

	public double getErro() {
		return erro;
	}

	public void setErro(double saidaDesejada) {
		this.erro = saidaDesejada - saida;

		if (erro != 0)
			refresh();
	}

	public int getSaida() {
		return saida;
	}

	public void setEntry(int[] entry) {
		this.entry = entry;
	}

}
