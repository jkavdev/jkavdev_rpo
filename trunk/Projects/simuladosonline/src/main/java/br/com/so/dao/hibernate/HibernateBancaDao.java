package br.com.so.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import br.com.so.dao.interfacesDao.IBancaDao;
import br.com.so.modelo.Banca;
import br.com.so.modelo.Instituicao;
import br.com.so.util.jsf.FacesUtil;

public class HibernateBancaDao extends HibernateGenericDao<Banca, Long> implements IBancaDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Override
	public boolean existe(Banca banca) {
		String sql = "select i from Banca i where i.nome = :nome ";

		@SuppressWarnings("unchecked")
		List<Instituicao> lista = this.getManager().createQuery(sql)
				.setParameter("nome", banca.getNome().toUpperCase()).getResultList();

		if (lista.isEmpty()) {
			return false;
		}
		FacesUtil.addWarnMessage("Banca ja cadastrada!");
		return true;
	}

}
