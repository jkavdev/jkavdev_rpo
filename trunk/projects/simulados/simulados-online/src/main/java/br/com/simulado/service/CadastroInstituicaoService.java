package br.com.simulado.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.simulado.dao.InstituicaoDao;
import br.com.simulado.modelo.Instituicao;

public class CadastroInstituicaoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private InstituicaoDao instituicaoDao;
	
	public void salvar(Instituicao instituicao) throws NegocioException{
		if(instituicao.getNome() == null || instituicao.getNome().trim().equals("")){
			throw new NegocioException("O nome da Instituição é obrigátorio!");
		}
		
		this.instituicaoDao.salvar(instituicao);
	}

}
