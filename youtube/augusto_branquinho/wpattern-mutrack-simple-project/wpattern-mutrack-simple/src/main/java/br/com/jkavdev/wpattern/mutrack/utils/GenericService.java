package br.com.jkavdev.wpattern.mutrack.utils;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Servicos Genericos para qualquer entidade

public abstract class GenericService<T extends BaseEntity<ID>, ID extends Serializable> 
	implements ServiceMap {

	private final Logger logger = Logger.getLogger(getClass());

	// fara a injecao do repositorio da entidade implementadora deste servico generico
	@Autowired
	protected JpaRepository<T, ID> genericRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<T> findAll() {

		this.logger.info("Requesting all records.");

		return this.genericRepository.findAll();
	}

}
