package br.com.so.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import br.com.so.dao.interfacesDao.ICargoDao;
import br.com.so.modelo.Cargo;
import br.com.so.modelo.Instituicao;
import br.com.so.util.jsf.FacesUtil;

public class HibernateCargoDao extends HibernateGenericDao<Cargo, Long> implements ICargoDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean existe(Cargo cargo) {
		String sql = "select i from Cargo i where i.nomeCargo = :nome ";

		@SuppressWarnings("unchecked")
		List<Instituicao> lista = this.getManager().createQuery(sql).setParameter("nome", cargo.getNomeCargo().toUpperCase())
				.getResultList();

		if (lista.isEmpty()) {
			return false;
		}
		FacesUtil.addWarnMessage("Cargo ja cadastrado!");
		return true;
	}

}
