package br.com.jkavdev.hibernate.database.interfaces;

import br.com.jkavdev.hibernate.database.entities.ProductEntity;

//interface que abrigara os metodos especificos de cada dao
//se for preciso algum metodos novo
//sera informado na interface
//que obrigara que implementa a interface implementar o metodo declara aq

public interface IProductDao extends IGenericDao<ProductEntity, Long> {

}
