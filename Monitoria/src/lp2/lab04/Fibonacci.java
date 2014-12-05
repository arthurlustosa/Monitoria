package lp2.lab04;

import java.util.Arrays;

/*Aluno: Arthur Vinícius Tomé Rodrigues*/

/**
 * Uma classe que gera os termos da conhecida serie de Fibonacci.
 * 
 * @author Arthur Vinicius
 * @version 1.0
 */

public class Fibonacci {
	long[] box;

	// construtor
	/**
	 * Cria uma sequencia de Fibonacci.
	 */
	public Fibonacci() {
		box = new long[120];
		for(int i=0; i<120; i++) box[i] = -1;
	}

	// métodos

	/**
	 * Calcula o n-esimo termo da sequencia de Fibonacci. "n" representa a
	 * posicao do termo na sequencia (comecando de 1). Caso seja fornecido um
	 * valor de n <= 0, deve ser retornado o primeiro termo da sequencia.
	 *
	 * @param n
	 *            O n-esimo termo a ser calculado.
	 *
	 * @return O n-esimo termo calculado, ou o primeiro termo, se n <= 0.
	 */
	public long termo(int n) {
		if (n <= 0)
			return 0;
		else if (n < 2) {
			return n; 
		} 
		else if(n < 120) {
			if(box[n] != -1)
				return box[n];
			else {
				box[n] = termo(n-1) + termo(n-2);
				return box[n];
			}
		}
		return termo(n-1) + termo(n-2);
	}

	/**
	 * Gera os "n" primeiros termos (1 .. n) da sequencia de Fibonacci em uma
	 * String. Caso seja fornecido um valor de n <= 0, deve ser retornado o
	 * primeiro termo da sequencia.
	 *
	 * @param n
	 *            A quantidade de termos a ser gerada da sequencia.
	 *
	 * @return A string (formato: [termo1, termo2, ..., termon] representando os
	 *         termos gerados da sequencia.
	 */
	public java.lang.String geraTermos(int n) {
		if (n <= 0)
			return "[0]";

		else {
			int[] termos = new int[n];
			for (int i = 0; i < termos.length; i++) {
				double termo = termo(i);
				termos[i] = (int) termo;
			}
		return Arrays.toString(termos);
		}
	}
	
	
	
	@Override
	public String toString() {
		return "Fibonacci [box=" + Arrays.toString(box) + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Fibonacci))
			return false;
		
		return true;
	}

}