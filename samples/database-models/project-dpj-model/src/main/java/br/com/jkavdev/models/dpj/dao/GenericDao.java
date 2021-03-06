package br.com.jkavdev.models.dpj.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable>{

	public void salvar(T entidade);
	public void alterar(T entidade);
	public void remover(T entidade);
	public T buscarPorId(ID id);
	public List<T> buscarTodos();

}
