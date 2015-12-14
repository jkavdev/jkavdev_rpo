package teste;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Aluno;
import model.Sala;

public class Teste {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("universo_pu");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		Sala sala = new Sala();
		Aluno aluno = new Aluno();
		
		aluno.setDescricao("jhonatan");
		sala.setDescricao("Sala 01");
		aluno.setSala(sala);
		ArrayList<Aluno> alunos = new ArrayList<>();
		alunos.add(aluno);
		sala.setAlunos(alunos);
		
		manager.persist(sala);
		
		transaction.commit();
	}

}
