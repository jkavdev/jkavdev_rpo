package br.com.gospro.dao.jpa;

import java.io.Serializable;

import br.com.gospro.dao.IEnderecoDao;
import br.com.gospro.model.Endereco;

public class JpaEnderecoDao extends JpaGenericDao<Endereco, Long> implements IEnderecoDao, Serializable {

	private static final long serialVersionUID = 1L;


}
