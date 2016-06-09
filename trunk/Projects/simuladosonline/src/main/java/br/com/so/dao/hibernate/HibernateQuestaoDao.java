package br.com.so.dao.hibernate;

import java.io.Serializable;

import br.com.so.dao.interfacesDao.IQuestaoDao;
import br.com.so.modelo.Questao;

public class HibernateQuestaoDao extends HibernateGenericDao<Questao, Long> implements IQuestaoDao, Serializable{

	private static final long serialVersionUID = 1L;

}
