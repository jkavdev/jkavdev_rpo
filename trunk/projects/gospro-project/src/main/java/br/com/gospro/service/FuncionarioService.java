package br.com.gospro.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.gospro.dao.IFuncionarioDao;
import br.com.gospro.model.Funcionario;
import br.com.gospro.util.jpa.Transactional;

public class FuncionarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IFuncionarioDao funcionarioDao;

	@Transactional
	public void salvar(Funcionario funcionario) throws NegocioException {
		if (funcionario == null || funcionario.getNome().trim().equals("")) {
			throw new NegocioException("O Nome do Funcionário é obrigatório");
		}

		this.funcionarioDao.salvar(funcionario);
	}

	@Transactional
	public void excluir(Funcionario funcionarioSelecionado) throws NegocioException {
		funcionarioSelecionado = this.funcionarioDao.buscarPorId(funcionarioSelecionado.getCodigo());
		if (funcionarioSelecionado == null) {
			throw new NegocioException("Erro ao excluir Funcionario");
		}

		this.funcionarioDao.remover(funcionarioSelecionado);
	}

	public List<Funcionario> buscarTodos() {
		return this.funcionarioDao.buscarTodos();
	}

}
