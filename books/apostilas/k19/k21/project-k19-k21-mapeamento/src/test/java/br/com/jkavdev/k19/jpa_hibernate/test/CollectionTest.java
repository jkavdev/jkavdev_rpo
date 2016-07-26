package br.com.jkavdev.k19.jpa_hibernate.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.jkavdev.k19.jpa_hibernate.model.Funcionario;

public class CollectionTest extends AbstractJUnitConfig {

	@Test
	public void insertFuncionario(){
		
		Funcionario jhonatan = criaFuncionario("Jhonatan Kolen");
	
		List<String> telefones = new ArrayList<>();
		
		telefones.add("91940455");
		telefones.add("36374568");
		
		jhonatan.setTelefone(telefones);
		
		beginTransaction();
		
		this.getManager().persist(jhonatan);
		
		commit();
		
	}
	
	public Funcionario criaFuncionario(String nome){
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		
		return funcionario;
	}

}
