package br.com.jkavdev.facesmotors.test;

import java.util.List;

import org.junit.Test;

import br.com.jkavdev.facesmotors.dao.jpa.JpaAutomovelDao;
import br.com.jkavdev.facesmotors.model.Automovel;

public class JpaTest {

	@Test
	public void insertJpa() {
		Automovel automovel = new Automovel();
		automovel.setAnoFabricacao(2009);
		automovel.setAnoModelo(2008);
		automovel.setMarca("Fiat");
		automovel.setModelo("Palio");
		automovel.setObservacoes("Modelo novo");

		JpaAutomovelDao automovelDao = new JpaAutomovelDao();
		automovelDao.salva(automovel);

		System.out.println(automovel);
	}

	@Test
	public void selectJpa() {
		JpaAutomovelDao automovelDao = new JpaAutomovelDao();

		List<Automovel> automoveis = automovelDao.lista();

		for (Automovel automovel : automoveis) {
			System.out.println(automovel);
		}
	}

}
