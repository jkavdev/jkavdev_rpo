package br.com.jkavdev.frameworks.jsf.primefaces.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jkavdev.frameworks.jsf.primefaces.model.ProductEntity;

public interface IProductRepository extends JpaRepository<ProductEntity, Long> {

}
