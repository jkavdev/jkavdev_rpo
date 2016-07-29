package br.com.jkavdev.algaworks.jsf.repositories;

import java.util.List;

import br.com.jkavdev.algaworks.jsf.model.Pessoa;

public interface Pessoas {

	public List<Pessoa> todas();

	public Pessoa porCodigo(Integer codigo);

}
