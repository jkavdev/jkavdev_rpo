package com.algaworks.curso.jpa2.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.modelo.Proprietario;
import com.algaworks.curso.jpa2.modelo.ProprietarioD;
import com.algaworks.curso.jpa2.modelo.Telefone;
import com.algaworks.curso.jpa2.modelo.Veiculo;
import com.algaworks.curso.jpa2.modelo.VeiculoId;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaObjetoEmbutido2 {

	public static void main(String[] args) {

		EntityManagerFactory factory = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager manager = factory.createEntityManager();

		ProprietarioD proprietarioD = manager.find(ProprietarioD.class, 1L);
		
		System.out.println("Nome: " + proprietarioD.getNome());
		
		for (Telefone telefone : proprietarioD.getTelefones()) {
			System.out.println("Telefone: (" + telefone.getPrefixo() + ") "
					+ telefone.getNumero()
					+ (telefone.getRamal() != null ? " X" + telefone.getRamal() : ""));
		}

		manager.close();
		factory.close();

	}

}
