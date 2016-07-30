package br.com.jkavdev.algaworks.jsf.repositories;

import java.util.List;

import br.com.jkavdev.algaworks.jsf.model.Lancamento;

public interface Lancamentos {

	public List<Lancamento> todos();

	public Lancamento guardar(Lancamento lancamento);

	public void remover(Lancamento lancamento);

	public Lancamento comDadosIguais(Lancamento lancamento);

}
