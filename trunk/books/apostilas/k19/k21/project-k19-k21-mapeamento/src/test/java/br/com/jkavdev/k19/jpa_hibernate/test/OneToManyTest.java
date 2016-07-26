package br.com.jkavdev.k19.jpa_hibernate.test;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.Test;

import br.com.jkavdev.k19.jpa_hibernate.model.Departamento;
import br.com.jkavdev.k19.jpa_hibernate.model.Funcionario;

public class OneToManyTest extends AbstractJUnitConfig {

	@Test
	public void insertFuncionario() {

		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Jhonatan");

		Funcionario funcionario2 = new Funcionario();
		funcionario2.setNome("Ian");

		Departamento departamento = new Departamento();
		departamento.setNome("Financeiro");

		Collection<Funcionario> funcionarios = new LinkedList<>();
		funcionarios.add(funcionario);
		funcionarios.add(funcionario2);

		departamento.setFuncionarios(funcionarios);
		
		beginTransaction();
		
		this.getManager().persist(funcionario);
		this.getManager().persist(funcionario2);
		this.getManager().persist(departamento);
		
		commit();

	}

}
