//package com.algaworks.curso.jpa2.teste;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class Teste {
//	
//	public static void main(String[] args) throws SQLException {
//		
//
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
//		EntityManager manager = factory.createEntityManager();
//		
//		ResultSet rs = (ResultSet) manager.createQuery("from Fabricante").getResultList();
//		
//		while(rs.next()){
//			System.out.println("Fabricante"  + );
//		}
//		
//	}
//
//}
