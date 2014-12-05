package lp2.lab04;

import java.util.Arrays;

/*Aluno: Arthur Vinícius Tomé Rodrigues*/

/** 
Uma classe que calcula progressoes aritmeticas. 
@author Arthur Vinicius 
@version 1.0
*/
public class ProgressaoAritmetica {

	private int primeiro, razao, termoAtual;
	
	// construtor
	   /**
	    * Cria uma progressao aritmetica a partir do primeiro termo e da razao.
	    *
	    * @param primeiro
	    *            O primeiro termo da progressao.
	    * @param razao
	    *            A razao da progressao.
	    */
	public ProgressaoAritmetica(int primeiro, int razao) {
		this.primeiro = primeiro;
		this.termoAtual = primeiro;
		this.razao = razao;
	}

	// métodos
	 
	   /**
	    * Recupera a razao da progressao.
	    *
	    * @return A razao da progressao.
	    */
	public int getRazao() {
		return this.razao;
	}

	   /**
	    * Calcula o proximo termo da progressao aritmetica. 
	    * O termo gerado passa a ser o termo atual da progressao.
	    *
	    * @return O proximo termo da progressao aritmetica.
	    */
	public int proximo() {
		int proximoTermo = this.termoAtual + this.razao;
		this.termoAtual = proximoTermo;
		return proximoTermo;
	}

	   /**
	    * Reinicia a progressao aritmetica para o seu primeiro termo.
	    * O primeiro termo passa a ser o termo atual da progressao.
	    *
	    * @return O primeiro termo da progressao aritmetica.
	    */
	public int primeiro() {
		this.termoAtual = this.primeiro;
		return this.primeiro;
	}

	   /**
	    * Calcula o n-esimo termo da progressao aritmetica.
	    * "n" representa a posicao do termo na progressao (comecando de 1).
	    * Caso seja fornecido um valor de n <= 0, deve ser retornado o primeiro termo da progressao.
	    * O termo gerado passa a ser o termo atual da progressao.
	    *
	    * @param n
	    * 			O n-esimo termo a ser calculado.
	    *
	    * @return O n-esimo termo calculado, ou o primeiro termo, se n <= 0.
	    */
	public int termo(int n) {
		if (n <= 0)
			return this.primeiro;
		int termoN = this.primeiro + (n - 1) * this.razao;
		this.termoAtual = termoN;
		return termoN;
	}

	   /**
	    * Gera os "n" primeiros termos (1 .. n) da progressao aritmetica em uma String. 
	    * Caso seja fornecido um valor de n <= 0, deve ser retornado o primeiro termo da progressao. 
	    * O ultimo termo gerado passa a ser o termo atual da progressao.
	    *
	    * @param n
	    * 			A quantidade de termos a ser gerada da progressao.
	    *
	    * @return A string (formato: [termo1, termo2, ..., termon] representando os termos gerados da progressao.
	    */
	public java.lang.String geraTermos(int n) {
		if (n <= 0)
			return "[" + this.primeiro + "]";
		
		int[] termos = new int[n];
		for (int i = 0; i < termos.length; i++) {
			termos[i] = this.primeiro + (i) * this.razao;
		}
		this.termoAtual = termos[termos.length-1];
		return Arrays.toString(termos);
	}
	
	@Override
	public String toString() {
		return "ProgressaoAritmetica [primeiro=" + primeiro + ", razao="
				+ razao + ", termoAtual=" + termoAtual + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ProgressaoAritmetica))
			return false;
		
		ProgressaoAritmetica umaProgressaoAritmetica = (ProgressaoAritmetica) obj;
		
		return getRazao() == umaProgressaoAritmetica.getRazao() && 
				primeiro() == umaProgressaoAritmetica.primeiro() &&
				proximo() == umaProgressaoAritmetica.proximo();
	}
	
}
