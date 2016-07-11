package br.com.jkavdev.livraria.model.usuario;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import br.com.jkavdev.livraria.utils.jpa.BaseEntity;

@Entity
public class Privilegio extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private Collection<Permissao> permissoes;

	public Privilegio(String name) {
		this();
		this.name = name;
	}

	public Privilegio() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(mappedBy = "privileges")
	public Collection<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Collection<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

}
