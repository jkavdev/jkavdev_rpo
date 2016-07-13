package br.com.jkavdev.livraria.utils.jpa;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// @Override
	// public String toString() {
	// return ToStringBuilder.reflectionToString(this,
	// ToStringStyle.MULTI_LINE_STYLE);
	// }
	//
	// @Override
	// public boolean equals(Object obj) {
	// return EqualsBuilder.reflectionEquals(this, obj);
	// }

}
