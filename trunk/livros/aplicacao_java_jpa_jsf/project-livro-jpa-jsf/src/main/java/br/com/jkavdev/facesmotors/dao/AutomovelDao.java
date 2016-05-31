package br.com.jkavdev.facesmotors.dao;

import java.util.List;

import br.com.jkavdev.facesmotors.model.Automovel;

public interface AutomovelDao {
	
	void salva(Automovel automovel);
	List<Automovel> lista();

}
