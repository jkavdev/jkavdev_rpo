package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class ConsultandoPrimeiroObjeto {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud_pu");
		EntityManager manager = factory.createEntityManager();

		Long idCliente = 6L;
		Cliente clienteEncontrado = manager.find(Cliente.class, idCliente);

		mostraCliente(clienteEncontrado);

	}

	private static void mostraCliente(Cliente clienteEncontrado) {
		//se o cliente nao existir, nao executa
		if (clienteEncontrado != null) {
			System.out.println("Nome : " + clienteEncontrado.getNome());
			System.out.println("Idade : " + clienteEncontrado.getIdade());
			System.out.println("Sexo : " + clienteEncontrado.getSexo());
			System.out.println("Profissão : " + clienteEncontrado.getProfissao());
		}else{
			System.out.println("Cliente não Encontrado!");
		}
	}

}
