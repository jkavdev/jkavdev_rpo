package br.com.so.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import br.com.so.dao.interfacesDao.ICargoDao;
import br.com.so.dao.interfacesDao.IDisciplinaDao;
import br.com.so.modelo.Cargo;
import br.com.so.modelo.Disciplina;
import br.com.so.modelo.Instituicao;
import br.com.so.util.jsf.FacesUtil;

public class HibernateDisciplinaDao extends HibernateGenericDao<Disciplina, Long>
		implements IDisciplinaDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean existe(Disciplina disciplina) {
		String sql = "select d from Disciplina d where d.nome = :nome ";

		@SuppressWarnings("unchecked")
		List<Disciplina> lista = this.getManager().createQuery(sql)
				.setParameter("nome", disciplina.getNome().toUpperCase()).getResultList();

		if (lista.isEmpty()) {
			return false;
		}
		FacesUtil.addWarnMessage("Disciplina ja cadastrada!");
		return true;
	}

}
