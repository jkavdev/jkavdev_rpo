package br.com.jkavdev.persistence.model.inherite;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AttributeOverride(name = "nome", column = @Column(name = "resources_nome", length = 50))
public class HumanResources extends Department implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
