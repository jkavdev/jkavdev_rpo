package br.com.jkavdev.frameworks.jsf.primefaces.model;

import br.com.jkavdev.frameworks.jsf.primefaces.model.utils.BaseEntities;

public class CategoryEntity extends BaseEntities<Long> {

	private static final long serialVersionUID = 1L;

	private String categoryName;
	private String description;
	private Byte[] picture;

	public CategoryEntity(Long id, String categoryName, String description, Byte[] picture) {
		this(categoryName, description, picture);
		this.setId(id);
	}

	public CategoryEntity(String categoryName, String description, Byte[] picture) {
		this();
		this.categoryName = categoryName;
		this.description = description;
		this.picture = picture;
	}

	public CategoryEntity() {
		super();
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Byte[] getPicture() {
		return picture;
	}

	public void setPicture(Byte[] picture) {
		this.picture = picture;
	}

}
