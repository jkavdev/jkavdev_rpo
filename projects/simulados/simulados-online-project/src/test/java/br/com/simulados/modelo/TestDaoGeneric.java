package br.com.simulados.modelo;

import org.junit.Test;

import br.com.simulados.dao.IProvaDao;
import br.com.simulados.dao.hibernate.HibernateProvaDao;

public class TestDaoGeneric {

	IProvaDao provaDao = new HibernateProvaDao();

	@Test
	public void testInsertProva(){
		
		Prova prova = new Prova();
		prova.setNivel(Nivel.FUNDAMENTAL);
		
		provaDao.salvar(prova);
		
		System.out.println("Prova " + prova.getNivel().toString() + " Salva!");
		
	}

}
