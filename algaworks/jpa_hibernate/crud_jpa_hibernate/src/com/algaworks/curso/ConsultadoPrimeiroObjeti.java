package com.algaworks.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class ConsultadoPrimeiroObjeti {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu_cliente");
		EntityManager manager = factory.createEntityManager();

		Long codigo = 6L;
		Cliente clienteRetornado = manager.find(Cliente.class, codigo);
		
		if(clienteRetornado != null){
			System.out.println("Nome: " + clienteRetornado.getNome());
			System.out.println("Idade: " + clienteRetornado.getIdade());
			System.out.println("Profissão: " + clienteRetornado.getProfissao());
			System.out.println("Sexo: " + clienteRetornado.getSexo());
		}else{
			System.out.println("Cliente não encontrado!");
		}
		
		
	}

}
