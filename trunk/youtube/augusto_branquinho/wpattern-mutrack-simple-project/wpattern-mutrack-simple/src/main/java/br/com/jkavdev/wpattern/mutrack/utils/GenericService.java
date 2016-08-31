package br.com.jkavdev.wpattern.mutrack.utils;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(method = RequestMethod.POST)
	public T insert(@RequestBody T entity) {

		this.logger.info(String.format("Saving entity {%s}.", entity));
		
		//uma entidade nova
		entity.setId(null);

		return this.genericRepository.save(entity);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public T update(@RequestBody T entity) {

		this.logger.info(String.format("updating the entity {%s}.", entity));
		
		if(entity.getId() == null){
			this.logger.error("The ID cannot be null.");
			return null;
		}

		return this.genericRepository.save(entity);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@RequestBody T entity) {

		this.logger.info(String.format("deleting the entity {%s}.", entity));		

		this.genericRepository.delete(entity);
	}

}
