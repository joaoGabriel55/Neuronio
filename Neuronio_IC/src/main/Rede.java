package main;

import java.util.Arrays;
import java.util.Random;

public class Rede {

	private Neuronio neuronio = new Neuronio(new double[3], 0, 0.1);

	private final int aux = -1;
	private final int MAX_EPOCAS = 1000;
	private int operacao = 0;
	private Random rand = new Random();

	public Rede(int op) {

		if ((op >= 0) && (op < 5)) {
			operacao = op + 2;
		}
		// Carregando os pesos randomicamente
		for (int i = 0; i < 3; i++) {
			neuronio.getPeso()[i] = ((rand.nextInt(20) + 1) / 10) - 1;
		}

	}

	public int executar(int x1, int x2) {
		// Somatorio da função
		neuronio.setValorInicial(((aux) * neuronio.getPeso()[0]) + (x1 * neuronio.getPeso()[1]) + (x2 * neuronio.getPeso()[2]));
		// Funcao de Transferencia
		if (neuronio.getValorInicial() > 0) {
			return 1;
		}
		return 0;
	}

	public boolean treinar(int[][] entry) {
		boolean treinou;
		int epoca = 0;
		int erros = 0;
		do {
			treinou = true;
			for (int i = 0; i < 4; i++) {
				// Saida == s
				int s = executar(entry[i][0], entry[i][1]);
				int[][] s2;
				s2 = entry;
				if(i == 0)
					System.out.println("Virus - " + Arrays.toString(s2[i]));
				if(i == 1)
					System.out.println("Bacteria - " + Arrays.toString(s2[i]));
				if(i == 2)
					System.out.println("Dor de Cabeça - " + Arrays.toString(s2[i]));
				if(i == 3)
					System.out.println("Corisa - " + Arrays.toString(s2[i]));
			
				System.out.println("Saida Posição("+ i + "): "+ s +" Epoca: "+ epoca);
				// Compara com o que esta definido no main caso for diferente saida da entrada
				// corrige o peso ate que se chegue no 100%
				if (s != entry[i][operacao]) {
					corrigirPeso(i, s, entry);
					erros++; //Perguntar a Laura
					treinou = false;
				}
			}
			System.out.println("");
			epoca++;
		} while ((treinou == false) && (epoca < MAX_EPOCAS));
		if(erros == 0)
			System.out.println("O algoritmo treinou " + epoca + " epocas. Teve "+ erros + " erro(s). PERFECT!");
		else	
			System.out.println("O algoritmo treinou " + epoca + " epocas. Teve "+ erros + " erro(s).");
		if (treinou == false) {
			System.out.println("O algoritmo nao conseguiu convergir...");
		}
		return treinou;
	}

	public void corrigirPeso(int exemplo, int saida, int[][] entry) {
		neuronio.getPeso()[0] = neuronio.getPeso()[0] + (neuronio.getTaxaAprendiz() * (entry[exemplo][operacao] - saida) * (aux));
		neuronio.getPeso()[1] = neuronio.getPeso()[1] + (neuronio.getTaxaAprendiz() * (entry[exemplo][operacao] - saida) * entry[exemplo][0]);
		neuronio.getPeso()[2] = neuronio.getPeso()[2] + (neuronio.getTaxaAprendiz() * (entry[exemplo][operacao] - saida) * entry[exemplo][1]);
		//System.out.println(neuronio.getPeso()[0] + " " + neuronio.getPeso()[1] + " " + neuronio.getPeso()[2]);
	}

}
