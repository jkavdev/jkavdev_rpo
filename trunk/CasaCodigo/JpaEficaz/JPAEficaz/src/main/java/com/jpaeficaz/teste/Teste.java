package com.jpaeficaz.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaMysqlPU");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("Conectou");
		
	}

}
