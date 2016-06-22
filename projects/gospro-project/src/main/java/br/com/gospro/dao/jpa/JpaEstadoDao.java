package br.com.gospro.dao.jpa;

import java.io.Serializable;

import br.com.gospro.dao.IEstadoDao;
import br.com.gospro.model.Estado; class JpaEstadoDao extends JpaGenericDao<Estado, Long> implements IEstadoDao, Serializable {

	private static final long serialVersionUID = 1L;

}
