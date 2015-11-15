package com.algaworks.curso.main;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Conta;

public class Transferencia {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tabajara_pu");
		EntityManager manager = factory.createEntityManager();

		Scanner entrada = new Scanner(System.in);

		Conta conta1 = manager.find(Conta.class, 1L);
		setSaldoConta1(entrada, conta1);

		Conta conta2 = manager.find(Conta.class, 2L);
		setSaldoConta2(entrada, conta2);

		manager.getTransaction().begin();
		manager.persist(conta1);
		manager.persist(conta2);
		manager.getTransaction().commit();

		System.out.println("Saldo Conta 1 = " + conta1.getSaldo());
		System.out.println("Saldo Conta 2 = " + conta2.getSaldo());

		System.out.println("------------------------------------");
		System.out.println("Digite Valor para retirar da Conta 1 e Depositar na Conta 2");
		double valorTransferencia = entrada.nextDouble();

		manager.getTransaction().begin();
		apresentaSaldo(conta1, conta2, valorTransferencia);

		if (conta1.getSaldo() > 0) {
			manager.getTransaction().commit();
			System.out.println("Transferencia Realizada com Sucesso!");
		} else {
			manager.getTransaction().rollback();
			System.err.println("Transferencia não Realizada, Saldo Insuficiente!");
		}

	}

	private static void apresentaSaldo(Conta conta1, Conta conta2, double valorTransferencia) {
		conta1.setSaldo(conta1.getSaldo() - valorTransferencia);
		conta2.setSaldo(conta2.getSaldo() + valorTransferencia);
	}

	private static void setSaldoConta2(Scanner entrada, Conta conta2) {
		if (conta2 == null) {
			System.out.println("Digite Saldo da Conta 2 : ");
			double saldoConta2 = entrada.nextDouble();
			conta2 = new Conta();
			conta2.setSaldo(saldoConta2);
		}
	}

	private static void setSaldoConta1(Scanner entrada, Conta conta1) {
		if (conta1 == null) {
			System.out.println("Digite Saldo da Conta 1 : ");
			double saldoConta1 = entrada.nextDouble();
			conta1 = new Conta();
			conta1.setSaldo(saldoConta1);
		}
	}

}
