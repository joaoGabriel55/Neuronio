package main;

/**
 * A rede serve para que tudo que for apresentado ao neuronio seja analisado de
 * forma tal que ele possa aprender com os acertos e erro igual a um ser humano.
 * Como se fosse um controlador se analisamos pelo lado do MVC.
 **/
public class Rede {

	private int qtdEntradas;
	private Neuronio neuronio;

	public void treinar(int[][] entry, int[] saidaDesejada) {
		double erros = 0;
		qtdEntradas = entry[0].length;
		neuronio = new Neuronio(qtdEntradas);

		do {
			erros = 0;
			for (int i = 0; i < entry.length; i++) {
				neuronio.setEntry(entry[i]);
				neuronio.calculaSaida();
				neuronio.setErro(saidaDesejada[i]);

				erros = erros + Math.abs((neuronio.getErro()));

				System.out.println(erros);
			}

			System.out.println("Erros totais: " + Math.abs(erros));

		} while (erros != 0);

	}

	public int executar(int[] exemplos) {
		neuronio.setEntry(exemplos);
		neuronio.calculaSaida();

		return neuronio.getSaida();
	}

}
