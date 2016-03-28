package org.wpattern.frameworks.jsf.primefaces.model;

import org.wpattern.frameworks.jsf.primefaces.model.utils.BaseEntities;

public class CategoryEntity extends BaseEntities<Long> {

	private static final long serialVersionUID = 1L;

	private String categoryName;
	private String description;
	private Byte[] picture;

	public CategoryEntity() {
	}

	public CategoryEntity(String categoryName, String description, Byte[] picture) {
		this.categoryName = categoryName;
		this.description = description;
		this.picture = picture;
	}
	
	public CategoryEntity(Long id, String categoryName, String description, Byte[] picture) {
		this.setId(id);
		this.categoryName = categoryName;
		this.description = description;
		this.picture = picture;
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
