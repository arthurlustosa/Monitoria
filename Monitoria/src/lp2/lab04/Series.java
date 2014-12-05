package lp2.lab04;

import java.util.Scanner;

/*Aluno: Arthur Vinícius Tomé Rodrigues*/

/**
 * Classe para manipular series matematicas (Usando as classes
 * ProgressaoAritmetica e Fibonacci).
 *
 */
public class Series {
	static Scanner sc = new Scanner(System.in);
	static int comando = 0;
	static ProgressaoAritmetica pa;
	static Fibonacci fi;
	
	public static void main(String[] args) {
		System.out.println("Comandos:");
		System.out.println("1. Para criar uma progressao aritmetica"); 
		System.out.println("2. Para criar uma serie de Fibonacci"); 
		System.out.println("3. Para ver o termo 'n' da sua PA");
		System.out.println("4. Para ver o termo 'n' da serie de Fibonacci"); 
		System.out.println("5. Para mostrar os 'n' primeiros termos da sua PA e da serie de Fibonacci"); 
		System.out.println("6. Para sair.");
		System.out.println("");
		
		do {
			comando = sc.nextInt();
		}
		while (comando != 1 && comando != 2 && comando != 3 && comando != 4 && comando != 5 && comando != 6);
		
		while (comando != 6) {
			
			if (comando == 1) {
				System.out.println("Qual o primeiro termo?");
				int termo1 = sc.nextInt();
				System.out.println("Qual a razao?");
				int razao = sc.nextInt();
				pa = new ProgressaoAritmetica(termo1, razao);
				System.out.println("PA criada.");
			}
			
			else if (comando == 2) {
				fi = new Fibonacci();
				System.out.println("Serie de Fibonacci criada.");
			}
		
			else if (comando == 3) {
				if (pa != null) {
					System.out.println("Qual termo da PA voce deseja ver?");
					int termo = sc.nextInt();
					System.out.println("O termo " + termo +" da PA: " + pa.termo(termo));
				}
				else
					System.out.println("Voce precisa criar uma PA antes.");
				
			}
			
			else if (comando == 4) {
				if (fi != null) {
					System.out.println("Qual termo da Serie de Fibonacci voce deseja ver?");
					int termo = sc.nextInt();
					System.out.println("O termo " + termo + " da serie de Fibonacci: " + fi.termo(termo));
				}
				else
					System.out.println("Voce precisa criar a sequencia de Fibonacci antes.");
			}
			
			else if (comando == 5) {
				System.out.println("Quantos termos deseja ver?");
				int termos = sc.nextInt();
				if (pa != null) {
					System.out.println(termos + " primeiros termos da PA: todos de uma vez...");
					System.out.println(pa.geraTermos(termos));
				}
				else
					System.out.println("Você precisa criar a PA antes.");
				if (fi != null) {
					System.out.println(termos + " primeiros termos da sequencia de fibonacci: todos de uma vez...");
					System.out.println(fi.geraTermos(termos));
				}
				else
					System.out.println("Você precisa criar a sequencia de Fibonacci antes.");
			}
			
			do {
			System.out.println("O que deseja fazer agora?");
			comando = sc.nextInt();
			}
			while (comando != 1 && comando != 2 && comando != 3 && comando != 4 && comando != 5 && comando != 6);
		}

		sc.close();
	}

}