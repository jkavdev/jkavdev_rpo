package org.wpattern.frameworks.hibernate4.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.wpattern.frameworks.hibernate4.utils.BaseBean;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseBean {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String categoryName;
	private String description;
	private Byte[] picture;

	public CategoryEntity() {
	}

	public CategoryEntity(Long id, String categoryName, String description, Byte[] picture) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.description = description;
		this.picture = picture;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CategoryName")
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Column(name = "Description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Picture")
	public Byte[] getPicture() {
		return picture;
	}

	public void setPicture(Byte[] picture) {
		this.picture = picture;
	}

}
