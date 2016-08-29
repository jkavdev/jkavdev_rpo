package br.com.jkavdev.wpattern.mutrack.permission;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.jkavdev.wpattern.mutrack.utils.BaseEntity;

//Entidade permissao

@Entity
@Table(name = "tb_permission")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class PermissionEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	private String role;

	public PermissionEntity() {
	}

	public PermissionEntity(String role) {
		super();
		this.role = role;
	}

	@Column(name = "role", length = 45, nullable = false, unique = true)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
