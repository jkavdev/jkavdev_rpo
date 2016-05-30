package br.com.so.dao.hibernate;

import java.io.Serializable;

import br.com.so.dao.interfacesDao.ICargoDao;
import br.com.so.modelo.Cargo;

public class HibernateCargoDao extends HibernateGenericDao<Cargo, Long> implements ICargoDao, Serializable {

	private static final long serialVersionUID = 1L;

}
