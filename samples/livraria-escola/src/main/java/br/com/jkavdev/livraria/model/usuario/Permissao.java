package br.com.jkavdev.livraria.model.usuario;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import br.com.jkavdev.livraria.utils.jpa.BaseEntity;

@Entity
public class Permissao extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String nome;
	private Collection<Usuario> usuario;
	private Collection<Privilegio> privilegios;

	public Permissao(String nome) {
		this();
		this.nome = nome;
	}

	public Permissao() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ManyToMany(mappedBy = "permissoes")
	public Collection<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(Collection<Usuario> usuario) {
		this.usuario = usuario;
	}

	@ManyToMany
	@JoinTable(name = "roles_privileges", joinColumns = @JoinColumn(name = "pemissao_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "privilegio_id", referencedColumnName = "id"))
	public Collection<Privilegio> getPrivilegios() {
		return privilegios;
	}

	public void setPrivilegios(Collection<Privilegio> privilegios) {
		this.privilegios = privilegios;
	}

}
