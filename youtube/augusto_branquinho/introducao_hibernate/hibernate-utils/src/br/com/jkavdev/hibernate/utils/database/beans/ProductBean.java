package br.com.jkavdev.hibernate.utils.database.beans;

import br.com.jkavdev.hibernate.utils.beans.BaseBeans;

public class ProductBean extends BaseBeans {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String description;
	private String name;
	private Double price;
	private CategoryBean category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public CategoryBean getCategory() {
		return category;
	}

	public void setCategory(CategoryBean category) {
		this.category = category;
	}

}
