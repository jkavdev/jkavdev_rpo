package br.com.gospro.dao.jpa;

import java.io.Serializable;

import br.com.gospro.dao.IClienteDao;
import br.com.gospro.model.Cliente;

public class JpaClienteDao extends JpaGenericDao<Cliente, Long> implements IClienteDao, Serializable {

	private static final long serialVersionUID = 1L;


}
