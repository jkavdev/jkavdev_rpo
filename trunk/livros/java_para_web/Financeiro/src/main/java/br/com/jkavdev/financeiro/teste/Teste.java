package br.com.jkavdev.financeiro.teste;

import org.hibernate.Session;

import br.com.jkavdev.financeiro.util.HibernateUtil;

public class Teste {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.close();
	}

}
