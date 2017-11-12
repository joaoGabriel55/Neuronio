package main;

import java.util.Scanner;

public class Exe {

	public static void main(String[] arguments) {
		int[][] entry = { 
						{ 1, 0, 1, 0, 0, 0},//Virus 
						{ 0, 1, 0, 1, 0, 0},//Bacteria
						{ 1, 0, 1, 1, 1, 0},//Dor de cabeça 
						{ 0, 1, 0, 1, 1, 1} //Corisa
						};

		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		int op;
		do {
			System.out.println("Operacao:");
			System.out.println("\t0 - AND");
			System.out.println("\t1 - OR");
			System.out.println("\t2 - XOR");

			op = entrada.nextInt();

			if (op >= 0 || op <= 2) {
				Rede rede = new Rede(op);
				rede.treinar(entry);
			}
		} while (op != 3);
	}
}
