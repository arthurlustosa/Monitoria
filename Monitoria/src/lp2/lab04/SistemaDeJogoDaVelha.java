package lp2.lab04;

import java.util.Scanner;

/*Aluno: Arthur Vinícius Tomé Rodrigues*/

public class SistemaDeJogoDaVelha {
	static char tabuleiro[][] = new char[3][3];
	static final char O = 'O';
	static final char X = 'X';
	static int jogada = 0, j, i;
	static Scanner sc = new Scanner(System.in);
	static boolean a, b, c;
	static String[] jogadores = { "jogador1", "jogador2", "jogador3", "jogador4" };
	static int[] vitorias = { 0, 0, 0, 0 };
	static String participante1, participante2;
	
	public static void main(String[] args) {
		String novapartida = "";

		recebeJogadores();
		
		while (!(novapartida.equals("n"))) {
			
			System.out.println("Quais dos jogadores participarão dessa partida?");
			System.out.print("Jogador 1 ");
			participante1 = sc.next();
			System.out.print("Jogador 2 ");
			participante2 = sc.next();
			
			criaTabuleiro();

			while (jogada <= 9) {
				printaJogo();

				recebeJogada();

				validaJogada();

				a = verificaHorizontais();

				b = verificaVerticais();

				c = verificaDiagonais();

				if (a || b || c)
					break;

				if (jogada == 9) {
					printaJogo();
					System.out.println("\nPARTIDA EMPATADA");
					break;
				}

			}

			jogada = 0;

			do {
				System.out.println("Jogar novamente? (s/n) ");
				novapartida = sc.next();
			} while (!(novapartida.equals("s")) && !(novapartida.equals("n")));

		}

		ordenaRanking();
		
		System.out.println("Ranking:");
		
		for (int i = 0; i < jogadores.length; i++) {
			System.out.println(jogadores[i] + " ganhou " + vitorias[i] + " partida(s).");
		}
		
		sc.close();
	}

	private static void ordenaRanking() {
		for (int i = 0; i < vitorias.length - 1; i++) {
			boolean ordenado = true; 
			for (int j = 0; j < vitorias.length - 1 - i; j++) {
				if (vitorias[j] < vitorias[j + 1]) {
					int aux = vitorias[j];
					String aux1 = jogadores[j];
					vitorias[j] = vitorias[j + 1];
					jogadores[j] = jogadores[j + 1];
					vitorias[j + 1] = aux;
					jogadores[j + 1] = aux1;
					ordenado = false;
				}
			}
			if (ordenado)
				break;
		}
		
	}

	private static void recebeJogadores() {
		System.out.println("Digite o nome dos jogadores");
		System.out.print("Jogador 1: ");
		jogadores[0] = sc.next();
		System.out.print("Jogador 2: ");
		jogadores[1] = sc.next();
		System.out.print("Jogador 3: ");
		jogadores[2] = sc.next();
		System.out.print("Jogador 4: ");
		jogadores[3] = sc.next();
	}

	private static boolean verificaDiagonais() {
		if ((tabuleiro[0][0] == O && tabuleiro[1][1] == O && tabuleiro[2][2] == O)
				|| (tabuleiro[0][2] == O && tabuleiro[1][1] == O && tabuleiro[2][0] == O)) {
			printaJogo();
			System.out.println("\nJogador 1, VOCE VENCEU!!!");
			for (int k = 0; k < jogadores.length; k++) {
				if (jogadores[k].equals(participante1)){
					vitorias[k]++;
					break;
				}
			}
			return true;
		} else if ((tabuleiro[0][0] == X && tabuleiro[1][1] == X && tabuleiro[2][2] == X)
				|| (tabuleiro[0][2] == X && tabuleiro[1][1] == X && tabuleiro[2][0] == X)) {
			printaJogo();
			System.out.println("\nJogador 2, VOCE VENCEU!!!");
			for (int k = 0; k < jogadores.length; k++) {
				if (jogadores[k].equals(participante2)) {
					vitorias[k]++;
					break;
				}	
			}
			return true;
		}
		return false;
	}

	private static boolean verificaVerticais() {
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[0][i] == O && tabuleiro[1][i] == O
					&& tabuleiro[2][i] == O) {
				printaJogo();
				System.out.println("\nJogador 1, VOCE VENCEU!!!");
				for (int k = 0; k < jogadores.length; k++) {
					if (jogadores[k].equals(participante1)) {
						vitorias[k]++;
						break;
					}
				}
				return true;
			} else if (tabuleiro[0][i] == X && tabuleiro[1][i] == X
					&& tabuleiro[2][i] == X) {
				printaJogo();
				System.out.println("\nJogador 2, VOCE VENCEU!!!");
				for (int k = 0; k < jogadores.length; k++) {
					if (jogadores[k].equals(participante2)) {
						vitorias[k]++;
						break;
					}
				}
				return true;
			}

		}
		return false;
	}

	private static boolean verificaHorizontais() {
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[i][0] == O && tabuleiro[i][1] == O
					&& tabuleiro[i][2] == O) {
				printaJogo();
				System.out.println("\nJogador 1, VOCE VENCEU!!!");
				for (int k = 0; k < jogadores.length; k++) {
					if (jogadores[k].equals(participante1)) {
						vitorias[k]++;
						break;
					}
				}
				return true;
			} else if (tabuleiro[i][0] == X && tabuleiro[i][1] == X
					&& tabuleiro[i][2] == X) {
				printaJogo();
				System.out.println("\nJogador 2, VOCE VENCEU!!!");
				for (int k = 0; k < jogadores.length; k++) {
					if (jogadores[k].equals(participante2)) {
						vitorias[k]++;
						break;
					}
				}
				return true;
			}

		}
		return false;
	}

	private static void validaJogada() {
		if (tabuleiro[i - 1][j - 1] == ' ') {
			if ((jogada % 2) == 1)
				tabuleiro[i - 1][j - 1] = X;
			else
				tabuleiro[i - 1][j - 1] = O;
			jogada++;
		}
	}

	private static void recebeJogada() {
		System.out.println("\nINSIRA AS COORDENADAS");
		if ((jogada % 2) == 1)
			System.out.print("JOGADOR 2\nLINHA: ");
		else
			System.out.print("JOGADOR 1\nLINHA: ");

		i = sc.nextInt();
		System.out.print("COLUNA: ");
		j = sc.nextInt();
	}

	private static void printaJogo() {
		System.out.print("JOGO DA VELHA \n");
		for (i = 0; i < 3; i++) {
			System.out.print(tabuleiro[i][0] + "|" + tabuleiro[i][1] + "|"
					+ tabuleiro[i][2]);
			if (i < 3 - 1) {
				System.out.print("\n------\n");
			}
		}
	}

	private static void criaTabuleiro() {	
		for (i = 0; i < 3; i++)
			for (j = 0; j < 3; j++)
				tabuleiro[i][j] = ' ';
	}

}

