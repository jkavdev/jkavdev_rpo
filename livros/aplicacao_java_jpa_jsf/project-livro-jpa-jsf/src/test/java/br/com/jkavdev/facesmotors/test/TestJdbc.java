package br.com.jkavdev.facesmotors.test;

import java.util.List;

import org.junit.Test;

import br.com.jkavdev.facesmotors.dao.AutomovelDao;
import br.com.jkavdev.facesmotors.dao.jdbc.JdbcAutomovelDao;
import br.com.jkavdev.facesmotors.model.Automovel;

public class TestJdbc {

	@Test
	public void testInsertJdbc() {
		Automovel automovel = new Automovel();
		automovel.setAnoFabricacao(2009);
		automovel.setAnoModelo(2008);
		automovel.setMarca("Fiat");
		automovel.setModelo("Palio");
		automovel.setObservacoes("Modelo novo");

		AutomovelDao automovelDao = new JdbcAutomovelDao();

		automovelDao.salva(automovel);

		System.out.println("Automovel: " + automovel.getModelo() + " salvo");
	}

	@Test
	public void testSelectJdbc(){
		AutomovelDao automovelDao = new JdbcAutomovelDao();
		
		List<Automovel> automoveis = automovelDao.lista();
		
		for (Automovel automovel : automoveis) {
			System.out.println(automovel);
		}
	}

}
