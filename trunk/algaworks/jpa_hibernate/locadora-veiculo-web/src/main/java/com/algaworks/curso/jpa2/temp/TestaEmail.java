package com.algaworks.curso.jpa2.temp;

public class TestaEmail {
	
	public static void main(String[] args) {
		
		EnviaJava email = new EnviaJava();
		email.enviarEmail("jhonatankolen@gmail.com", "Teste Email", "Teste de Envio de Email", "jhonatankolen@gmail.com");
		
	}

}
