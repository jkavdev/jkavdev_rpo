package br.com.jkavdev.livraria.model.usuario;

import java.util.Collection;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import br.com.jkavdev.livraria.utils.jpa.BaseEntity;

public class Usuario extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String email;
	private String password;
	private boolean enabled;
	private boolean tokenExpired;
	private Collection<Permissao> permissoes;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isTokenExpired() {
		return tokenExpired;
	}

	public void setTokenExpired(boolean tokenExpired) {
		this.tokenExpired = tokenExpired;
	}

	@ManyToMany
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "permissao_id"))
	public Collection<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Collection<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

}
