package br.com.simulados.dao.hibernate;

import java.io.Serializable;

import br.com.simulados.dao.ICargoDao;
import br.com.simulados.modelo.Cargo;

public class HibernateCargoDao extends HibernateGenericDao<Cargo, Long> implements ICargoDao, Serializable {

	private static final long serialVersionUID = 1L;

}
