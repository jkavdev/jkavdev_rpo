package br.com.so.dao.hibernate;

import java.io.Serializable;

import br.com.so.dao.interfacesDao.IAreaDao;
import br.com.so.modelo.Area;

public class HibernateAreaDao extends HibernateGenericDao<Area, Long> implements IAreaDao, Serializable {

	private static final long serialVersionUID = 1L;

}
