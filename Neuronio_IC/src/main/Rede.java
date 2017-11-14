package main;

public class Rede {

	private int qtdEntradas;
	private Neuronio neuronio;

	public void treinar(int[][] entry, int[] saidaDesejada) {
		double erros = 0;

		qtdEntradas = entry[0].length;
		// qtdExemplos = entry.length;

		neuronio = new Neuronio(qtdEntradas);

		do {
			erros = 0;

			for (int i = 0; i < entry.length; i++) {
				neuronio.setEntry(entry[i]);
				neuronio.calculaSaida();
				neuronio.setErro(saidaDesejada[i]);

				Math.abs(erros += neuronio.getErro());

				//System.out.println(Math.abs(erros));
			}

		} while (erros != 0);
		
		System.out.println("Erros totais: "+Math.abs(erros));
	}

	public int executar(int[] exemplos) {

		neuronio.setEntry(exemplos);
		neuronio.calculaSaida();

		if (neuronio.getSaida() > 0)
			return 1;
		else
			return 0;
	}

}
