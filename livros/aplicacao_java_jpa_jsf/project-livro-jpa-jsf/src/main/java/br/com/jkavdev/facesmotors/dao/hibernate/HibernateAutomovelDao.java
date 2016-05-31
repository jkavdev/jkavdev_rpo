package br.com.jkavdev.facesmotors.dao.hibernate;

import java.util.List;

import br.com.jkavdev.facesmotors.dao.AutomovelDao;
import br.com.jkavdev.facesmotors.model.Automovel;

public class HibernateAutomovelDao implements AutomovelDao {

	@Override
	public void salva(Automovel automovel) {
//		Session session = ConnectionFactory.getSessionFactory().openSession();
//		session.beginTransaction();
//		session.save(automovel);
//		session.getTransaction().commit();
//		session.close();
	}

	@Override
	public List<Automovel> lista() {
//		Session session = ConnectionFactory.getSessionFactory().openSession();
//		List<Automovel> automoveis = session.createQuery("from Automovel").list();
//		return automoveis;
		return null;
	}

}
