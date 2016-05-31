package br.com.so.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import br.com.so.dao.interfacesDao.IInstituicaoDao;
import br.com.so.modelo.Instituicao;
import br.com.so.util.jsf.FacesUtil;

public class HibernateInstituicaoDao extends HibernateGenericDao<Instituicao, Long>
		implements IInstituicaoDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean existe(Instituicao instituicao) {
		String sql = "select i from Instituicao i where i.nome = :nome ";

		@SuppressWarnings("unchecked")
		List<Instituicao> lista = this.getManager().createQuery(sql)
				.setParameter("nome", instituicao.getNome().toUpperCase()).getResultList();

		if (lista.isEmpty()) {
			return false;
		}
		FacesUtil.addWarnMessage("Instituição ja cadastrada!");
		return true;
	}

}
