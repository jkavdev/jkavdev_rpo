package br.com.jkavdev.hibernate.conexao;

import org.hibernate.Session;

public class ConectaHibernateMysql {

	public static void main(String[] args) {
		Session session = null;

		session = HibernateUtil.getSessionFactory().openSession();

		System.out.println("Conectado");

		session.close();

	}

}
