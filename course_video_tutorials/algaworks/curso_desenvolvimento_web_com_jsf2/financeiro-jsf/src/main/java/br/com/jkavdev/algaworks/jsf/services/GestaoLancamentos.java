package br.com.jkavdev.algaworks.jsf.services;

import br.com.jkavdev.algaworks.jsf.model.Lancamento;
import br.com.jkavdev.algaworks.jsf.repositories.Lancamentos;

public class GestaoLancamentos {

	private Lancamentos lancamentos;

	public GestaoLancamentos(Lancamentos lancamentos) {
		this.lancamentos = lancamentos;
	}

	public void guardar(Lancamento lancamento) throws RegraNegocioException {

		if (existeLancamentoSemelhante(lancamento)) {
			throw new RegraNegocioException("existing_entry");
		}

		this.lancamentos.guardar(lancamento);
	}

	private boolean existeLancamentoSemelhante(Lancamento lancamento) {
		Lancamento lancamentoSemelhante = this.lancamentos.comDadosIguais(lancamento);

		return (lancamentoSemelhante != null && !lancamentoSemelhante.equals(lancamento));
	}

	public void excluir(Lancamento lancamento) throws RegraNegocioException {
		if (lancamento.isPago()) {
			throw new RegraNegocioException("lançamento não pode ser excluído!");
		}

		this.lancamentos.remover(lancamento);
	}

}
