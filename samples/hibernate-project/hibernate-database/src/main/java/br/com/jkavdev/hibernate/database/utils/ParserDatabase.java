package br.com.jkavdev.hibernate.database.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.jkavdev.hibernate.database.entities.CategoryEntity;
import br.com.jkavdev.hibernate.database.entities.ProductEntity;
import br.com.jkavdev.hibernate.utils.database.beans.CategoryBean;
import br.com.jkavdev.hibernate.utils.database.beans.ProductBean;

public class ParserDatabase {

	public static CategoryEntity parserBeanToEntity(CategoryBean categoryBean) {

		CategoryEntity categoryEntity = new CategoryEntity();

		// ID
		categoryEntity.setId(categoryBean.getId());

		// Description
		categoryEntity.setDescription(categoryBean.getDescription());

		// Name
		categoryEntity.setName(categoryBean.getName());

		// Products
		List<ProductEntity> products = parseProductBeansToEntities(categoryBean.getProducts());

		categoryEntity.setProducts(products);

		return categoryEntity;

	}

	public static ProductEntity parserBeanToEntity(ProductBean productBean) {

		ProductEntity product = new ProductEntity();

		// ID
		product.setId(productBean.getId());

		// Description
		product.setDescription(productBean.getDescription());

		// Price
		product.setPrice(productBean.getPrice());

		// Category
		CategoryEntity category = parserBeanToEntity(productBean.getCategory());

		product.setCategory(category);

		return product;

	}

	public static List<ProductEntity> parseProductBeansToEntities(List<ProductBean> productsBean) {

		List<ProductEntity> productsEntity = new ArrayList<ProductEntity>();

		if (productsBean != null) {
			for (ProductBean product : productsBean) {
				productsEntity.add(parserBeanToEntity(product));
			}
		}

		return productsEntity;

	}

	public static List<CategoryEntity> parseCategoryBeansToEntities(List<CategoryBean> categoriesBean) {

		List<CategoryEntity> categoriesEntity = new ArrayList<CategoryEntity>();

		if (categoriesBean != null) {
			for (CategoryBean category : categoriesBean) {
				categoriesEntity.add(parserBeanToEntity(category));
			}
		}

		return categoriesEntity;

	}

	public static CategoryBean parserEntityToBean(CategoryEntity categoryEntity) {

		CategoryBean categoryBean = new CategoryBean();

		// ID
		categoryBean.setId(categoryEntity.getId());

		// Description
		categoryBean.setDescription(categoryEntity.getDescription());

		// Name
		categoryBean.setName(categoryEntity.getName());

		// Products
		List<ProductBean> products = parseProductEntitiesToBeans(categoryEntity.getProducts());

		categoryBean.setProducts(products);

		return categoryBean;

	}

	public static ProductBean parserEntityToBean(ProductEntity productEntity) {

		ProductBean productBean = new ProductBean();

		// ID
		productBean.setId(productEntity.getId());

		// Description
		productBean.setDescription(productEntity.getDescription());

		// Price
		productBean.setPrice(productEntity.getPrice());

		// Category
		productBean
				.setCategory(parserEntityToBean(productEntity.getCategory()));

		return productBean;

	}

	public static List<ProductBean> parseProductEntitiesToBeans(List<ProductEntity> productsEntity) {

		List<ProductBean> productsBean = new ArrayList<ProductBean>();

		if (productsEntity != null) {
			for (ProductEntity product : productsEntity) {
				productsBean.add(parserEntityToBean(product));
			}
		}

		return productsBean;

	}

	public static List<CategoryBean> parseCategoryEntitiesToBeans(List<CategoryEntity> categoriesEntity) {

		List<CategoryBean> categoriesBean = new ArrayList<CategoryBean>();

		if (categoriesEntity != null) {
			for (CategoryEntity category : categoriesEntity) {
				categoriesBean.add(parserEntityToBean(category));
			}
		}

		return categoriesBean;

	}

}