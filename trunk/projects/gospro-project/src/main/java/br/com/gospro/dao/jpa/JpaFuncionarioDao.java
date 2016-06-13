package br.com.gospro.dao.jpa;

import java.io.Serializable;

import br.com.gospro.dao.IFuncionarioDao;
import br.com.gospro.model.Funcionario;

public class JpaFuncionarioDao extends JpaGenericDao<Funcionario, Long> implements IFuncionarioDao, Serializable {

	private static final long serialVersionUID = 1L;

}
