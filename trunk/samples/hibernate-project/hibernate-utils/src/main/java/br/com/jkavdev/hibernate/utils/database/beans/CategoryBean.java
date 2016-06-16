package br.com.jkavdev.hibernate.utils.database.beans;

import java.util.List;

import br.com.jkavdev.hibernate.utils.beans.BaseBeans;

public class CategoryBean extends BaseBeans {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String description;
	private List<ProductBean> products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProductBean> getProducts() {
		return products;
	}

	public void setProducts(List<ProductBean> products) {
		this.products = products;
	}

}
