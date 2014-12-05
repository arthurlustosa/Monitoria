package extra;

/**
 * Classe para representar um eleitor.
 * 
 * @author arthur
 * @version 1.0
 */

public class Eleitor {
	 private String nome;
	 private String cpf;
	 private int titulo;
	 private int idade;
	 
	 /**
	  * Cria um eleitor.
	  * 
	  * @param nome
	  * 	nome do eleitor.
	  * @param cpf
	  * 	cpf do eleitor.
	  * @param idade
	  * 	idade do eleitor.
	  * @param titulo
	  * 	titulo do eleitor.
	  */
	 
	 public Eleitor(String nome, String cpf, int idade, int titulo) {
		 this.nome = nome;
		 this.cpf = cpf;
		 this.idade = idade;
		 this.titulo = titulo;
	 }
	 
	 /**
	  * verifica se o eleitor esta apto para exercer sua cidadania.
	  * 
	  * @return Um booleano que representa uma resposta positiva ou negativa em relação ao eleitor poder votar.
	  */
	 
	 public boolean verificaIdade() {
		 if (idade >= 16){
			 return true;
		 }
		 else {
			 return false;
		 }
	 }
	 
	 /**
	  * Recupera o nome do eleitor.
	  * 
	  * @return Nome do eleitor.
	  */
	 
	 public String getNome() {
		 return nome;
	 }
	 
	 /**
	  * Recupera o cpf.
	  * 
	  * @return O cpf do eleitor.
	  */
	 
	 public String getCPF() {
		 return cpf;
	 }
	 
	 /**
	  * Recupera o titulo.
	  * 
	  * @return O titulo do eleitor.
	  */
	 
	 public int gettitulo() {
		 return titulo;
	 }
}
