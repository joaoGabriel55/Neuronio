package main;

import java.util.Scanner;

public class Exe {

	public static void main(String[] arguments) {
		int[][] entry = { { 1, 0, 1, 0 }, 
						  { 0, 1, 0, 1 }, 
						  { 1, 0, 1, 1 }, 
						  { 0, 1, 1, 1 }, 
						  { 0, 0, 1, 1 },
						  { 0, 0, 0, 1 }, 
						};
		int[] saidaAnd = { 0, 1, 0, 1, 0, 1 };
			
		Rede rede = new Rede();
		rede.treinar(entry, saidaAnd);
		
		
		Scanner entrada = new Scanner(System.in);
		
		int[] exemplo = new int[4];

		System.out.println("Digite " + entry[0].length + " atributos: ");
		
		for (int i = 0; i < entry[0].length; i++) {
			exemplo[i] = entrada.nextInt();
		}
		
		int result = rede.executar(exemplo);
		
		if (result == 1) 
			System.out.println("Resfriado");
		else	
			System.out.println("Gripe");
		
			
		

		
		//if(exemplo == entry[])
			
		
		
		
		
	}

}
