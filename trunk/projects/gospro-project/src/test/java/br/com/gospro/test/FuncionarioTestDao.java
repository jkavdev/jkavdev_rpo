package br.com.gospro.test;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.gospro.model.Funcionario;
import br.com.gospro.util.jpa.JpaUtil;

public class FuncionarioTestDao {

	private static EntityManager manager;
	private EntityTransaction transaction;

	@Before
	public void setUp() {
		manager = JpaUtil.geEntityManager();
		transaction = manager.getTransaction();
	}

	@After
	public void tearDown() {
		JpaUtil.close();
	}

	@Test
	public void insertFuncionario() {
		Funcionario jhonatan = createFuncionario(Calendar.getInstance(), "Jhonatan", "Kolen", Calendar.getInstance(),
				"M", "04488289100", "3168437", "Administrador");
		Funcionario maria = createFuncionario(Calendar.getInstance(), "Maria", "Helena", Calendar.getInstance(), "F",
				"04488289100", "3168437", "Requisitos");
		Funcionario lucas = createFuncionario(Calendar.getInstance(), "Lucas", "Alves", Calendar.getInstance(), "M",
				"04488289100", "3168437", "Implementador");
		Funcionario douglas = createFuncionario(Calendar.getInstance(), "Douglas", "Viana", Calendar.getInstance(), "M",
				"04488289100", "3168437", "Documentador");

		transaction.begin();
		manager.persist(jhonatan);
		manager.persist(maria);
		manager.persist(douglas);
		manager.persist(lucas);
		transaction.commit();

		System.out.println("Funcionarios salvos!");
	}

	@Test
	public void listaFuncionarios() {
		List<Funcionario> funcionarios = manager.createQuery("from Funcionario", Funcionario.class).getResultList();

		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.getNome());
		}
	}

	@Test
	public void listaFuncionariosPorNome() {
		List<Funcionario> funcionarios = manager
				.createQuery("select f from Funcionario f where f.nome = :nome", Funcionario.class)
				.setParameter("nome", "Jhonatan").getResultList();

		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.getNome());
		}
	}

	private Funcionario createFuncionario(Calendar dataCadastro, String nome, String sobrenome, Calendar DataNascimento,
			String sexo, String cpf, String rg, String cargo) {
		Funcionario funcionario = new Funcionario(dataCadastro, nome, sobrenome, DataNascimento, sexo, cpf, rg, cargo);
		return funcionario;
	}

}
