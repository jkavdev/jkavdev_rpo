package br.com.jkavdev.hibernate.database.utils;

import java.io.Serializable;
import java.util.List;

//interface que fornecera metodos basicos para os daos
//classe que recebe genericos
//recebe uma classe, entidade do banco
//e uma chave

public interface IGenericDao<T, ID extends Serializable> {

	// encontrar um elementro pelo id
	T findById(ID id);

	// lista todos os registros
	List<T> findAll();

	// salva um registro
	ID save(T entity);

	// atualiza registro
	void update(T entity);

	// deleta registro
	void delete(T entity);

}
