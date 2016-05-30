package br.com.so.dao.hibernate;

import java.io.Serializable;

import br.com.so.dao.interfacesDao.IBancaDao;
import br.com.so.modelo.Banca;

public class HibernateBancaDao extends HibernateGenericDao<Banca, Long> implements IBancaDao, Serializable {

	private static final long serialVersionUID = 1L;

}
