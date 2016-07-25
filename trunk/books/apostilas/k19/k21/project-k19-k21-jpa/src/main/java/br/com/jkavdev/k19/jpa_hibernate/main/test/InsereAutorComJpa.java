package br.com.jkavdev.k19.jpa_hibernate.main.test;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jkavdev.k19.jpa_hibernate.model.Autor;

public class InsereAutorComJpa {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21PU");
		EntityManager manager = factory.createEntityManager();
		
		Autor autor = new Autor();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o nome da Editora: ");
		autor.setNome(entrada.nextLine());
		
		manager.getTransaction().begin();
		
		manager.persist(autor);
		
		manager.getTransaction().commit();
		
		entrada.close();
		manager.close();
		factory.close();
		
	}

}
