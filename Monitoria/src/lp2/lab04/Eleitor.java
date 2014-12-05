package lp2.lab04;

/*Aluno: Arthur Vinícius Tomé Rodrigues*/

/** 
Uma classe que cadastra eleitores. 
@author Arthur Vinicius 
@version 1.0
*/
public class Eleitor {

	private static final int TAMANHO_CPF = 11;
	private static final int TAMANHO_TITULO = 12;
	private String nome;
	private int idade;
	private String cpf;
	private String tituloEleitoral;
	
	
	// construtor
	   /**
	    * Cria uma ficha com as informações do eleitor.
	    *
	    * @param nome
	    *            O nome do eleitor.
	    * @param idade
	    *            A idade do eleitor.
	    * @param cpf
	    *            O cpf do eleitor.
	    * @param tituloEleitoral
	    *            A titulo eleitoral do eleitor.
	    */
	public Eleitor(String nome, int idade, String cpf, String tituloEleitoral) throws Exception {
		this.nome = nome; 
		
		if(idade < 16)
			throw new Exception("Idade menor que a necessaria para votar.");
		this.idade = idade;
		
		if(cpf.length() != TAMANHO_CPF)
			throw new Exception("CPF invalido.");
		if(cpf.matches("[0-9]"))
			this.cpf = cpf;
		
		if(tituloEleitoral.length() != TAMANHO_TITULO)
			throw new Exception("Titulo de eleitor invalido.");
		if(tituloEleitoral.matches("[0-9]"))
			this.tituloEleitoral = tituloEleitoral;
	}
	
	// métodos
	 
	   /**
	    * Recupera a idade do eleitor.
	    *
	    * @return A idade do eleitor.
	    */
	public int getIdade() {
		return this.idade;
	}
	
	   /**
	    * Recupera o nome do eleitor.
	    *
	    * @return O nome do eleitor.
	    */
	public String getNome() {
		return this.nome;
	}
	
	   /**
	    * Recupera o cpf do eleitor.
	    *
	    * @return O cpf do eleitor.
	    */
	public String getCpf() {
		return this.cpf;
	}
	
	   /**
	    * Recupera o titulo eleitoral do eleitor.
	    *
	    * @return O titulo eleitoral do eleitor.
	    */
	public String getTitulo() {
		return this.tituloEleitoral;
	}
	
}
