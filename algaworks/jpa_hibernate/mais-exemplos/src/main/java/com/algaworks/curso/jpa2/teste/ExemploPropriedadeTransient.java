package com.algaworks.curso.jpa2.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.modelo.Proprietario;
import com.algaworks.curso.jpa2.modelo.Veiculo;
import com.algaworks.curso.jpa2.modelo.VeiculoId;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ExemploPropriedadeTransient {

	public static void main(String[] args) {

		EntityManagerFactory factory = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager manager = factory.createEntityManager();
		
		VeiculoId codigo = new VeiculoId("AOS-5512", "Planaltina");
		
		Veiculo veiculo = manager.find(Veiculo.class, codigo);
		
		//usando uma propriedade transient
		System.out.println(veiculo.getDescricao());

		manager.getTransaction().begin();
		manager.getTransaction().commit();

		manager.close();
		factory.close();

	}

}
