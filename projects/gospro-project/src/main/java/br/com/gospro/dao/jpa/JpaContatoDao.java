package br.com.gospro.dao.jpa;

import java.io.Serializable;

import br.com.gospro.dao.IContatoDao;
import br.com.gospro.model.Contato;

public class JpaContatoDao extends JpaGenericDao<Contato, Long> implements IContatoDao, Serializable {

	private static final long serialVersionUID = 1L;


}
