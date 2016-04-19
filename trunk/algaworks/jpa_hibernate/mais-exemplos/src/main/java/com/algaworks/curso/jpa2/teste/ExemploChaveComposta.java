package com.algaworks.curso.jpa2.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.modelo.Veiculo;
import com.algaworks.curso.jpa2.modelo.VeiculoId;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ExemploChaveComposta {

	public static void main(String[] args) {

		EntityManagerFactory factory = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager manager = factory.createEntityManager();

		Veiculo veiculo = new Veiculo();
		VeiculoId codigo = new VeiculoId("ABS-5512", "Planaltina");
		
		veiculo.setCodigo(codigo);
		veiculo.setFabricante("Fiat");
		veiculo.setModelo("Palio");

		manager.getTransaction().begin();
		manager.merge(veiculo);
		manager.getTransaction().commit();
		
		codigo = new VeiculoId("ABS-5512", "Planaltina");
		Veiculo veiculoBuscado = manager.find(Veiculo.class, codigo);
		
		System.out.println(veiculoBuscado.getModelo() + " - " + veiculoBuscado.getFabricante());

		manager.close();
		factory.close();

	}

}
