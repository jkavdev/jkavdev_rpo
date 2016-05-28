package br.com.simulados.dao.hibernate;

import java.io.Serializable;

import br.com.simulados.dao.IAreaDao;
import br.com.simulados.modelo.Area;

public class HibernateAreaDao extends HibernateGenericDao<Area, Long> implements IAreaDao, Serializable {

	private static final long serialVersionUID = 1L;

}
