package br.com.jkavdev.wpattern.mutrack.user;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.jkavdev.wpattern.mutrack.packagee.PackageeEntity;
import br.com.jkavdev.wpattern.mutrack.permission.PermissionEntity;
import br.com.jkavdev.wpattern.mutrack.utils.BaseEntity;

//Entidade Usuario

@Entity
@Table(name = "tb_user")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class UserEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	private String name;
	private String email;
	private String password;

	// mapeamento bidirecional, packagees e o lado forte
	// trara todos os pacotes
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private List<PackageeEntity> packagees;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "tb_user_permission", 
			joinColumns = @JoinColumn(name = "user_id"), 
			inverseJoinColumns = @JoinColumn(name = "permission_id"))
	private List<PermissionEntity> permissions;

	public UserEntity() {
	}

	public UserEntity(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	@Column(name = "name", length = 120, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "name", length = 255, nullable = false, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", length = 128, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PackageeEntity> getPackagees() {
		return packagees;
	}

	public void setPackagees(List<PackageeEntity> packagees) {
		this.packagees = packagees;
	}

}
