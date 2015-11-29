package com.algaworks.curso.main;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Conta;

public class Transferencia {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("pu_tabajara");
		EntityManager manager = factory.createEntityManager();

		Scanner entrada = new Scanner(System.in);

		// seta valores das contas 1 e 2
		Conta conta1 = manager.find(Conta.class, 1L);

		if (conta1 == null) {
			System.out.println("Digite Saldo conta 1 : ");
			double saldoInicialConta1 = entrada.nextDouble();
			conta1 = new Conta();
			conta1.setSaldo(saldoInicialConta1);
		}

		Conta conta2 = manager.find(Conta.class, 2L);

		if (conta2 == null) {
			System.out.println("Digite Saldo conta 2 : ");
			double saldoInicialConta2 = entrada.nextDouble();
			conta2 = new Conta();
			conta2.setSaldo(saldoInicialConta2);
		}

		// persiste a alteracao das contas no banco

		manager.getTransaction().begin();
		manager.persist(conta1);
		manager.persist(conta2);
		manager.getTransaction().commit();

		// apresenta valores das contas

		System.out.println("Saldo Conta 1 : " + conta1.getSaldo());
		System.out.println("Saldo Conta 2 : " + conta2.getSaldo());

		manager.close();
		manager = factory.createEntityManager();

		// valor para transferencia entre as contas
		System.out.println("------------------------------------");
		System.out
				.println("Digite o valor a retirar na conta 1 e depositar na conta 2");
		Double valorTransferencia = entrada.nextDouble();

		// realizando transação entre as contas
		manager.getTransaction().begin();
		conta1.setSaldo(conta1.getSaldo() - valorTransferencia);
		conta2.setSaldo(conta2.getSaldo() + valorTransferencia);

		// realizando alteração nos objetos, uma vez que o entitymanager foi
		// fechado e aberto de novo
		manager.merge(conta1);
		manager.merge(conta2);

		if (conta1.getSaldo() > 0) {
			manager.getTransaction().commit();
			System.out.println("Transferencia realizada com Sucesso");
		} else {
			manager.getTransaction().rollback();
			System.out
					.println("Transferencia não realizada, saldo insuficiente!");
		}

		System.out.println("Saldo Conta 1 : " + conta1.getSaldo());
		System.out.println("Saldo Conta 2 : " + conta2.getSaldo());

	}

}
