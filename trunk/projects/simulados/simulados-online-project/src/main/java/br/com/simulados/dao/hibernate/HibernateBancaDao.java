package br.com.simulados.dao.hibernate;

import java.io.Serializable;

import br.com.simulados.dao.IBancaDao;
import br.com.simulados.modelo.Banca;

public class HibernateBancaDao extends HibernateGenericDao<Banca, Long> implements IBancaDao, Serializable {

	private static final long serialVersionUID = 1L;

}
