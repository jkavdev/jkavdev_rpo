package br.com.so.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import br.com.so.dao.interfacesDao.IQuestaoDao;
import br.com.so.modelo.Disciplina;
import br.com.so.modelo.Prova;
import br.com.so.modelo.Questao;
import br.com.so.util.jsf.FacesUtil;

public class HibernateQuestaoDao extends HibernateGenericDao<Questao, Long> implements IQuestaoDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Questao> getQuestoesByProva(Prova prova) {
		String sql = "select q from Questao q where q.prova = :codigo";
		try {
			@SuppressWarnings("unchecked")
			List<Questao> lista = this.getManager().createQuery(sql).setParameter("codigo", prova).getResultList();
			if (!lista.isEmpty()) {
				return lista;
			}
		} catch (Exception e) {
			FacesUtil.addWarnMessage("Nenhuma Questão cadastrada para essa busca!");
		}
		return null;
	}
}
