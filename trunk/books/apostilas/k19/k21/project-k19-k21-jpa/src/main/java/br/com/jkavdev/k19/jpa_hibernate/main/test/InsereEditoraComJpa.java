package br.com.jkavdev.k19.jpa_hibernate.main.test;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jkavdev.k19.jpa_hibernate.model.Editora;

public class InsereEditoraComJpa {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21PU");
		EntityManager manager = factory.createEntityManager();
		
		Editora editora = new Editora();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o nome da Editora: ");
		editora.setNome(entrada.nextLine());
		
		System.out.println("Digite o email da Editora: ");
		editora.setEmail(entrada.nextLine());
		
		manager.getTransaction().begin();
		
		manager.persist(editora);
		
		manager.getTransaction().commit();
		
		entrada.close();
		manager.close();
		factory.close();
		
	}

}
