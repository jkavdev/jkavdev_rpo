package br.com.jkavdev.k19.jpa_hibernate.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.k19.jpa_hibernate.model.Funcionario;

public class CollectionTest {

	private EntityManagerFactory factory;
	private EntityManager manager;

	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("k21PU");
		manager = factory.createEntityManager();
	}

	@After
	public void clean() {
		manager.close();
		factory.close();
	}
	
	@Test
	public void insertFuncionario(){
		
		Funcionario jhonatan = criaFuncionario("Jhonatan Kolen");
	
		List<String> telefones = new ArrayList<>();
		
		telefones.add("91940455");
		telefones.add("36374568");
		
		jhonatan.setTelefone(telefones);
		
		beginTransaction();
		
		manager.persist(jhonatan);
		
		commit();
		
	}
	
	public void commit() {
		manager.getTransaction().commit();
	}

	public void beginTransaction() {
		manager.getTransaction().begin();
	}
	
	public Funcionario criaFuncionario(String nome){
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		
		return funcionario;
	}

}
