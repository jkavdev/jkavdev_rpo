package br.com.jkavdev.facesmotors.test;

import java.util.List;

import org.junit.Test;

import br.com.jkavdev.facesmotors.dao.hibernate.HibernateAutomovelDao;
import br.com.jkavdev.facesmotors.model.Automovel;

public class HibernateTest {

	@Test
	public void hibernateInsert() {
		Automovel automovel = new Automovel();
		automovel.setAnoFabricacao(2009);
		automovel.setAnoModelo(2008);
		automovel.setMarca("Fiat");
		automovel.setModelo("Palio");
		automovel.setObservacoes("Modelo novo");

		HibernateAutomovelDao automovelDao = new HibernateAutomovelDao();

		automovelDao.salva(automovel);

		System.out.println(automovel);
	}

	public void hibernateSelect() {
		HibernateAutomovelDao automovelDao = new HibernateAutomovelDao();

		List<Automovel> automoveis = automovelDao.lista();

		for (Automovel automovel : automoveis) {
			System.out.println(automovel);
		}
	}

}
