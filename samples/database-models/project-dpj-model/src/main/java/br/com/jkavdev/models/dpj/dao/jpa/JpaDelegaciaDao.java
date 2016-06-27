package br.com.jkavdev.models.dpj.dao.jpa;

import java.io.Serializable;

import br.com.jkavdev.models.dpj.dao.IDelegaciaDao;
import br.com.jkavdev.models.dpj.model.Delegacia;

public class JpaDelegaciaDao extends JpaGenericDao<Delegacia, Long> implements IDelegaciaDao, Serializable {

	private static final long serialVersionUID = 1L;

}
