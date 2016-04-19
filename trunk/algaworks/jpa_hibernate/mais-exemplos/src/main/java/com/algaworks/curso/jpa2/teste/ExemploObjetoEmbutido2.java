package com.algaworks.curso.jpa2.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.modelo.Proprietario;
import com.algaworks.curso.jpa2.modelo.ProprietarioD;
import com.algaworks.curso.jpa2.modelo.Telefone;
import com.algaworks.curso.jpa2.modelo.Veiculo;
import com.algaworks.curso.jpa2.modelo.VeiculoId;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ExemploObjetoEmbutido2 {

	public static void main(String[] args) {

		EntityManagerFactory factory = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager manager = factory.createEntityManager();


		manager.getTransaction().begin();
		
		ProprietarioD proprietarioD = new ProprietarioD();
		proprietarioD.setNome("Douglas");
		proprietarioD.getTelefones().add(new Telefone("61", "99346554", "055"));
		proprietarioD.getTelefones().add(new Telefone("61", "99220468", "055"));
		
		manager.persist(proprietarioD);
		
		manager.getTransaction().commit();

		manager.close();
		factory.close();

	}

}
