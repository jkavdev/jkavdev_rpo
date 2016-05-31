package br.com.jkavdev.facesmotors.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.jkavdev.facesmotors.dao.AutomovelDao;
import br.com.jkavdev.facesmotors.dao.jdbc.ConnectionFactory;
import br.com.jkavdev.facesmotors.model.Automovel;

public class JpaAutomovelDao implements AutomovelDao {

	EntityManager manager = ConnectionFactory.getEntityManager();

	@Override
	public void salva(Automovel automovel) {
		this.manager.getTransaction().begin();
		this.manager.persist(automovel);
		this.manager.getTransaction().commit();
		this.manager.close();
	}

	@Override
	public List<Automovel> lista() {
		List<Automovel> automoveis = this.manager.createQuery("from Automovel", Automovel.class).getResultList();
		
		this.manager.close();

		return automoveis;
	}

}
