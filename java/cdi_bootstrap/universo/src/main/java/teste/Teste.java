package teste;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modelo.Aluno;
import modelo.Sala;

public class Teste {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("universo");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();

		Sala sala = new Sala();
		Aluno aluno = new Aluno();

		aluno.setDescricao("Jhonatan");
		sala.setDescricao("Sala 2");
		
		aluno.setSala(sala);
		
		ArrayList<Aluno> alunos = new ArrayList<>();
		alunos.add(aluno);
		sala.setAlunos(alunos);
		
		//persistiremos sala, pois com a 
		//anotacao cascade all, a jpa
		//verificara se ha alguma pendencia
		//caso haja ela agira
		//no caso o aluno tem que ser salvo
		//antes da sala
		// a jpa ira fazer isso antes de salvar
		//a sala
		manager.persist(sala);
		
		transaction.commit();

	}

}
