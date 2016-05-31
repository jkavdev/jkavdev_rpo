package br.com.so.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import br.com.so.dao.interfacesDao.IAreaDao;
import br.com.so.modelo.Area;
import br.com.so.modelo.Instituicao;
import br.com.so.util.jsf.FacesUtil;

public class HibernateAreaDao extends HibernateGenericDao<Area, Long> implements IAreaDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean existe(Area area) {
		String sql = "select i from Area i where i.nome = :nome ";

		@SuppressWarnings("unchecked")
		List<Instituicao> lista = this.getManager().createQuery(sql).setParameter("nome", area.getNome().toUpperCase())
				.getResultList();

		if (lista.isEmpty()) {
			return false;
		}
		FacesUtil.addWarnMessage("Area ja cadastrada!");
		return true;
	}

}
