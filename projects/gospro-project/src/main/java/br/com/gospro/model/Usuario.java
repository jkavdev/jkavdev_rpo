package br.com.gospro.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.gospro.util.jpa.BaseEntity;

@Entity
@Table(name = "usuarios")
public class Usuario extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private boolean ativo;
	private UseType userRole;
	private String login;
	private String senha;

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public UseType getUserRole() {
		return userRole;
	}

	public void setUserRole(UseType userRole) {
		this.userRole = userRole;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
