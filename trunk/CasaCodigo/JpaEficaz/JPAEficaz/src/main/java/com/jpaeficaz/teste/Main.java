package com.jpaeficaz.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	
	//sera instanciado apenas uma vez
	
	//mas nao fica bom termos a criação de factory no main da aplicacao
	//podemos criar uma padrao para diminuir o acoplamento
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaMysqlPU");
	
	public static void main(String[] args) {
		
		//criando entitymanagerfactory atraves do nome do persistence-unit a ser verificado
		//para a criação de uma factory o jpa fara toda a verificao do persistence
		//criara o banco se preciso
		//verificara as tabelas caso haja alguma mudanca
		//portanto o factory eh objeto de instanciacao muito custuso
		
		//fara a leitura das entidades mapeadas, validacao de conexao com o banco de dados
		//tabelas a serem criadas, validar schema e criar sequences e etc
		
		//podemos torna-lo statico nao necessitando cria-lo duas vez
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaMysqlPU");
		EntityManager manager = factory.createEntityManager();
		
		manager.close();
		factory.close();
		
	}

}
