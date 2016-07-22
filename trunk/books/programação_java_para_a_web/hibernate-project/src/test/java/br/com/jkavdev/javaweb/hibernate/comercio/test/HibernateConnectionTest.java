package br.com.jkavdev.javaweb.hibernate.comercio.test;

import org.hibernate.Session;
import org.junit.Test;

import br.com.jkavdev.javaweb.hibernate.comercio.util.HibernateUtility;

public class HibernateConnectionTest {
	
	@Test
	public void connectionTest(){
		
		Session session = HibernateUtility.getSessionFactory().openSession();
		
		
		System.out.println("Conectado");
		
	}

}
