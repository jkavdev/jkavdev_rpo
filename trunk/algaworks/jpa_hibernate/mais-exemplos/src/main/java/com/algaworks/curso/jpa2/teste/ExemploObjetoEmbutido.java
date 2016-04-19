package com.algaworks.curso.jpa2.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.modelo.Proprietario;
import com.algaworks.curso.jpa2.modelo.Veiculo;
import com.algaworks.curso.jpa2.modelo.VeiculoId;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ExemploObjetoEmbutido {

	public static void main(String[] args) {

		EntityManagerFactory factory = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager manager = factory.createEntityManager();

		Veiculo veiculo = new Veiculo();
		VeiculoId codigo = new VeiculoId("AOS-5512", "Planaltina");

		veiculo.setCodigo(codigo);
		veiculo.setFabricante("Chevrolet");
		veiculo.setModelo("Camaro");

		Proprietario proprietario = new Proprietario();
		proprietario.setNome("Jhonatan");
		proprietario.setEmail("jhonatan@gmail.com");
		proprietario.setTelefone("99346554");

		veiculo.setProprietario(proprietario);

		manager.getTransaction().begin();
		manager.merge(veiculo);
		manager.getTransaction().commit();

		manager.close();
		factory.close();

	}

}
