package main;

import java.util.Scanner;

public class Exe {

	public static void main(String[] arguments) {
		
		int[][] entry = { { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 0, 1, 1 }, { 0, 1, 1, 1 }, { 0, 0, 1, 1 },
				{ 0, 0, 0, 1 }, };
		int[] saidaAnd = { 0, 1, 0, 1, 0, 1 };
		int[] saidaOr = { 1, 0, 1, 0, 1, 0 };
		int[] saidaXor = { 0, 0, 1, 1, 0, 0 };
		// Duvida

		Rede rede = new Rede();

		@SuppressWarnings("resource")
		Scanner entradaUser = new Scanner(System.in);

		System.out.println("Selecione uma operação");
		System.out.println("AND");
		System.out.println("OR");
		System.out.println("XOR");

		if (entradaUser.nextInt() == 1) {
			rede.treinar(entry, saidaAnd);
		} else if (entradaUser.nextInt() == 2) {
			rede.treinar(entry, saidaOr);
		} else if (entradaUser.nextInt() == 3) {
			rede.treinar(entry, saidaXor);
		}
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);

		int[] exemplo = new int[entry[0].length];

		System.out.println("Digite " + entry[0].length + " atributos: ");

		for (int i = 0; i < entry[0].length; i++) {
			exemplo[i] = entrada.nextInt();
		}

		int result = rede.executar(exemplo);

		if (result == 1)
			System.out.println("Resfriado");
		else
			System.out.println("Gripe");
	}

}
