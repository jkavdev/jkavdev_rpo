package br.com.jkavdev.frameworks.jsf.primefaces.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jkavdev.frameworks.jsf.primefaces.model.CategoryEntity;

//extende de jparepository, no qual nos entrega um crud pronto
//passsando apenas a entidade e o tipo da chave primaria

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long>{
	
	

}
