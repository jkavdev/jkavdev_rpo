package br.com.jkavdev.algaworks.jpahibernate.main;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jkavdev.algaworks.jpahibernate.model.Conta;

public class Transferencia {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tabajaraPU");
		EntityManager manager = factory.createEntityManager();
		Scanner entrada = new Scanner(System.in);

		// criando contas
		Conta conta = manager.find(Conta.class, 1L);

		if (conta == null) {
			System.out.println("Digite o saldo inicial da conta 1: ");
			Double saldoInicial = entrada.nextDouble();
			conta = new Conta();
			conta.setSaldo(saldoInicial);
		}

		Conta conta2 = manager.find(Conta.class, 2L);

		if (conta2 == null) {
			System.out.println("Digite o saldo inicial da conta 2: ");
			Double saldoInicial = entrada.nextDouble();
			conta2 = new Conta();
			conta2.setSaldo(saldoInicial);
		}
		// ========

		// persistindo contas

		manager.getTransaction().begin();

		manager.persist(conta);
		manager.persist(conta2);

		manager.getTransaction().commit();

		// =========

		// mostrando saldos

		System.out.println("Saldo da conta1: " + conta.getSaldo());
		System.out.println("Saldo da conta2: " + conta2.getSaldo());

		// =========
		
		//fechando manager e abrindo
		
		manager.close();
		
		manager = factory.createEntityManager();
		
		//==

		// alterando valores das contas
		System.out.println("Digite o valor a retirar da conta1 a depositar na conta2: ");
		Double valorTransferencia = entrada.nextDouble();

		manager.getTransaction().begin();

		// aplicando transferência
		conta.setSaldo(conta.getSaldo() - valorTransferencia);
		conta2.setSaldo(conta2.getSaldo() + valorTransferencia);
		
		//atribuindo novamento as entidades ao manager
		manager.merge(conta);
		manager.merge(conta2);

		// verificando transferência
		if (conta.getSaldo() > 0) {
			manager.getTransaction().commit();
			System.out.println("Transferência realizada com sucesso");

		} else {
			manager.getTransaction().rollback();
			System.out.println("Transferência não realizada, saldo insuficiente");
		}

	}

}
