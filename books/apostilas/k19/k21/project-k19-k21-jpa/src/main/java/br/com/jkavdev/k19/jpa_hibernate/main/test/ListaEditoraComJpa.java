package br.com.jkavdev.k19.jpa_hibernate.main.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jkavdev.k19.jpa_hibernate.model.Editora;

public class ListaEditoraComJpa {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21PU");
		EntityManager manager = factory.createEntityManager();

		List<Editora> editoras = manager.createQuery("from Editora", Editora.class).getResultList();

		if(editoras != null && !editoras.isEmpty()){
			for (Editora editora : editoras) {
				System.out.println(editora.getNome());
			}
		}else{
			System.out.println("Não foram encontradas editoras");
		}

		manager.close();
		factory.close();

	}
}